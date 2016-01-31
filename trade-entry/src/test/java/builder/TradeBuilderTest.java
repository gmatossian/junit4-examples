package builder;

import org.junit.Test;

import domain.Trade;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;


public class TradeBuilderTest {

	@Test
	public void testBuildWithValidValues() {
		HttpServletRequest req = mock(HttpServletRequest.class);
		
		when(req.getParameter("buyer")).thenReturn("Gabriel");
		when(req.getParameter("seller")).thenReturn("Eamonn");
		when(req.getParameter("product")).thenReturn("CL");
		when(req.getParameter("quantity")).thenReturn("50000");
		when(req.getParameter("price")).thenReturn("65");
		
		TradeBuilder builder = new TradeBuilder();
		Trade trade = builder.build(req);
		
		assertEquals("Gabriel", trade.getBuyer());
		assertEquals("Eamonn", trade.getSeller());
		assertEquals("CL", trade.getProduct());
		assertEquals(Integer.valueOf(50000), trade.getQuantity());
		assertEquals(Double.valueOf(65), trade.getPrice());
	}

	@Test
	public void testBuildWithNoQuantity() {
		HttpServletRequest req = mock(HttpServletRequest.class);
		
		when(req.getParameter("quantity")).thenReturn(null);
		
		TradeBuilder builder = new TradeBuilder();
		Trade trade = builder.build(req);
		
		assertEquals(null, trade.getQuantity());
	}

	@Test
	public void testBuildWithNoPrice() {
		HttpServletRequest req = mock(HttpServletRequest.class);

		when(req.getParameter("price")).thenReturn(null);
		
		TradeBuilder builder = new TradeBuilder();
		Trade trade = builder.build(req);
		
		assertEquals(null, trade.getPrice());
	}
}
