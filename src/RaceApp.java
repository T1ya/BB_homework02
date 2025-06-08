import java.util.InputMismatchException;
import java.util.Scanner;

public class RaceApp {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Number of roaches: ");
            int roaches = getUserInput(in);
            System.out.println("Number of stages: ");
            int stages = getUserInput(in);
            Race race = new Race(roaches, stages);
            race.beginRace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // а нечего делать некорректный ввод сто раз!
    private static int getUserInput(Scanner in) {
        int attempts = 3;
        while (attempts > 0) {
            try {
                int result = in.nextInt();
                if (result > 0) return result;
                System.out.println("Error - please enter a positive number. Attempts left: " + --attempts);
            } catch (InputMismatchException e) {
                System.out.println("Error - please enter a number. Attempts left: " + --attempts);
                in.next();
            }
        }
        throw new RuntimeException("Too many invalid attempts. Exit program");
    }
}
