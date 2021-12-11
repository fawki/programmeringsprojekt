import java.util.*;

// denne klasse eksisterer der kun en af pga den starter med enum
public enum StreamingService {
    INSTANCE;
    private List<Media> medias;
    private List<User> users;
    private Reader r;

    private User currentUser;
    private User userSelma;
    private User userJonas;
    private User userLucas;

    private StreamingService(){
        r = new Reader();
        this.medias = r.loadFiles();

        // skaber tre brugere som man så kan skifte imellem
        users = new ArrayList<>();
        userSelma = new User("Selma");
        userJonas = new User("Jonas");
        userLucas = new User("Lucas");
        users.add(userSelma);
        users.add(userJonas);
        users.add(userLucas);
        currentUser = userSelma;
    }

    public List<Media> getMedias() {
        return medias;
    }

    protected User getCurrentUser() {
        return currentUser;
    }

    public List<Media> getCurrentUserList() {
        return currentUser.getMyList();
    }

    public List<User> getUsers() {
        return users;
    }

    protected void changeUser(String desiredUser) {
        for (User u : users) {
            if (desiredUser.equals(u.getName())) {
                currentUser = u;
            }
        }
    }

    // find et medie og returner det
    public List<Media> getSearchForMedia(String query, List<Media> mediaList) {
        List<Media> mediaInSearch = new ArrayList<>();
        for (Media m : mediaList) {
            if (m.getTitle().toLowerCase().contains(query.toLowerCase())) {
                mediaInSearch.add(m);
            }
        }
        return mediaInSearch;
    }

    // find alle medier i en bestemt kategori og returner dem (displayes så af controlleren)
    public List<Media> getMoviesWithCategory(String category, List<Media> mediaList) {
        List<Media> mediaInCategory = new ArrayList<>();
        for (Media m : mediaList) {
            if (m instanceof Movie && m.getGenre().contains(category)) {
                mediaInCategory.add(m);
            }
        }
        return mediaInCategory;
    }

    public List<Media> getSeriesWithCategory(String category, List<Media> mediaList) {
        List<Media> seriesInCategory = new ArrayList<>();
        for (Media m : mediaList) {
            if (m instanceof Series && m.getGenre().contains(category)) {
                seriesInCategory.add(m);
            }
        }
        return seriesInCategory;
    }
}
