package com.github.acnaweb.springwebfluxreactive.domain.post.service;

import com.github.acnaweb.springwebfluxreactive.domain.post.model.Post;
import com.github.acnaweb.springwebfluxreactive.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;

	public Post create(Post post) {
		post = postRepository.save(post);
		System.out.println(post);
		return post;
	}

	public long count() {
		return postRepository.count();
	}

	public long countByUserId(Long userId) {
		return postRepository.countByUserId(userId);
	}
}
