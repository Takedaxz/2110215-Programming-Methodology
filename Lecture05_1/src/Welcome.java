import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Welcome extends Application {
    public static void main(String[] args){
        launch(args);
    }


    public void start(Stage primaryStage) {
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Text sceneTitle=new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        grid.add(sceneTitle,0,0,2,1);

        Label userName=new Label("User Name : ");
        grid.add(userName,0,1);

        TextField userTextField=new TextField();
        grid.add(userTextField,1,1);

        Label password=new Label("Password : ");
        grid.add(password,0,2);

        PasswordField passwordField=new PasswordField();
        grid.add(passwordField,1,2);

        HBox hbBtn=new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        Button signinButton = new Button("Sign in");
        Button exitButton=new Button("Exit");
        hbBtn.getChildren().addAll(signinButton,exitButton);
        grid.add(hbBtn,1,4);

        Scene scene=new Scene(grid,350,300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.show();
    }
}
