package com.github.acnaweb.springwebfluxreactive.domain.post.event;

import com.github.acnaweb.springwebfluxreactive.domain.post.dto.PostCounterDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PostCounterEvent extends ApplicationEvent {
	private static final long serialVersionUID = 709495791026880567L;

	public PostCounterEvent(PostCounterDto source) {
		super(source);
	}

}
