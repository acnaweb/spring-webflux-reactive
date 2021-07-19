package com.github.acnaweb.springwebfluxreactive.domain.post.event;

import com.github.acnaweb.springwebfluxreactive.domain.post.dto.CreatedPostDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreatedPostEvent extends ApplicationEvent {
	private static final long serialVersionUID = -5243576149722844754L;

	public CreatedPostEvent(CreatedPostDto source) {
		super(source);
	}

}
