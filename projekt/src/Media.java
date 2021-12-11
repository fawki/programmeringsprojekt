public class Media {
    protected String title;
    protected String genre;
    protected double rating;
    protected String imageUrl;
    protected String year;

    public Media(String title, String genre, double rating){
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.imageUrl = "hello";
    }

    public String getYear() {
        return year;
    }

    public String getTitle(){
        return title;
    }

    public String getGenre(){
        return genre;
    }

    public double getRating(){
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
