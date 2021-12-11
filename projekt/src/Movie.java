public class Movie extends Media{
    private int year;

    public Movie(String title, int year, String genre, double rating){
        super(title, genre, rating);
        this.year = year;
        this.imageUrl = "filmplakater/" + title + ".jpg";
    }

    @Override
    public String getYear(){
        return Integer.toString(year);
    }
}
