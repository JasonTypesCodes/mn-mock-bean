package ex;

import javax.inject.Singleton;

import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;

@Singleton
@Requires(property = "service.enabled", value = StringUtils.TRUE)
public class MessageService {
	public Message getMessage() {
		return new Message("From the service");
	}
}
