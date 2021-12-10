import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private Scanner filmScanner;
    private Scanner seriesScanner;
    private List<Media> medias = new ArrayList<>();

    public Reader(){
        // Indlæser filer
        File filmFile = new File("resources/film.txt");
        File seriesFile = new File("resources/serier.txt");

        try{
            this.filmScanner = new Scanner(filmFile, "UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            this.seriesScanner = new Scanner(seriesFile, "UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Opdeler filerne i array
    public List<Media> loadFiles(){
        while(filmScanner.hasNextLine()) {
            String nextFilm = filmScanner.nextLine();
            String[] filmList = nextFilm.split(";");

            // Fjerner mellemrum ved år, genre og ændre rating til double
            filmList[1] = filmList[1].trim();
            filmList[2] = filmList[2].trim();
            // String[] filmGenre = filmList[2].split(",");
            filmList[3] = filmList[3].replace(",",".");

            Movie film = new Movie(filmList[0], Integer.parseInt(filmList[1]), filmList[2], Double.parseDouble(filmList[3]));
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
