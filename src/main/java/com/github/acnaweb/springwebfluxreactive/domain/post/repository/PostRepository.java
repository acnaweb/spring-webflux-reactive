package com.github.acnaweb.springwebfluxreactive.domain.post.repository;

import com.github.acnaweb.springwebfluxreactive.domain.post.model.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class PostRepository {
	private List<Post> posts = new ArrayList<>();

	public Post save(Post post) {
		post.setId(UUID.randomUUID());
		posts.add(post);
		return post;
	}

	public long count() {
		return posts.size();
	}

	public long countByUserId(Long userId) {
		return posts.stream().filter(p -> p.getUser().getId().equals(userId)).count();
	}

	public List<Post> findAll() {
		return posts.stream().collect(Collectors.toList());
	}

}
