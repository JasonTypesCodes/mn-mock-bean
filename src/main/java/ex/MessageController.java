package ex;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/message")
public class MessageController {
	private MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@Get
	public Message get() {
		return messageService.getMessage();
	}
}
