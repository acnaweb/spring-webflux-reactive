# spring-webflux-reactive

Spring Webflux Reactive with SSR

## Run

Client/Browser
* curl localhost:8080/notifications/posts/sse
* curl localhost:8080/notifications/posts/count/sse

Creating Posts
* curl -X POST "http://localhost:8080/posts" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"message\": \"Hello World\",  \"user_id\": 1}"

## Tips

* https://levelup.gitconnected.com/reactive-spring-boot-api-with-next-js-client-b08147ae5712
* https://medium.com/techbloghotmart/o-que-%C3%A9-server-side-rendering-e-como-usar-na-pr%C3%A1tica-a840d76a6dca
* https://codeburst.io/jsx-react-js-java-server-side-rendering-ssr-2018-cf3aaff7969d
* https://www.youtube.com/watch?v=aQFPetOyzUE
