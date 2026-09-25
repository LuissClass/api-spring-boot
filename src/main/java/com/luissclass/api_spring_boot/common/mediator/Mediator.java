package com.luissclass.api_spring_boot.common.mediator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Mediator {

    Map<? extends Class<?>, RequestHandler<?, ?>> collect;

    public Mediator(List<RequestHandler<?, ?>> requestHandlers) {
        collect = requestHandlers.stream()
                .collect(Collectors.toMap(RequestHandler::getRequestType, Function.identity()));
    }

    public <T extends Request<R>, R> R dispatch(T request) {
        RequestHandler<T, R> handler = findHandler(request);
        return handler.handle(request);
    }

    @SuppressWarnings("unchecked")
    private <T extends Request<R>, R> RequestHandler<T, R> findHandler(T request) {
        RequestHandler<?, ?> raw = collect.get(request.getClass());
        if (raw == null) {
            throw new IllegalArgumentException(
                    "No handler found for request type: " + request.getClass().getName());
        }
        return (RequestHandler<T, R>) raw;
    }
}
