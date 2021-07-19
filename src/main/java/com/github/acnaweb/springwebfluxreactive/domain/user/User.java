package com.github.acnaweb.springwebfluxreactive.domain.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class User {
	@EqualsAndHashCode.Include
	private final Long id;
	private String username;

}
