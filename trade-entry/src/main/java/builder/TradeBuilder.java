package builder;

import javax.servlet.http.HttpServletRequest;

import domain.Trade;

/**
 * Class for building {@link Trade} objects
 * @author E22191
 *
 */
public class TradeBuilder {
	
	public static final String BUYER_PARAM_KEY = "buyer";
	public static final String SELLER_PARAM_KEY = "seller";
	public static final String PRODUCT_PARAM_KEY = "product";
	public static final String QUANTITY_PARAM_KEY = "quantity";
	public static final String PRICE_PARAM_KEY = "price";	

	/**
	 * Method for building a {@link Trade} object from the data in a {@link HttpServletRequest}
	 * @param request
	 * @return
	 */
	public Trade build(HttpServletRequest request) {
		Trade trade = new Trade();
		trade.setBuyer(request.getParameter(BUYER_PARAM_KEY));
		trade.setSeller(request.getParameter(SELLER_PARAM_KEY));
		trade.setProduct(request.getParameter(PRODUCT_PARAM_KEY));
		String quantity = request.getParameter(QUANTITY_PARAM_KEY);
		if(quantity != null) {
			trade.setQuantity(Integer.valueOf(request.getParameter(QUANTITY_PARAM_KEY)));	
		}
		String price = request.getParameter(PRICE_PARAM_KEY);
		if(price != null) {
			trade.setPrice(Double.valueOf(request.getParameter(PRICE_PARAM_KEY)));	
		}
		return trade;
	}
}
