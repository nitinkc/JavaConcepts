package com.converter.entityConverter;

public class EntityConverterImpl implements EntityConverter<DB2Entity, SpannerEntity> {
    @Override
    public SpannerEntity convert(DB2Entity input) {
        return SpannerEntity.builder()
                .isAutoSpanner(input.getIsAutoFlowRateDB2())
                .rateRatioSpanner(input.getAutoFlowRateRatioDB2())
                .build();
    }
}
