package service;

import domain.Trade;

/**
 * Interface defining the contract for the clearing service
 * @author E22191
 *
 */
public interface ClearingService {

	/**
	 * This method clears {@link Trade} objects
	 * That means storing the trade information as well as notifying other systems
	 * @param trade the trade to clear
	 */
	void clear(Trade trade) throws Exception;
}
