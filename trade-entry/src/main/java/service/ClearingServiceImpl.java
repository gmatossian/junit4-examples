package service;

import dao.TradeDao;
import domain.Trade;
import messaging.MessageBuilder;
import messaging.MessagePublisher;
import validator.TradeValidator;

public class ClearingServiceImpl implements ClearingService {

	private TradeDao tradeDao;
	private TradeValidator tradeValidator;
	private MessageBuilder messageBuilder;
	private MessagePublisher messagePuslisher;
	
	@Override
	public void clear(Trade trade) throws Exception {
		tradeValidator.validate(trade);
		tradeDao.save(trade);
		messagePuslisher.publish(messageBuilder.buildMessage(trade));
	}

	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

	public void setTradeValidator(TradeValidator tradeValidator) {
		this.tradeValidator = tradeValidator;
	}

	public void setMessagePuslisher(MessagePublisher messagePuslisher) {
		this.messagePuslisher = messagePuslisher;
	}

	public void setMessageBuilder(MessageBuilder messageBuilder) {
		this.messageBuilder = messageBuilder;
	}

}
