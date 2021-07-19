package com.github.acnaweb.springwebfluxreactive.domain.post.model;

import com.github.acnaweb.springwebfluxreactive.domain.user.User;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {
	@EqualsAndHashCode.Include
	private UUID id;
	private String message;
	private User user;
}
