package validator;

import domain.Trade;

/**
 * Interface defining the contract for trade validators
 * @author E22191
 *
 */
public interface TradeValidator {

	void validate(Trade trade) throws Exception;
}
