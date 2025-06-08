package model;

import java.util.Random;

public class Roach implements Runnable {
    private final int num;
    private final int stages;

    public Roach(int num, int stages) {
        this.num = num;
        this.stages = stages;
    }


    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < stages; i++) {
            System.out.printf("Roach %d runs stage %d/%d\n", num, i, stages);
            try {
                Thread.sleep(2 + random.nextInt(4));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf(">>Roach %d finished the race<<\n", num);
    }
}
