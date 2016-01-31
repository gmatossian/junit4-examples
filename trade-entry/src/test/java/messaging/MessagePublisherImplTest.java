package messaging;

import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class MessagePublisherImplTest {

	private JmsTemplate jmsTemplate;
	
	@Test
	public void testPublish() {
		JmsTemplate jmsTemplate = mock(JmsTemplate.class);
		
		MessagePublisherImpl messagePublisher = new MessagePublisherImpl();
		messagePublisher.setJmsTemplate(jmsTemplate);
		
		String message = "Hola!";
		
		messagePublisher.publish(message);
		
		verify(jmsTemplate).send(anyObject());
	}
}
