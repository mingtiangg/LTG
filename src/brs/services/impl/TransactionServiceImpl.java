package brs.services.impl;

import brs.*;
import brs.db.BurstKey;
import brs.services.AccountService;
import brs.services.TransactionService;
import brs.util.Convert;

import static brs.Constants.MAIN_ACCOUNT;
import static brs.Constants.ONE_DAY;
import static brs.schema.Tables.ACCOUNT_RANSOM;

public class TransactionServiceImpl implements TransactionService {

    private final AccountService accountService;
    private final Blockchain blockchain;

    public TransactionServiceImpl(AccountService accountService, Blockchain blockchain) {
        this.accountService = accountService;
        this.blockchain = blockchain;
    }

    @Override
    public boolean verifyPublicKey(Transaction transaction) {
        Account account = accountService.getAccount(transaction.getSenderId());
        if (account == null) {
            return false;
        }
        if (transaction.getSignature() == null) {
            return false;
        }
        return account.setOrVerify(transaction.getSenderPublicKey(), transaction.getHeight());
    }

    @Override
    public void validate(Transaction transaction) throws BurstException.ValidationException {
        for (Appendix.AbstractAppendix appendage : transaction.getAppendages()) {
            appendage.validate(transaction);
        }
        long senderId = transaction.getSenderId();
        //Account account = accountService.getAccount(senderId);
        byte transType = transaction.getTransType();
        long recipientId = transaction.getRecipientId();
        //check transType
        if (transType == 1) {
            if (recipientId != MAIN_ACCOUNT) {
                //错误的抵押人
                throw new BurstException.NotValidException(String.format("Wrong pledge account %s", recipientId));
            }
        /*    //判断是否超过总账号质押的30%
            Account mainAccount = accountService.getAccount(recipientId);
            long mainAccountPledge = mainAccount.getPledge();
            long senderAccountPledge = senderAccount.getPledge();
            long totalPledge = senderAccountPledge + transaction.getAmountNQT();
            if (totalPledge > mainAccountPledge * 1.3) {
                throw new BurstException.NotValidException(String.format("exceed pledge current limitation %s", senderAccountPledge * 1.3));
            }*/
        } else if (transType == 2) {
           /* if (account.getStatus() != 1) {
                throw new BurstException.NotValidException(String.format("Wrong account status %s", account.getStatus()));
            }*/
            if (recipientId != MAIN_ACCOUNT) {
                //错误的发送人
                throw new BurstException.NotValidException(String.format("Wrong pledge account %s", recipientId));
            }
        } else if (transType == 3) {
            if (senderId != MAIN_ACCOUNT) {
                //错误的发送人
                throw new BurstException.NotValidException(String.format("Wrong redeem account %s", senderId));
            }
        } else {
            //1.正常交易
            long minimumFeeNQT = transaction.getType().minimumFeeNQT(blockchain.getHeight(), transaction.getAppendagesSize());
            if (transaction.getFeeNQT() < minimumFeeNQT) {
                throw new BurstException.NotCurrentlyValidException(String.format("Transaction fee %d less than minimum fee %d at height %d",
                        transaction.getFeeNQT(), minimumFeeNQT, blockchain.getHeight()));
            }
        }
    }

    @Override
    public boolean applyUnconfirmed(Transaction transaction) {
        Account senderAccount = accountService.getAccount(transaction.getSenderId());
        return senderAccount != null && transaction.getType().applyUnconfirmed(transaction, senderAccount);
    }

    @Override
    public void apply(Transaction transaction) {
        //check is pledge or not
        Account senderAccount = accountService.getAccount(transaction.getSenderId());
        Account recipientAccount = accountService.getOrAddAccount(transaction.getRecipientId());
        byte transType = transaction.getTransType();
        long pledgeAmount;
        if (transType == 1) {
            if (transaction.getRecipientId() == MAIN_ACCOUNT) {
                //质押
                pledgeAmount = Convert.safeAdd(transaction.getAmountNQT(), senderAccount.getPledge());
                senderAccount.setPledge(pledgeAmount);
                //senderAccount.setStatus((byte) 1);
            } else {
                return;
            }
        } else if (transType == 2) {
            /*if (senderAccount.getStatus() == 2) {
                return;
            }*/
            if (transaction.getRecipientId() == MAIN_ACCOUNT) {
                pledgeAmount = Convert.safeSubtract(senderAccount.getPledge(), transaction.getAmountNQT());
                senderAccount.setPledge(pledgeAmount);
                //申请赎回
                long applyTime = (transaction.getTimestamp() * 1000l + Constants.EPOCH_BEGINNING - 500);
                accountService.insertNewAccountRansom(senderAccount.getId(), transaction.getAmountNQT(), applyTime);
            } else {
                return;
            }
        } else if (transType == 3) {
            if (transaction.getSenderId() == MAIN_ACCOUNT) {
                //赎回
                //long applyTime = (transaction.getTimestamp() * 1000l + Constants.EPOCH_BEGINNING - 500);
                long ransomTime = transaction.getRansomTime();
                Account.AccountRansom accountRansom = accountService.getAccountRansom(recipientAccount.getId(), ransomTime);
                //recipientAccount.setLastRedeemTime(redeemTime);
                //accountRansom.setStatus((byte)0);
                //accountService.delete(accountRansom);
                accountRansom.setRansom(0);
                accountService.insertAccountRansom(accountRansom);
            } else {
                return;
            }
        }
        senderAccount.apply(transaction.getSenderPublicKey(), transaction.getHeight());
        for (Appendix.AbstractAppendix appendage : transaction.getAppendages()) {
            appendage.apply(transaction, senderAccount, recipientAccount);
        }
    }

    @Override
    public void undoUnconfirmed(Transaction transaction) {
        final Account senderAccount = accountService.getAccount(transaction.getSenderId());
        transaction.getType().undoUnconfirmed(transaction, senderAccount);
    }

}
