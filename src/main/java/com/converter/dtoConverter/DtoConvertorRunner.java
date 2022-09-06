package com.converter.dtoConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DtoConvertorRunner {

    static Entity entity;
    static {
        entity = Entity.builder()
                .idEntity("uuid")
                .someString("some String")
                .ssn("ssn")
                .age(29)
                .build();
    }
    public static void main(String[] args) {
        List<Entity> list = Arrays.asList(entity);
        List<Dto> dtoList = entityToDto(list);

        dtoList.stream().forEach(System.out::println);
    }

    private static List<Dto> entityToDto(List<Entity> entityList) {

//        if(!(entityList.get(0) instanceof Entity) || entityList == null)
//            return null;

        EntityToDtoConverter entityToDtoConverter = new EntityToDtoConverter();
        List<Dto> dtoList = entityList.stream()
                .filter(obj -> obj == null)
                //.map(entity -> entityToDtoConverter.toDto(entity))
                .map(entityToDtoConverter::toDto)
                .collect(Collectors.toList());

        return dtoList;
    }
}
