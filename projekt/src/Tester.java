import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class Tester {
    private StreamingService streamingService = StreamingService.getInstance();

    // tilføjer alle krigsfilm til en liste af medier og tjekker om streamingService-klassens metode getMoviesWithCategory virker
    @Test
    public void searchWarMovieTest() {
        List<Media> medias = streamingService.getMedias();
        List<Media> testMedia = new ArrayList<>();

        Movie movie1 = new Movie("Casablanca", 1942, "Drama, Romance, War", 8.5);
        Movie movie2 = new Movie("The Bridge Over The River Kwai", 1957, "Adventure, Drama, War", 8.2);
        Movie movie3 = new Movie("Dr. Strangelove Or How I Learned To Stop Worrying And Love The Bomb", 1964, "Comedy, War", 8.4);
        Movie movie4 = new Movie("Apocalypse Now", 1979, "Drama, War", 8.5);
        Movie movie5 = new Movie("From Here To Eternity", 1953, "Drama, Romance, War", 7.7);
        Movie movie6 = new Movie("Saving Private Ryan", 1998, "Drama, War", 8.6);
        Movie movie7 = new Movie("The Best Years Of Our Lives", 1946, "Drama, Romance, War", 8.1);
        Movie movie8 = new Movie("Doctor Zhivago", 1965, "Drama, Romance, War", 8.0);
        Movie movie9 = new Movie("Patton", 1970, "Biography, Drama, War", 8.0);
        Movie movie10 = new Movie("Platoon", 1986, "Drama, War", 8.1);
        Movie movie11 = new Movie("The Deer Hunter", 1978, "Drama, War", 8.1);
        Movie movie12 = new Movie("All Quiet On The Western Front", 1930, "Drama, War", 8.1);
        Movie movie13 = new Movie("The Great Dictator", 1940, "Comedy, Drama, War", 8.5);
        testMedia.add(movie1);
        testMedia.add(movie2);
        testMedia.add(movie3);
        testMedia.add(movie4);
        testMedia.add(movie5);
        testMedia.add(movie6);
        testMedia.add(movie7);
        testMedia.add(movie8);
        testMedia.add(movie9);
        testMedia.add(movie10);
        testMedia.add(movie11);
        testMedia.add(movie12);
        testMedia.add(movie13);

        List<Media> resultMedia = streamingService.getMoviesWithCategory("War", medias);

        int correctMedia = 0;
        for (Media mTest : testMedia) {
            for (Media mResult : resultMedia) {
                if (mTest.getTitle().equals(mResult.getTitle())) {
                    correctMedia++;
                }
            }
        }

        assertEquals(13, correctMedia);
    }

    // tilføjer to film til brugerens liste og tjekker om de bliver korrekt tilføjet
    @Test
    public void addToMyListTest(){
        User user = new User("Claus");
        Movie movie = new Movie("The Godfather", 1972, "Crime, Drama", 9.2);
        Series serie = new Series("The Wire", "2001-2008", "Crime, Drama, Thriller", 9.3, "1-13, 2-12, 3-12, 4-13, 5-10");
        user.addToMyList(movie);
        user.addToMyList(serie);
        assertEquals("The Godfather", user.getMyList().get(0).getTitle());
        assertEquals("The Wire", user.getMyList().get(1).getTitle());
    }

    // fjerner et medie fra brugerens liste og tjekker om der så kun er et medie i brugerens liste
    @Test
    public void removeFromMyListTest(){
        User user = new User("Anders");
        Movie movie = new Movie("Psycho", 1960, "Horror, Mystery, Thriller", 8.5);
        Series serie = new Series("True Blood", "2008-2014", "Drama, Fantasy, Mystery", 7.9, "1-12, 2-12, 3-12, 4-12, 5-12, 6-10, 7-10");
        user.addToMyList(movie);
        user.addToMyList(serie);
        user.removeFromMyList(serie);
        assertEquals(1, user.getMyList().size());
    }

    // tjekker om programmet har 200 medier
    @Test
    public void loadFilesTest(){
        List<Media> medias = streamingService.getMedias();
        assertEquals(medias.size(),200);
    }

    // tjekker om programmet skifter bruger
    @Test
    public void changeUserTest(){
        streamingService.changeUser("Lucas");
        assertEquals("Lucas", streamingService.getCurrentUser().getName());
    }

    @Test
    public void streamingServiceInstancesTest() {
        StreamingService streamingService1 = StreamingService.getInstance();
        StreamingService streamingService2 = StreamingService.getInstance();
        assertEquals(streamingService1, streamingService2);
    }
}
