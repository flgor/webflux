package io.spring.workshop.stockquotes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static java.time.Duration.ofMillis;
import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class QuoteHandler {

    @Autowired
    private QuoteGenerator quoteGenerator;

    public Mono<ServerResponse> streamQuotes(ServerRequest request) {
        return ok()
                .contentType(APPLICATION_STREAM_JSON)
                .body(quoteGenerator.fetchQuoteStream(ofMillis(200)), Quote.class);
    }
}
