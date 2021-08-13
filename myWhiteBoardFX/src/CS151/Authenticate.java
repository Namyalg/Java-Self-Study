package CS151;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.regex.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.application.Application;
//import javafx.scene.Group;
import javafx.scene.image.WritableImage;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import javafx.scene.Scene;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import javafx.scene.layout.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.shape.ArcType;
import javafx.stage.FileChooser;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.File;


public class Authenticate {

    public void display(ArrayList<Button> buttons, Label name, Stage primaryStage) {
       boolean check = false;
        for (Button btn : buttons)
            btn.setDisable(true);
        Stage stage = new Stage();
        Label  label  = new Label();
        Label title = new Label("Enter name and Password");
        TextField txf = new TextField("");
        PasswordField passwordField = new PasswordField();
        title.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
        Button saveButton = new Button("Verify");
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Pattern pat =  Pattern.compile("[a-zA-Z]{3,}");
                Pattern pswd = Pattern.compile("123");
                System.out.println(txf.getText());
                Matcher mat = pat.matcher(txf.getText());
                Matcher pswdmat = pswd.matcher(passwordField.getText());
                if (mat.matches() && pswdmat.matches()){
                    System.out.println("Authenticated");
                    name.setText(txf.getText());
                    primaryStage.setTitle("Welcome to mySlate " + txf.getText());
                    title.setText("Authenticated");
                    for (Button btn : buttons)
                        btn.setDisable(false);
                    stage.close();

                }
                else{
                    title.setText("Try again");
                }
            }
        });

        if(title.getText().equals("Try again")){
            System.out.println("Here");

        }
        else{
            System.out.println("Here it is correct");
            check = true;
        }

        VBox layout = new VBox(10,title, label, txf, passwordField, saveButton);
        layout.setStyle("-fx-padding: 10px; -fx-alignment: baseline-right");
        stage.setScene(new Scene(layout));
        stage.setTitle("Authenticate");
        stage.show();
    }
}
