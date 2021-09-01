import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "film-list.txt";
            String movie = Movie.randomMoviePicker(filePath);
            Game game = new Game(movie);
            Game.startGame(movie);
        } catch (FileNotFoundException exception){
            System.out.println("File not found");
            System.exit(1);
        }
    }
}