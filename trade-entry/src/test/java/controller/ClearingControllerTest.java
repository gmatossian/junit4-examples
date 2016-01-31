package controller;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import builder.TradeBuilder;
import service.ClearingService;

public class ClearingControllerTest {
	
	@Test
	public void testDoPostWithSuccessfullClearing() throws Exception {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		TradeBuilder tradeBuilder = mock(TradeBuilder.class);
		ClearingService clearingService = mock(ClearingService.class);
		ClearingController controller = mock(ClearingController.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(controller.getTradeBuilder()).thenReturn(tradeBuilder);
		when(controller.getClearingService()).thenReturn(clearingService);		
		when(resp.getWriter()).thenReturn(writer);
		
		doCallRealMethod().when(controller).doPost(req, resp);
		
		controller.doPost(req, resp);
		
		verify(writer).println("Trade cleared");
	}
	
	@Test
	public void testDoPostWithUnsuccessfullClearing() throws Exception {
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		TradeBuilder tradeBuilder = mock(TradeBuilder.class);
		ClearingService clearingService = mock(ClearingService.class);
		ClearingController controller = mock(ClearingController.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(controller.getTradeBuilder()).thenReturn(tradeBuilder);
		when(controller.getClearingService()).thenReturn(clearingService);		
		doThrow(new Exception()).when(clearingService).clear(anyObject());		
		when(resp.getWriter()).thenReturn(writer);
		
		doCallRealMethod().when(controller).doPost(req, resp);
		
		controller.doPost(req, resp);
		
		verify(writer).println("Server error, trade not cleared");
	}
}
