package dao;

import domain.Trade;

/**
 * Interface defining the contract for the trade dao
 * @author E22191
 *
 */
public interface TradeDao {

	/**
	 * This method saves a {@link Trade} object
	 * @param trade
	 */
	void save(Trade trade);
}
