import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class redbox extends Application {

    @Override
    public void start(Stage stage){


        Label label = new Label("My Label");
        label.setAlignment(Pos.CENTER);
        HBox x = new HBox(label);
        x.setFill("-fx-background-color:red;");


        Scene scene = new Scene(x,200,100);
        stage.setTitle("HBox Experiment 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){

        launch(args);

    }
}
