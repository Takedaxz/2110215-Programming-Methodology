package pane;

import item.Book;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Goto;

public class NewBookPane extends GridPane {
    public NewBookPane() {
        setPadding(new Insets(12));
        setVgap(8);
        TextField name = input();
        TextField author = input();
        TextField rating = input();
        TextField image = input();
        TextField description = input();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col1.setPercentWidth(25);
        col1.setHalignment(HPos.RIGHT);
        col2.setPercentWidth(75);
        Button add =new Button("Add");
        add.setMaxWidth(430);
        add.setPrefHeight(32);
        add.setTextFill(Color.WHITE);
        add.setBackground(Background.fill(Color.DARKCYAN));
        add.setOnMouseClicked(e->handleClick(name.getText(),author.getText(),rating.getText(),image.getText(),description.getText()));
        getColumnConstraints().add(col1);
        getColumnConstraints().add(col2);
        add(label("Title:"),0,0);
        add(label("Author:"),0,1);
        add(label("Rating:"),0,2);
        add(label("Image:"),0,3);
        add(label("Description:"),0,4);
        add(name,1,0);
        add(author,1,1);
        add(rating,1,2);
        add(image,1,3);
        add(description,1,4);
        add(add,0,5,2,1);
    }



    private Text label(String s) {
        Text tmp = new Text(s);
        tmp.setFont(new Font(16));
        return tmp;
    }

    private TextField input() {
        TextField tmp = new TextField();
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, new CornerRadii(16), null);
        Background background = new Background(backgroundFill);
        tmp.setBackground(background);
        tmp.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID, new CornerRadii(16), null)));
        return tmp;
    }
    private void handleClick(String name, String author, String rating, String image, String description){
        if (!name.isEmpty() && !author.isEmpty() && !rating.isEmpty() && !image.isEmpty() && !description.isEmpty()){
            Book tmp = new Book(name,author,rating,image,description);
            BookListPane check = BookListPane.getInstance();
            check.getBooks().add(tmp);
            check.setSearchedBooks(check.getBooks());
            Goto.mainPage();
        }
    }
}
