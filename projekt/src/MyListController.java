import javafx.fxml.FXML;
import java.util.List;

public class MyListController extends Controller{

    public MyListController() {
        super();
    }

    @FXML
    protected void initialize() {
        super.initialize();
        displayMedias(streamingService.getCurrentUser().getMyList());
    }

    // alle de næste metoder er listeners som er forbundet til en specifik knap eller funktion og aktiveres så når den knap trykkes.
    @FXML
    protected void getMoviesWithCategoryListener() {
        List<Media> medias = streamingService.getMoviesWithCategory((String) moviesCategoryChoiceBox.getValue(), streamingService.getCurrentUser().getMyList());

        movies.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    protected void getSeriesWithCategoryListener() {
        List<Media> medias = streamingService.getSeriesWithCategory((String) seriesCategoryChoiceBox.getValue(), streamingService.getCurrentUser().getMyList());

        series.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    protected void getSearchForMediaListener() {
        List<Media> medias = streamingService.getSearchForMedia(searchBar.getText(), streamingService.getCurrentUser().getMyList());

        movies.getChildren().clear();
        series.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    protected void changeUserListener() {
        streamingService.changeUser(userChoiceBox.getValue().toString());
        movies.getChildren().clear();
        series.getChildren().clear();
        displayMedias(streamingService.getCurrentUser().getMyList());
    }
}
