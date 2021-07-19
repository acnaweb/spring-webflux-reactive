# spring-webflux-reactive

Spring Webflux Reactive with SSR

# Tests

Client/Browser
* curl localhost:8080/notifications/posts/sse
* curl localhost:8080/notifications/posts/count/sse

Creating Posts
* curl -X POST "http://localhost:8080/posts" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"message\": \"Hello World\",  \"user_id\": 1}"
