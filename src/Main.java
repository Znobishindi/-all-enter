import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    private static final int NUMBER_OF_CALLS = 60;
    private static final BlockingQueue<String> calls = new ArrayBlockingQueue<>(NUMBER_OF_CALLS);

    public static void main(String[] args) {
        Thread start = new Thread(() -> {
            for (int i = 0; i < NUMBER_OF_CALLS; i++) {
                try {
                    Thread.sleep(200);
                    calls.put("Звонок " + (i + 1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        start.start();
        new Thread(() -> {
            while (start.isAlive()) {
                try {
                    System.out.println("Оператор 1 обработал " + calls.take());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (start.isAlive()) {
                try {
                    System.out.println("Оператор 2 обработал " + calls.take());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (start.isAlive()) {
                try {
                    System.out.println("Оператор 3 обработал " + calls.take());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (start.isAlive()) {
                try {
                    System.out.println("Оператор 4 обработал " + calls.take());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
