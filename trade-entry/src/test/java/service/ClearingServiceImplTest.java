package service;

import static org.mockito.Mockito.*;

import org.junit.Test;

import dao.TradeDao;
import domain.Trade;
import messaging.MessageBuilder;
import messaging.MessagePublisher;
import validator.TradeValidator;

public class ClearingServiceImplTest {

	@Test
	public void testClear() throws Exception {
		TradeValidator tradeValidator = mock(TradeValidator.class);
		TradeDao tradeDao = mock(TradeDao.class);
		MessageBuilder messageBuilder = mock(MessageBuilder.class);
		MessagePublisher<String> messagePublisher = mock(MessagePublisher.class);
		Trade trade = mock(Trade.class);
		
		when(messageBuilder.buildMessage(trade)).thenReturn("Yipee ki-yay");
		
		ClearingServiceImpl clearingService = new ClearingServiceImpl();
		clearingService.setTradeValidator(tradeValidator);
		clearingService.setTradeDao(tradeDao);
		clearingService.setMessageBuilder(messageBuilder);
		clearingService.setMessagePuslisher(messagePublisher);
		
		clearingService.clear(trade);
		
		verify(tradeValidator).validate(trade);
		verify(tradeDao).save(trade);
		verify(messageBuilder).buildMessage(trade);
		verify(messagePublisher).publish("Yipee ki-yay");
	}
}
