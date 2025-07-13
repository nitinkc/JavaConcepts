package com.converter.db2Dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface DbToDtoConverter<T, R> {

    T convert(R from);

    default List<T> convert(Collection<? extends R> fromCollection) {
        return fromCollection.stream().map(this::convert).collect(Collectors.toList());
    }
}
