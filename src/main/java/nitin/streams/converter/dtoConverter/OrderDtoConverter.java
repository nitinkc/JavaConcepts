package nitin.streams.converter.dtoConverter;

import java.util.function.BiConsumer;

public class OrderDtoConverter extends DtoConverter<DosageDto> {

    static final BiConsumer<DosageEntity, DosageDto> SPANNER_DOSAGE_ENTITY_TO_DOSAGE_DTO = (entity, dto) -> {

        dto.setIdDto(entity.getIdEntity());
        dto.setDoseQtyDto(entity.getDoseQuantity());
    };

    @Override
    protected DosageDto instantiateDto() {
        return new DosageDto();
    }
}

