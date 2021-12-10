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

public abstract class Controller {
    StreamingService streamingService = StreamingService.INSTANCE;

    protected Stage stage;

    @FXML
    protected Button crimeButton;

    @FXML
    protected TilePane movies;

    @FXML
    protected TilePane series;

    @FXML
    protected TextField searchBar;

    // generel metode til at finde et billede og vise det
    protected void loadImage(Media m, TilePane p) {
        try {
            String imageUrl = m.getImageUrl();

            Image image = new Image(imageUrl);
            ImageView imageView = new ImageView(image);

            p.getChildren().add(imageView);
        } catch (Exception e) {
            System.out.println("Media name: " + m.getImageUrl());
            System.out.println(e.getMessage());
        }
    }

    protected void showSeries() {
        List<Media> medias = streamingService.getMedias();
        for (Media m : medias) {
            if (m instanceof Series) {
                loadImage(m, series);
            }
        }
    }

    protected void showMovies() {
        List<Media> medias = streamingService.getMedias();
        for (Media m : medias) {
            if (m instanceof Movie) {
                loadImage(m, movies);
            }
        }
    }

    @FXML
    protected void changeToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void changeToMovies(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Movies.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void changeToSeries(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Series.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void changeToMyList(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
