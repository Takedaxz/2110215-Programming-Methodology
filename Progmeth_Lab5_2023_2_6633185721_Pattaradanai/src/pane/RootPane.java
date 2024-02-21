package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import utils.Goto;

public class RootPane extends VBox {
    private static RootPane instance;

    private RootPane() {
        // TODO: FILL CODE HERE
        this.setBackground(Background.fill(Color.WHITE));
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(16);
        this.setPadding(new Insets(32,0,32,0));
        Text titleText=new Text("Let's Read");
        titleText.setFill(Color.DARKCYAN);
        titleText.setFont(Font.font("Verdana",FontWeight.BOLD,32));
        this.getChildren().add(titleText);

        ///////////////////////
        Goto.setRootPane(this);
        Goto.mainPage();
    }

    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }
}
