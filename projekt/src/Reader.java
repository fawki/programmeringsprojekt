import java.io.File;
import java.io.FileNotFoundException;
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

        this.movieScanner = new Scanner(movieFile, "UTF-8");
        this.seriesScanner = new Scanner(seriesFile, "UTF-8");
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

            /*
            // Splitter sæsoner
            String[] tempSeasons = seriesList[4].trim().split(",");

            // Arrays til sæsoner og episoder
            int[] seasons = new int[tempSeasons.length];
            int[] episodes = new int[tempSeasons.length];

            // Fylder ovenstående arrays
            for(int i = 0; i < tempSeasons.length; i++){
                seasons[i] = Integer.parseInt(tempSeasons[i].substring(0, tempSeasons[i].indexOf("-")));
            }

            for(int i = 0; i < tempSeasons.length; i++){
                episodes[i] = Integer.parseInt(tempSeasons[i].substring(tempSeasons[i].indexOf("-"), -1));
            }
            */

            Series serie = new Series(seriesList[0], seriesList[1], seriesList[2], Double.parseDouble(seriesList[3]));
            medias.add(serie);
        }

        return medias;
    }
}
