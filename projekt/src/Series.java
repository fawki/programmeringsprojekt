public class Series extends Media{
    private String years;

    public Series(String title, String years, String genre, double rating){
        super(title, genre, rating);
        this.years = years;
        this.imageUrl = "serieforsider/" + title + ".jpg";
    }

    public String getYears(){
        return years;
    }
}

