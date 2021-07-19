package com.github.acnaweb.springwebfluxreactive.api.post;

import com.github.acnaweb.springwebfluxreactive.application.post.CreatePostUseCase;
import com.github.acnaweb.springwebfluxreactive.application.post.PostDto;
import com.github.acnaweb.springwebfluxreactive.application.post.PostForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

	private final CreatePostUseCase createPostUseCase;

	@PostMapping
	public ResponseEntity<PostDto> create(@RequestBody PostForm dto) {
		var result = createPostUseCase.apply(dto);
		return ResponseEntity.ok().body(result);
	}
}
