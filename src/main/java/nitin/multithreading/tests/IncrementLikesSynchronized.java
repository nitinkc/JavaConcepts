package nitin.multithreading.tests;

import java.math.BigDecimal;

public class IncrementLikesSynchronized extends IncrementLikes{

    @Override
    public synchronized Integer incrementLike(){
        return super.incrementLike();
    }

    @Override
    public synchronized BigDecimal incrementLikeBigInt(){
            return super.incrementLikeBigInt();
    }
}