package com.github.acnaweb.springwebfluxreactive.api.notification;

import com.github.acnaweb.springwebfluxreactive.application.post.listener.CreatePostListener;
import com.github.acnaweb.springwebfluxreactive.application.post.listener.PostCounterListener;
import com.github.acnaweb.springwebfluxreactive.domain.post.dto.CreatedPostDto;
import com.github.acnaweb.springwebfluxreactive.domain.post.dto.PostCounterDto;
import com.github.acnaweb.springwebfluxreactive.domain.post.event.CreatedPostEvent;
import com.github.acnaweb.springwebfluxreactive.domain.post.event.PostCounterEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	private final Flux<CreatedPostEvent> createdPostevents;
	private final Flux<PostCounterEvent> postCounterEvent;

	public NotificationController(CreatePostListener createPostListener, PostCounterListener postCounterListener) {
		this.createdPostevents = Flux.create(createPostListener).share();
		this.postCounterEvent = Flux.create(postCounterListener).share();
	}

	@CrossOrigin()
	@GetMapping(value = "/posts/sse", produces = "text/event-stream;charset=UTF-8")
	public Flux<CreatedPostDto> streamCreated() {
		System.out.println("Start listening to the posts");
		return this.createdPostevents.map(event -> {
			return (CreatedPostDto) event.getSource();
		});
	}

	@CrossOrigin()
	@GetMapping(value = "/posts/count/sse", produces = "text/event-stream;charset=UTF-8")
	public Flux<PostCounterDto> streamCount() {
		System.out.println("Start listening to the counters");
		return this.postCounterEvent.map(event -> {
			return (PostCounterDto) event.getSource();
		});
	}
}
