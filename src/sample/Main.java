package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * set the defaults for creating the scene
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("CSVView.fxml"));
       ScrollBar sb = new ScrollBar();
       sb.setOrientation(Orientation.VERTICAL);
        primaryStage.setTitle("Contacts");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
    }


    /**
     * launch the main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
