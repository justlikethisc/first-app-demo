package com.example.firstappdemo.config;

import com.example.firstappdemo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> findAll(){
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(2);
        user.setName("lily");
        list.add(user);

        return RouterFunctions.route(RequestPredicates.GET("/user/all"),req->{
            Flux<User> userFlux = Flux.fromIterable(list);
            return ServerResponse.ok().body(userFlux,User.class);
        });
    }
}
