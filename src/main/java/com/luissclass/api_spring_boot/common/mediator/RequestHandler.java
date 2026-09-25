package com.luissclass.api_spring_boot.common.mediator;

public interface RequestHandler<T extends Request<R>, R> {
    R handle(T request);

    Class<T> getRequestType();
}
