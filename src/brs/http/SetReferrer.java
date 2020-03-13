/*
package brs.http;

import brs.Account;
import brs.BurstException;
import brs.services.AccountService;
import brs.services.ParameterService;
import brs.util.Convert;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static brs.http.JSONResponses.MISSING_SECRET_PHRASE;
import static brs.http.common.Parameters.*;
import static brs.http.common.ResultFields.ACCOUNT_RESPONSE;

public final class SetReferrer extends CreateTransaction {

    private final ParameterService parameterService;

    SetReferrer(ParameterService parameterService, APITransactionManager apiTransactionManager) {
        super(new APITag[]{APITag.ACCOUNTS, APITag.CREATE_TRANSACTION}, apiTransactionManager, REFERRER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws BurstException {
        long referrerId = ParameterParser.getReferrerId(req);
        Account account = parameterService.getSenderAccount(req);
        account.setReferrer(referrerId);
        return createTransaction(req, account, 0l, 0);
    }

}
*/
