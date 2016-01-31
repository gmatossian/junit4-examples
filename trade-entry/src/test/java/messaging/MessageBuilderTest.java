package messaging;

import static org.mockito.Mockito.*;

import org.junit.Test;

import domain.Trade;

import static org.junit.Assert.*;

public class MessageBuilderTest {

	@Test
	public void testBuildMessageWithFullyPopulatedTrade() {
		Trade trade = new Trade();
		trade.setBuyer("Gabriel");
		trade.setSeller("Juan");
		trade.setProduct("NG");
		trade.setQuantity(10000);
		trade.setPrice(45.5);
		
		StringBuilder expected = new StringBuilder("<trade>");
		expected.append("<buyer>Gabriel</buyer>");
		expected.append("<seller>Juan</seller>");
		expected.append("<product>NG</product>");
		expected.append("<quantity>10000</quantity>");
		expected.append("<price>45.5</price>");
		expected.append("</trade>");
		
		MessageBuilder messageBuilder = new MessageBuilder();
		String message = messageBuilder.buildMessage(trade);
		
		assertEquals(expected.toString(), message);
	}
	
	@Test
	public void testBuildMessageWithEmptyTrade() {
		Trade trade = new Trade();
		
		StringBuilder expected = new StringBuilder("<trade>");
		expected.append("<buyer></buyer>");
		expected.append("<seller></seller>");
		expected.append("<product></product>");
		expected.append("<quantity></quantity>");
		expected.append("<price></price>");
		expected.append("</trade>");

		MessageBuilder messageBuilder = new MessageBuilder();
		String message = messageBuilder.buildMessage(trade);
		
		assertEquals(expected.toString(), message);
	}
}
