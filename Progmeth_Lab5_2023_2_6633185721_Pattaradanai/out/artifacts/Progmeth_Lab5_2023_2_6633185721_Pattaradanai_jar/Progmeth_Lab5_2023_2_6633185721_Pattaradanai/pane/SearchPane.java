package pane;

import item.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class SearchPane extends HBox {
    public SearchPane(){
        setAlignment(Pos.CENTER);
        TextField tmp = new TextField();
        tmp.setPromptText("Find the book");
        tmp.setPrefWidth(250);
        Button search = new Button("Search");
        search.setBackground(Background.fill(Color.DARKCYAN));
        search.setTextFill(Color.WHITE);
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (tmp.getText().isBlank()){
                    BookListPane tmp = BookListPane.getInstance();
                    tmp.setSearchedBooks(tmp.getBooks());
                }else{
                    ArrayList<Book> check = new ArrayList<>(BookListPane.getInstance().getBooks());
                    check.removeIf(book -> !book.getName().equals(tmp.getText()) );
                    BookListPane.getInstance().setSearchedBooks(check);
                }
            }
        });
        getChildren().add(tmp);
        getChildren().add(search);
    }
}
