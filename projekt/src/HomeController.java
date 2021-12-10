import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class HomeController extends Controller{
    @FXML
    private void initialize() {
        showMovies();
        showSeries();
    }

    @FXML
    private void search() {
        List<Media> medias = streamingService.searchSpecificMedia(searchBar.getText());

        movies.getChildren().clear();
        series.getChildren().clear();
        for (Media m : medias) {
            System.out.println(m.getTitle());
            if (m instanceof Movie) {
                loadImage(m, movies);
            }
            else if (m instanceof Series) {
                loadImage(m, series);
            }
        }
    }
}