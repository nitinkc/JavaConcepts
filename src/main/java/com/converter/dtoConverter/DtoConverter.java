package com.converter.dtoConverter;

import java.util.function.BiConsumer;

import static java.util.Objects.isNull;

public abstract class DtoConverter<O> {

    public <E> O convert(E from, O to, BiConsumer<E, O> build) {
        O out = isNull(to) ? instantiateDto() : to;
        build.accept(from, out);
        return out;
    }

    protected abstract O instantiateDto();
}
