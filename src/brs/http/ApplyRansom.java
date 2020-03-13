package brs.http;

import brs.Account;
import brs.BurstException;
import brs.services.AccountService;
import brs.services.ParameterService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static brs.Constants.MAIN_ACCOUNT;
import static brs.http.common.Parameters.*;
import static brs.http.common.ResultFields.WRONG_PLEDGE_RESPONSE;

public final class ApplyRansom extends CreateTransaction {

    private final ParameterService parameterService;
    private final AccountService accountService;

    ApplyRansom(AccountService accountService, ParameterService parameterService, APITransactionManager apiTransactionManager) {
        super(new APITag[]{APITag.ACCOUNTS, APITag.CREATE_TRANSACTION}, apiTransactionManager, RECIPIENT_PARAMETER,TRANS_TYPE,AMOUNT_NQT_PARAMETER);
        this.parameterService = parameterService;
        this.accountService = accountService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws BurstException {
        //trans_type 1 pledge 2 apply for redeem 3 redeem
        //质押不能超过总账号质押的30%
        long recipient = ParameterParser.getRecipientId(req);
        long amountNQT = ParameterParser.getAmountNQT(req);
        Account account = parameterService.getSenderAccount(req);
        if (recipient != MAIN_ACCOUNT) {
            JsonObject response = new JsonObject();
            response.addProperty(WRONG_PLEDGE_RESPONSE, recipient);
            return response;
        }
        return createTransaction(req, account, recipient, amountNQT);
    }

}
