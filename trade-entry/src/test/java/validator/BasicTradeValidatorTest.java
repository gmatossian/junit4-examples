package validator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.Matchers.*;

import domain.Trade;

public class BasicTradeValidatorTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testValidateWithFullyPopulatedTrade() throws Exception {
		Trade trade = new Trade();
		
		trade.setBuyer("Mark");
		trade.setSeller("Stephen");
		trade.setProduct("Electricity");
		
		BasicTradeValidator validator = new BasicTradeValidator();
		validator.validate(trade);
	}

	@Test
	public void testValidateWithNoBuyer() throws Exception {
		Trade trade = new Trade();
		
		trade.setSeller("Stephen");
		trade.setProduct("Electricity");
		
		thrown.expect(Exception.class);
        thrown.expectMessage(equalTo("Buyer cannot be empty"));
		
		BasicTradeValidator validator = new BasicTradeValidator();
		validator.validate(trade);
	}

	@Test
	public void testValidateWithNoSeller() throws Exception {
		Trade trade = new Trade();
		
		trade.setBuyer("Mark");
		trade.setProduct("Electricity");
		
		thrown.expect(Exception.class);
        thrown.expectMessage(equalTo("Seller cannot be empty"));
		
		BasicTradeValidator validator = new BasicTradeValidator();
		validator.validate(trade);
	}

	@Test
	public void testValidateWithNoProduct() throws Exception {
		Trade trade = new Trade();
		
		trade.setBuyer("Mark");
		trade.setSeller("Stephen");
		
		thrown.expect(Exception.class);
        thrown.expectMessage(equalTo("Product cannot be empty"));
		
		BasicTradeValidator validator = new BasicTradeValidator();
		validator.validate(trade);
	}
}
