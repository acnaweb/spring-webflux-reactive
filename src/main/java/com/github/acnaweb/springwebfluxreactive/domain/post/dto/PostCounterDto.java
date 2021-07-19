package com.github.acnaweb.springwebfluxreactive.domain.post.dto;

import java.time.Instant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostCounterDto {
	private final Long userId;
	private final long total;
	private Instant timestamp = Instant.now();
}
