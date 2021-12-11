import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.List;

public class MyListController extends Controller{
    @FXML
    protected void initialize() {
        super.initialize();
        displayMedias(streamingService.getCurrentUserList());
    }

    // alle de næste metoder er listeners som er forbundet til en specifik knap eller funktion og aktiveres så når den knap trykkes.
    @FXML
    protected void getMoviesWithCategoryListener() {
        List<Media> medias = streamingService.getMoviesWithCategory((String) moviesCategoryChoiceBox.getValue(), streamingService.getCurrentUserList());

        movies.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    protected void getSeriesWithCategoryListener() {
        List<Media> medias = streamingService.getSeriesWithCategory((String) seriesCategoryChoiceBox.getValue(), streamingService.getCurrentUserList());

        series.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    protected void getSearchForMediaListener() {
        List<Media> medias = streamingService.getSearchForMedia(searchBar.getText(), streamingService.getCurrentUserList());

        movies.getChildren().clear();
        series.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    protected void changeUserListener() {
        streamingService.changeUser(userChoiceBox.getValue().toString());
        initialize();
    }
}