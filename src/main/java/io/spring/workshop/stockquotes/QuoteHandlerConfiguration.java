package io.spring.workshop.stockquotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class QuoteHandlerConfiguration {

    @Autowired
    private QuoteHandler quoteHandler;

    @Bean
    public RouterFunction<ServerResponse> helloWorldRoute() {
        RouterFunction<ServerResponse> helloWorldRoute =
                RouterFunctions.route(RequestPredicates.path("/hello"),
                        quoteHandler::streamQuotes);
        return helloWorldRoute;
    }
}
