package com.acv.components.infrastructure.domain.mapper;

public interface Mapper<M, P> {
    P map(M model);
}
