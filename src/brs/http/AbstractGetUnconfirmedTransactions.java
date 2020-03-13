package brs.http;

abstract class AbstractGetUnconfirmedTransactions extends APIServlet.APIRequestHandler {

  AbstractGetUnconfirmedTransactions(APITag[] apiTags, String... parameters) {
    super(apiTags, parameters);
  }
}
