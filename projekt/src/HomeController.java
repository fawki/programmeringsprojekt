import javafx.fxml.FXML;

import java.util.List;

public class HomeController extends Controller {

    @FXML
    protected void initialize() {
        super.initialize();
        displayMedias(streamingService.getMedias());
    }

    // alle de næste metoder er listeners som er forbundet til en specifik knap eller funktion og aktiveres så når den knap trykkes.
    @FXML
    protected void getMoviesWithCategoryListener() {
        List<Media> medias = streamingService.getMoviesWithCategory((String) moviesCategoryChoiceBox.getValue(), streamingService.getMedias());

        movies.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    protected void getSeriesWithCategoryListener() {
        List<Media> medias = streamingService.getSeriesWithCategory((String) seriesCategoryChoiceBox.getValue(), streamingService.getMedias());

        series.getChildren().clear();
        displayMedias(medias);
    }

    // tager teksten der er i søgefeltet og bruger det til at finde alle medier med det stykke tekst i sig
    @FXML
    protected void getSearchForMediaListener() {
        List<Media> medias = streamingService.getSearchForMedia(searchBar.getText(), streamingService.getMedias());

        movies.getChildren().clear();
        series.getChildren().clear();
        displayMedias(medias);
    }
}
