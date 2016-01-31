package dao;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Trade;

import static org.junit.Assert.*;

public class TradeDaoImplTest {

	@Test
	public void testSave() {
		JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
		
		TradeDaoImpl tradeDao = new TradeDaoImpl();
		tradeDao.setJdbcTemplate(jdbcTemplate);
		
		Trade trade = new Trade();
		trade.setBuyer("Gabriel");
		trade.setSeller("Eamonn");
		trade.setProduct("CL");
		trade.setQuantity(50000);
		trade.setPrice(65D);
		
		tradeDao.save(trade);
		

		String sql = "INSERT INTO TRADE (BUYER, SELLER, PRODUCT, QUANTITY, PRICE) VALUES (?,?,?,?,?)";
		
		verify(jdbcTemplate).update(sql, "Gabriel", "Eamonn", "CL", 50000, 65D);
	}
}
