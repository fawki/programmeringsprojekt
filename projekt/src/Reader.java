import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private Scanner movieScanner;
    private Scanner seriesScanner;
    private List<Media> medias = new ArrayList<>();

    public Reader() {
        // Indlæser filer
        InputStream movieFile = getClass().getResourceAsStream("film.txt");
        InputStream seriesFile = getClass().getResourceAsStream("serier.txt");

        try {
            this.movieScanner = new Scanner(movieFile, "UTF-8");
        } catch (NullPointerException e) {
            System.out.println("ERROR: Could not load file containing movies.");
        }
        try {
            this.seriesScanner = new Scanner(seriesFile, "UTF-8");
        } catch (NullPointerException e) {
            System.out.println("ERROR: Could not load file containing series.");
        }
    }

    // Opdeler filerne i array
    public List<Media> loadFiles() {
        while(movieScanner.hasNextLine()) {
            String nextMovie = movieScanner.nextLine();
            String[] movieList = nextMovie.split(";");

            // Fjerner mellemrum ved år, genre og ændre rating til double
            movieList[1] = movieList[1].trim();
            movieList[2] = movieList[2].trim();
            // String[] filmGenre = movieList[2].split(",");
            movieList[3] = movieList[3].replace(",",".");

            Movie film = new Movie(movieList[0], Integer.parseInt(movieList[1]), movieList[2], Double.parseDouble(movieList[3]));
            medias.add(film);

        }

        while(seriesScanner.hasNextLine()) {
            String nextSeries = seriesScanner.nextLine();

            String[] seriesList = new String[6];
            String[] splitList = nextSeries.split(";");

            for(int i = 0; i < seriesList.length-1; i++){
                seriesList[i] = splitList[i];
            }

            // Fjerner mellemrum ved år, genre og ændre rating til double
            seriesList[1] = seriesList[1].trim();
            seriesList[2] = seriesList[2].trim();
            // String[] seriesGenre = seriesList[2].split(",");
            seriesList[3] = seriesList[3].replace(",",".");
            seriesList[4] = seriesList[4].trim();

            Series serie = new Series(seriesList[0], seriesList[1], seriesList[2], Double.parseDouble(seriesList[3]), seriesList[4]);
            medias.add(serie);
        }

        return medias;
    }
}
