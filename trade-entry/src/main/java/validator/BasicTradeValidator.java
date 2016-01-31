package validator;

import domain.Trade;

/**
 * This class containts the basic validations for a trade
 * @author E22191
 *
 */
public class BasicTradeValidator implements TradeValidator {

	@Override
	public void validate(Trade trade) throws Exception {
		if(trade.getBuyer() == null) {
			throw new Exception("Buyer cannot be empty");
		}
		if(trade.getSeller() == null) {
			throw new Exception("Seller cannot be empty");
		}
		if(trade.getProduct() == null) {
			throw new Exception("Product cannot be empty");
		}
	}

}
