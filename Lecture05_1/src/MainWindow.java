import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
    public void start(Stage primaryStage){
        FlowPane root=new FlowPane();
        root.setPadding(new Insets(5));
        root.setHgap(5);
        root.setVgap(5);

        Button exitButton=new Button("Exit");
        exitButton.setPrefWidth(70);
        Button showButton=new Button("Show");
        showButton.setPrefWidth(70);

        TextField text=new TextField("This is a text field.");
        text.setPrefWidth(250);

        root.getChildren().addAll(showButton,text,exitButton);

        Scene scene=new Scene(root,300,250);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
