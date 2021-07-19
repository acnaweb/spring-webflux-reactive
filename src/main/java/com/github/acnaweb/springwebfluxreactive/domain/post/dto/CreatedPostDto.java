package com.github.acnaweb.springwebfluxreactive.domain.post.dto;

import com.github.acnaweb.springwebfluxreactive.domain.post.model.Post;
import java.time.Instant;
import lombok.Getter;

@Getter
public class CreatedPostDto {
	private Long userId;
	private String message;
	private Instant timestamp = Instant.now();

	public CreatedPostDto(Post post) {
		this.userId = post.getUser().getId();
		this.message = post.getMessage();
	}
}
