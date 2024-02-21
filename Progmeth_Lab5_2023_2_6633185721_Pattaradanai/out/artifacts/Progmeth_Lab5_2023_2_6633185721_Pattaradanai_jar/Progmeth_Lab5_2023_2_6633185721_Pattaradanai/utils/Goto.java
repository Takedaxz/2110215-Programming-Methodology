package utils;

import item.Book;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.BookListPane;
import pane.NewBookPane;
import pane.RootPane;
import pane.SearchPane;

import static javafx.scene.control.ScrollPane.ScrollBarPolicy.NEVER;

public class Goto {
    private static RootPane rootPane;
    public static void setRootPane(RootPane rootPane){
        Goto.rootPane=rootPane;
    }

    public static void clear(){
        if (rootPane.getChildren().size() > 1) {
            for(int i=rootPane.getChildren().size()-1;i>0;i--){
                rootPane.getChildren().remove(i);
            }
        }
    }

    public static void mainPage(){
        clear();

        BookListPane bookListPane = BookListPane.getInstance();
        ScrollPane scrollPane = new ScrollPane(bookListPane);
        scrollPane.setHbarPolicy(NEVER);
        scrollPane.setVbarPolicy(NEVER);

        rootPane.getChildren().add(new SearchPane());
        rootPane.getChildren().add(scrollPane);

    }

    public static Button backToMainPageButton(){
        Button backButton = new Button("Back");
        backButton.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        backButton.setBackground(Background.fill(Color.WHITE));
        backButton.setTextFill(Color.DARKCYAN);
        backButton.setPrefWidth(300);
        backButton.setOnAction(event -> mainPage());
        return backButton;
    }

    public static void bookPage(Book book){
        clear();
        Text name = GetDisplay.name(book,28,336,TextAlignment.CENTER);
        Text author = GetDisplay.author(book,24,336,TextAlignment.CENTER);
        author.setText("By " +book.getAuthor());
        ImageView image = GetDisplay.image(book,320);
        Text stars = GetDisplay.stars(book,24);
        Text description = GetDisplay.Description(book,16,336);
        rootPane.getChildren().add(backToMainPageButton());
        rootPane.getChildren().addAll(name,author,image,stars,description);
    }

    public static void addNewBookPage(){
        clear();
        rootPane.getChildren().add(backToMainPageButton());
        rootPane.getChildren().add(new NewBookPane());
    }


}
