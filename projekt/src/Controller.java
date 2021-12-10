import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Controller {
    StreamingService streamingService = StreamingService.INSTANCE;

    protected Stage stage;

    @FXML
    protected ChoiceBox userChoiceBox;

    @FXML
    protected ChoiceBox seriesCategoryChoiceBox;

    @FXML
    protected ChoiceBox moviesCategoryChoiceBox;

    @FXML
    protected TilePane movies;

    @FXML
    protected TilePane series;

    @FXML
    protected TextField searchBar;

    @FXML
    protected void initialize() {
        // sætter de tre brugere fra StreamingService ind i choiceboksen
        List<User> users = streamingService.getUsers();
        userChoiceBox.setItems(FXCollections.observableArrayList(users));
        userChoiceBox.setValue(users.get(0).getName());

        // initialiserer kategoriboksene
        seriesCategoryChoiceBox.setItems(FXCollections.observableArrayList("Talk-show", "Documentary", "Crime", "Drama", "Action", "Adventure", "Drama", "Comedy", "Fantasy", "Animation", "Horror", "Sci-fi", "War", "Thriller", "Mystery", "Biography", "History", "Family", "Western", "Romance", "Sport"));
        moviesCategoryChoiceBox.setItems(FXCollections.observableArrayList("Crime", "Drama", "Biography", "Sport", "History", "Romance", "War", "Mystery", "Adventure", "Family", "Fantasy", "Thriller", "Horror", "Film-Noir", "Action", "Sci-fi", "Comedy", "Musical", "Western", "Music"));

        // indlæser alle medier og loader dem
        movies.getChildren().clear();
        series.getChildren().clear();
        displayMedias(streamingService.getMovies());
        displayMedias(streamingService.getSeries());
    }

    // generel metode til at finde et billede og vise det
    protected void loadImage(Media m, TilePane p) {
        try {
            // loader billedet
            String imageUrl = m.getImageUrl();

            Image image = new Image(imageUrl);
            ImageView imageView = new ImageView(image);

            // gør det muligt at klikke på billederne og se deres genre og rating
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Alert a = new Alert(Alert.AlertType.NONE);

                    a.setHeaderText(m.getTitle());
                    a.setContentText("Genre: " + m.getGenre() + "\n" + "Rating: " + m.getRating());
                    ImageView popUpImage = new ImageView(image);
                    a.setGraphic(popUpImage);

                    //skaber knapper så man kan lukke vinduet og tilføje det til min liste
                    ButtonType playButton = new ButtonType("Play Media");
                    ButtonType closeButton = new ButtonType("Close");

                    List<Media> currentUserList = streamingService.getCurrentUserList();
                    boolean alreadyInList = false;
                    for (Media mInMyList: currentUserList) {
                        if (m == mInMyList) {
                            alreadyInList = true;
                            break;
                        }
                    }
                    if (alreadyInList) {
                        ButtonType removeFromMyList = new ButtonType("Remove from My List");
                        a.getButtonTypes().setAll(playButton, removeFromMyList,closeButton);

                        Optional<ButtonType> clickedButton = a.showAndWait();
                        if (clickedButton.get() == removeFromMyList) {
                            currentUserList.remove(m);
                        }
                    }
                    else {
                        ButtonType addToMyList = new ButtonType("Add to My List");
                        a.getButtonTypes().setAll(playButton, addToMyList,closeButton);

                        Optional<ButtonType> clickedButton = a.showAndWait();
                        if (clickedButton.get() == addToMyList) {
                            currentUserList.add(m);
                        }
                    }
                }
            });

            p.getChildren().add(imageView);
        } catch (Exception e) {
            Text text = new Text("ERROR: Could not load media: " + m.getImageUrl());
            text.setFont(new Font(32));
            p.getChildren().add(text);
            System.out.println("Media name: " + m.getImageUrl());
            System.out.println(e.getMessage());
        }
    }

    // viser en liste af medier visuelt
    protected void displayMedias(List<Media> medias) {
        for (Media m : medias) {
            if (m instanceof Movie) {
                loadImage(m, movies);
            }
            else if (m instanceof Series) {
                loadImage(m, series);
            }
        }
    }

    // alle de næste metoder er listeners som er forbundet til en specifik knap eller funktion og aktiveres så når den knap trykkes.
    @FXML
    protected void changeUserListener() {
        streamingService.changeUser(userChoiceBox.getValue().toString());
    }

    @FXML
    private void getMoviesWithCategoryListener() {
        List<Media> medias = streamingService.getMoviesWithCategory((String) moviesCategoryChoiceBox.getValue());

        movies.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    private void getSeriesWithCategoryListener() {
        List<Media> medias = streamingService.getSeriesWithCategory((String) seriesCategoryChoiceBox.getValue());

        series.getChildren().clear();
        displayMedias(medias);
    }

    @FXML
    private void getSearchForMediaListener() {
        List<Media> medias = streamingService.getSearchForMedia(searchBar.getText());

        movies.getChildren().clear();
        series.getChildren().clear();
        displayMedias(medias);
    }

    // denne metode skifter tilbage til hovedsiden.
    @FXML
    protected void changeToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void displayMyList() {
        movies.getChildren().clear();
        series.getChildren().clear();
        displayMedias(streamingService.getCurrentUserList());
    }
}
