package nitin.multithreading.raceCondition.shared.tests;


import java.math.BigDecimal;

public class IncrementLikes {
    private Integer like = Integer.valueOf(0);//Initialzying from zero
    private BigDecimal likeBigDecimal = BigDecimal.ZERO;

    public Integer getNextLikeCount() {
        return like;
    }

    public Integer incrementLike() {
        return like++;
    }

    public BigDecimal getNextLikeCountBigDecimal() {
        return likeBigDecimal;
    }

    public BigDecimal incrementLikeBigInt() {
        likeBigDecimal = likeBigDecimal.add(BigDecimal.ONE);
        return likeBigDecimal;
    }
}