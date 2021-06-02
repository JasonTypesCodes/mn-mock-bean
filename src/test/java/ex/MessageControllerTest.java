package ex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
public class MessageControllerTest {

	@Inject
	@Client("/")
	HttpClient client;

	@MockBean(MessageService.class)
	public MessageService mockService() {
		return new FakeMessageService();
	}

	@Test
	public void testMessageController() {
		Message result = client.toBlocking().retrieve(HttpRequest.GET("/message"), Message.class);

		assertEquals("From mock", result.getMessage());
	}

	class FakeMessageService extends MessageService {
		@Override
		public Message getMessage() {
			return new Message("From mock");
		}
	}
}
