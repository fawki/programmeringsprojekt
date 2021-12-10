import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;

import java.util.List;

public class MyListController extends Controller{
    @FXML
    private TilePane myList;

    @FXML
    private void initialize() {
        List<Media> medias = streamingService.getMedias();
    }

    @FXML
    private void search() {
        List<Media> medias = streamingService.searchSpecificMedia(searchBar.getText());

        myList.getChildren().clear();
        for (Media m : medias) {
            loadImage(m, myList);
        }
    }
}