package nitin.streams.converter.entityConverter;

public class EntityConverterImpl implements EntityConverter<DB2Entity,SpannerEntity>{
    @Override
    public SpannerEntity convert(DB2Entity input) {
        return
                SpannerEntity.builder()
                        .isAuto(input.getIsAutoFlowRate())
                        .rateRatio(input.getAutoFlowRateRatio())
                        .build();
    }
}
