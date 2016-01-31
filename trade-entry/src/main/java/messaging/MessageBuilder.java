package messaging;

import domain.Trade;

/**
 * Class for building messages to publish
 * @author E22191
 *
 */
public class MessageBuilder {

	public String buildMessage(Trade trade) {
		StringBuilder sb = new StringBuilder();
		sb.append("<trade>");
		sb.append("<buyer>").append(nvl(trade.getBuyer(), "")).append("</buyer>");
		sb.append("<seller>").append(nvl(trade.getSeller(), "")).append("</seller>");
		sb.append("<product>").append(nvl(trade.getProduct(), "")).append("</product>");
		sb.append("<quantity>").append(nvl(trade.getQuantity(), "")).append("</quantity>");
		sb.append("<price>").append(nvl(trade.getPrice(), "")).append("</price>");
		sb.append("</trade>");
		return sb.toString();
	}
	
	private Object nvl(Object... expressions) {	// Should be somewhere else
		int i = 0;
		Object expression = null;
		while(i < expressions.length && expression == null) {
			expression = expressions[i++];
		}
		
		return expression;
	}
}
