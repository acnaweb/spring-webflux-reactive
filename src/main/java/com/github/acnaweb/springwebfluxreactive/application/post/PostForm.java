package com.github.acnaweb.springwebfluxreactive.application.post;

import com.github.acnaweb.springwebfluxreactive.domain.post.model.Post;
import com.github.acnaweb.springwebfluxreactive.domain.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostForm {
	@EqualsAndHashCode.Include
	private String message;
	private Long userId;

	public Post build() {
		var post = new Post();
		post.setMessage(this.getMessage());
		post.setUser(new User(this.getUserId()));
		return post;
	}
}
