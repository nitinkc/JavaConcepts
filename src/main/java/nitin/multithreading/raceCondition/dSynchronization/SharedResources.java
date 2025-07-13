package nitin.multithreading.raceCondition.dSynchronization;

public class SharedResources {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter(); // Shared resource

        Thread incrementingThread =
                new Thread(
                        () -> {
                            for (int i = 0; i < 10000; i++) {
                                inventoryCounter
                                        .incrementSynchronized(); // inventoryCounter.increment();
                            }
                        });
        Thread decrementingThread =
                new Thread(
                        () -> {
                            for (int i = 0; i < 10000; i++) {
                                inventoryCounter
                                        .decrementSynchronized(); // inventoryCounter.decrement();
                            }
                        });

        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

    private static class InventoryCounter {
        private int items = 0;

        Object lock = new Object();

        public void incrementSynchronized() {
            synchronized (this.lock) {
                items++;
            }
        }

        public void decrementSynchronized() {
            synchronized (this.lock) {
                items--;
            }
        }

        public int getItemsSynchronized() {
            synchronized (this.lock) {
                return items;
            }
        }

        public void increment() {
            items++;
        }

        public void decrement() {
            items--;
        }

        public int getItems() {
            return items;
        }
    }
}
