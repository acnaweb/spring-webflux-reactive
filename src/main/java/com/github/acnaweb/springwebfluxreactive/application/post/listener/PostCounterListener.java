package com.github.acnaweb.springwebfluxreactive.application.post.listener;

import com.github.acnaweb.springwebfluxreactive.domain.post.event.PostCounterEvent;
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
public class PostCounterListener
		implements ApplicationListener<PostCounterEvent>, Consumer<FluxSink<PostCounterEvent>> {

	private final Executor executor;
	private BlockingQueue<PostCounterEvent> queue = new LinkedBlockingQueue<>();

	@Override
	public void accept(FluxSink<PostCounterEvent> t) {
		this.executor.execute(() -> {
			while (true)
				try {
					PostCounterEvent event = queue.take();
					t.next(event);
				} catch (InterruptedException e) {
					ReflectionUtils.rethrowRuntimeException(e);
				}
		});
	}

	@Override
	public void onApplicationEvent(PostCounterEvent event) {
		this.queue.offer(event);
	}

}
