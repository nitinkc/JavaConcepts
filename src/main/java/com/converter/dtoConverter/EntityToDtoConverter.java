package com.converter.dtoConverter;

import java.util.function.BiConsumer;

public class EntityToDtoConverter extends DtoConverter<Dto> {

    static final BiConsumer<Entity, Dto> ENTITY_TO_DTO =
            (entity, dto) -> {
                dto.setIdDto(entity.getIdEntity());
                dto.setDoseQtyDto(entity.getSomeString());
            };

    @Override
    protected Dto instantiateDto() {
        return new Dto();
    }

    public Dto toDto(Entity entity) {
        return convert(entity, null, ENTITY_TO_DTO);
    }
}
