package nitin.streams.converter.entityConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SpannerEntity {
    private Boolean isAutoSpanner;
    private Double rateRatioSpanner;
}
