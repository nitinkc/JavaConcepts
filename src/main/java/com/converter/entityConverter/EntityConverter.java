package com.converter.entityConverter;

import static java.util.Objects.isNull;

import java.util.function.BiConsumer;

public interface EntityConverter<I, O> {
    O convert(I input);

    default <R> O convert(I input, O output, R additionalEntity, BiConsumer<O, R> func) {
        O out = isNull(output) ? convert(input) : output;
        func.accept(out, additionalEntity);
        return out;
    }

    default <R> O convert(O output, R fromEntity, BiConsumer<O, R> func) {
        func.accept(output, fromEntity);
        return output;
    }
}
