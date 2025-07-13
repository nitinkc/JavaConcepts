package nitin.multithreading.raceCondition.semaphore;

public class ProducerConsumerRunner {

    private static final int NUM_PRODUCERS = 3;
    private static final int NUM_CONSUMERS = 2;

    public static void main(String[] args) {

        // Start producer threads
        for (int i = 0; i < NUM_PRODUCERS; i++) {
            int producerId = i + 1; // Unique ID for each producer
            Thread thread = new Thread(ProducerConsumer::producerTask);
            thread.setName("Producer " + producerId);
            thread.start();
        }

        // Start consumer threads
        for (int i = 0; i < NUM_CONSUMERS; i++) {
            int consumerId = i + 1; // Unique ID for each consumer
            Thread thread = new Thread(ProducerConsumer::consumerTask);
            thread.setName("Consumer " + consumerId);
            thread.start();
        }
    }
}
