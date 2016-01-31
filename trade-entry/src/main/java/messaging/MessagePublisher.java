package messaging;

public interface MessagePublisher<T> {

	void publish(T message);
}
