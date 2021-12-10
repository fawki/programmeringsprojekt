import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

public class SeriesController extends Controller {
    @FXML
    private void initialize() {
        showSeries();
    }

    @FXML
    private void search() {
        List<Media> medias = streamingService.searchSpecificMedia(searchBar.getText());

        series.getChildren().clear();
        for (Media m : medias) {
            loadImage(m, series);
        }
    }
}