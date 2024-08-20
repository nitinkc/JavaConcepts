package nitin.multithreading.raceCondition.deadLocks;

import java.util.Random;

public class Train {
        private final Intersection intersection;
        private final boolean useNorthSouthTrack;
        private final Random random = new Random();

        public Train(Intersection intersection, boolean useNorthSouthTrack) {
            this.intersection = intersection;
            this.useNorthSouthTrack = useNorthSouthTrack;
        }

        public void run() {
            while (true) {
                sleepRandomTime();
                if (useNorthSouthTrack) {
                    intersection.takeNorthSouthTrack();
                } else {
                    intersection.takeEastWestTrack();
                }
            }
        }

        private void sleepRandomTime() {
            try {
                Thread.sleep(random.nextInt(5));
                //Thread.sleep(10000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }
