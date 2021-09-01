
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    String movie;
    Game(String movie){
        this.movie = movie;
    }
    public static void startGame(String movie) {
        int chances = 10;
        Scanner scanner = new Scanner(System.in);
        String guess = "";
        ArrayList alreadyGuessed = new ArrayList();
        char[] codedMovie = movie.replaceAll("[a-z]", "_").toCharArray();
        System.out.println("Welcome to Guess the movie game.");
        System.out.println("Pick a letter and try to reveal the title of the movie. You have 10 guesses.");
        System.out.println("Good luck!");
        System.out.println();
        System.out.println("You're guessing: " + movie.replaceAll("[a-z]","_"));
        while (chances > 0) {
            System.out.println("You have " + chances + " more guesses.");
            System.out.println("Type your guess: ");
            guess = scanner.nextLine();
            guess = guess.toLowerCase();
            System.out.println();
            if (alreadyGuessed.contains(guess)) {
                System.out.println("You already guessed that character!");
                System.out.println("List of already guessed chars: " + alreadyGuessed);
                System.out.println();
            } else {
                alreadyGuessed.add(guess);
                if (movie.contains(guess)) {
                    ArrayList<Integer> indexes = new ArrayList<Integer>();
                    int index = movie.indexOf(guess);
                    while (index >= 0) {
                        indexes.add(index);
                        index = movie.indexOf(guess, index + 1);
                    }
                    for (int i = 0; i < indexes.size(); i++) {
                        codedMovie[indexes.get(i)] = guess.charAt(0);
                    }
                    System.out.println(codedMovie);

                    if (movie.equals(String.valueOf(codedMovie))) {
                        System.out.println();
                        System.out.println("Good job, you've won!");
                        break;
                    }
                } else {
                    System.out.println("Wrong letter");
                    System.out.println();
                    chances--;
                }
            }
        }
        if(chances == 0){
            System.out.println("You've lost.");
        }
    }
}
