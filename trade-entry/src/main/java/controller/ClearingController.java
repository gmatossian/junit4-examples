package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import builder.TradeBuilder;
import domain.Trade;
import service.ClearingService;

/**
 * Controller handling trade submissions
 * @author E22191
 *
 */
public class ClearingController extends HttpServlet {
	
	private TradeBuilder tradeBuilder;
	private ClearingService clearingService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Trade trade = getTradeBuilder().build(req);
			getClearingService().clear(trade);
			resp.getWriter().println("Trade cleared");
		} catch (Exception e) {
			resp.getWriter().println("Server error, trade not cleared");
		}
	}

	public TradeBuilder getTradeBuilder() {
		return tradeBuilder;
	}

	public void setTradeBuilder(TradeBuilder tradeBuilder) {
		this.tradeBuilder = tradeBuilder;
	}

	public ClearingService getClearingService() {
		return clearingService;
	}

	public void setClearingService(ClearingService clearingService) {
		this.clearingService = clearingService;
	}
}
