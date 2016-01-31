package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TradeDao;
import domain.Trade;
import messaging.MessagePublisher;

public class UntestableClearingController extends HttpServlet {
	
	private TradeDao tradeDao;
	private MessagePublisher<String> messagePublisher;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Trade trade = new Trade();
			trade.setBuyer(req.getParameter("buyer"));
			trade.setSeller(req.getParameter("seller"));
			trade.setProduct(req.getParameter("product"));
			trade.setQuantity(req.getParameter("quantity") != null ? Integer.valueOf(req.getParameter("quantity")) : null);
			trade.setPrice(req.getParameter("price") != null ? Double.valueOf(req.getParameter("price")) : null);
			
			if(trade.getBuyer() == null) {
				throw new Exception("Buyer cannot be empty");
			}
			if(trade.getSeller() == null) {
				throw new Exception("Seller cannot be empty");
			}
			if(trade.getProduct() == null) {
				throw new Exception("Product cannot be empty");
			}
			
			tradeDao.save(trade);
			
			StringBuilder sb = new StringBuilder();
			sb.append("<trade>");
			sb.append("<buyer>").append(nvl(trade.getBuyer(), "")).append("</buyer>");
			sb.append("<seller>").append(nvl(trade.getSeller(), "")).append("</seller>");
			sb.append("<product>").append(nvl(trade.getProduct(), "")).append("</product>");
			sb.append("<quantity>").append(nvl(trade.getQuantity(), "")).append("</quantity>");
			sb.append("<price>").append(nvl(trade.getPrice(), "")).append("</price>");
			sb.append("</trade>");
			
			messagePublisher.publish(sb.toString());
			
			resp.getWriter().println("Trade cleared");
		} catch (Exception e) {
			resp.getWriter().println("Server error, trade not cleared");
		}
	}
	
	private Object nvl(Object... expressions) {	// Should be somewhere else
		int i = 0;
		Object expression = null;
		while(i < expressions.length && expression == null) {
			expression = expressions[i++];
		}
		
		return expression;
	}

	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

	public void setMessagePublisher(MessagePublisher<String> messagePublisher) {
		this.messagePublisher = messagePublisher;
	}
}
