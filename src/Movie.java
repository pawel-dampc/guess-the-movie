import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Movie {
    public static String randomMoviePicker(String filePath) throws FileNotFoundException {
        File moviesFile = new File(filePath);
        Scanner fileScanner = new Scanner(moviesFile);
        int numberOfMovies = 0;
        while (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            numberOfMovies++;
        }
        int randomNumber = (int)(Math.random() * numberOfMovies + 1);
        Scanner fileScanner2 = new Scanner(moviesFile);
        String movie = null;
        for (int i = 0; i < randomNumber; i++) {
            movie = fileScanner2.nextLine();
        }
        return movie;
    }
}


