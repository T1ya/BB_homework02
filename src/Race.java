import model.Roach;

public class Race {
    private final Thread[] threads;

    public Race(int roachesMax, int stages) {
        threads = new Thread[roachesMax];
        for (int i = 0; i < roachesMax; i++) threads[i] = new Thread(new Roach(i, stages)); // кладём тараканов в треды
    }

    // если два таракана прибегут одновременно, то будет, конечно, дискриминация по номеру)
    // но умнее я ничего не придумал
    public Integer getFirstWinner() {
        for (int i = 0; i < threads.length; i++) {
            if (!threads[i].isAlive()) return i;
        }
        return null;
    }

    public void beginRace() throws InterruptedException {
        Integer winner = null;  //  сюда положим первого победителя
        System.out.println(" 3...2...1..");
        System.out.println(" === RACES BEGIN! ===");
        for (Thread thread : threads) {
            thread.start();
        }
        while (winner == null) {    // нет победителя? ищем победителя
            winner = getFirstWinner();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(" === RACE ENDED! ===");
        System.out.println(" Roach #" + winner + " has won the race!");
    }
}
