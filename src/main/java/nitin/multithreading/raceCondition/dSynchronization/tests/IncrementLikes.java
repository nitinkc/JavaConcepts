package nitin.multithreading.raceCondition.dSynchronization.tests;


public class IncrementLikes {
    private Integer likes = Integer.valueOf(0);//Initialzying from zero

    public Integer getCurrentLikesCount() {
        return likes;
    }

    public Integer incrementLikes() {
        return likes++;
    }
}