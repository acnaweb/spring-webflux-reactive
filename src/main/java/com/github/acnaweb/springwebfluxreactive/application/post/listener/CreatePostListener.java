package com.github.acnaweb.springwebfluxreactive.application.post.listener;

import com.github.acnaweb.springwebfluxreactive.domain.post.event.CreatedPostEvent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import reactor.core.publisher.FluxSink;

@Component
@RequiredArgsConstructor
public class CreatePostListener implements ApplicationListener<CreatedPostEvent>, Consumer<FluxSink<CreatedPostEvent>> {

	private final Executor executor;
	private BlockingQueue<CreatedPostEvent> queue = new LinkedBlockingQueue<>();

	@Override
	public void accept(FluxSink<CreatedPostEvent> t) {
		this.executor.execute(() -> {
			while (true)
				try {
					CreatedPostEvent event = queue.take();
					t.next(event);
				} catch (InterruptedException e) {
					ReflectionUtils.rethrowRuntimeException(e);
				}
		});
	}

	@Override
	public void onApplicationEvent(CreatedPostEvent event) {
		this.queue.offer(event);
	}

}
