package com.github.acnaweb.springwebfluxreactive.application.post;

import com.github.acnaweb.springwebfluxreactive.domain.post.model.Post;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
	private UUID id;
	private String message;
	private Long userId;
	private Instant timestamp = Instant.now();

	public PostDto build(Post post) {
		this.setId(post.getId());
		this.setMessage(post.getMessage());
		this.setUserId(post.getUser().getId());
		return this;
	}
}
