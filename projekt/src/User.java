import java.util.*;

public class User {
    private String name;
    private List<Media> myList;

    public User(String name){
        this.name = name;
        this.myList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }

    public List<Media> getMyList() {
        return myList;
    }

    public void addToMyList(Media m) {
        myList.add(m);
    }

    public void removeFromMyList(Media m) {
        myList.remove(m);
    }
}
