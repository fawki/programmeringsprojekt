import java.util.*;

public enum StreamingService {
    INSTANCE;
    private List<Media> medias;
    private List<User> users;
    private Reader r;

    private StreamingService(){
        r = new Reader();
        this.medias = r.loadFiles();
    }

    public List<Media> getMedias() {
        return medias;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Media> getUserList(User u) {
        return u.getMyList();
    }

    // find et medie og returner det
    public List<Media> searchSpecificMedia(String query) {
        List<Media> mediaInSearch = new ArrayList<>();
        for (Media m : medias) {
            if (m.getTitle().toLowerCase().contains(query.toLowerCase())) {
                mediaInSearch.add(m);
            }
        }
        return mediaInSearch;
    }

    // find alle medier i en bestemt kategori og returner dem (displayes så af controlleren)
    public List<Media> findMediaWithCategory(String category) {
        List<Media> mediaInCategory = new ArrayList<>();
        for (Media m : medias) {
            if (m.getGenre().toLowerCase().contains(category.toLowerCase())) {
                mediaInCategory.add(m);
            }
        }
        return mediaInCategory;
    }
}
