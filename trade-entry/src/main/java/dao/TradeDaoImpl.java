package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import domain.Trade;

/**
 * Implementation of {@link TradeDao}
 * @author E22191
 *
 */
public class TradeDaoImpl implements TradeDao {
	
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public void save(Trade trade) {
		String sql = "INSERT INTO TRADE (BUYER, SELLER, PRODUCT, QUANTITY, PRICE) VALUES (?,?,?,?,?)";

		jdbcTemplate.update(sql, 
				trade.getBuyer(), 
				trade.getSeller(), 
				trade.getProduct(), 
				trade.getQuantity(),
				trade.getPrice());
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
