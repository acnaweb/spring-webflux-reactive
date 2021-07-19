package com.github.acnaweb.springwebfluxreactive.application.post;

import com.github.acnaweb.springwebfluxreactive.domain.post.dto.CreatedPostDto;
import com.github.acnaweb.springwebfluxreactive.domain.post.dto.PostCounterDto;
import com.github.acnaweb.springwebfluxreactive.domain.post.event.CreatedPostEvent;
import com.github.acnaweb.springwebfluxreactive.domain.post.event.PostCounterEvent;
import com.github.acnaweb.springwebfluxreactive.domain.post.service.PostService;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostUseCase implements Function<PostForm, PostDto> {
	private final PostService postService;
	private final ApplicationEventPublisher publisher;

	@Override
	public PostDto apply(PostForm form) {
		var post = form.build();

		// domain service
		post = postService.create(post);

		// publish
		publisher.publishEvent(new CreatedPostEvent(new CreatedPostDto(post)));

		var countByUser = postService.countByUserId(post.getUser().getId());

		publisher.publishEvent(new PostCounterEvent(new PostCounterDto(post.getUser().getId(), countByUser)));

		return new PostDto().build(post);
	}

}
