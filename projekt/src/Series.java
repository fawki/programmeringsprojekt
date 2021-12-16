import java.util.HashMap;

public class Series extends Media{
    private String years;
    private String seasons;

    public Series(String title, String years, String genre, double rating, String seasons){
        super(title, genre, rating);
        this.years = years;
        this.imageUrl = "serieforsider/" + title + ".jpg";
        this.seasons = seasons;
    }

    @Override
    public String getYear(){
        return years;
    }

    public String getSeasons() {
        return seasons;
    }
}

