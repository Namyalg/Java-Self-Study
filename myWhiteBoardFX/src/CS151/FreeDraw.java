package CS151;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.application.Application;
//import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import javafx.scene.layout.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class FreeDraw {

    public void display() {

        Canvas canvas = new Canvas(800, 500);


        ColorPicker cp = new ColorPicker();
        Slider slider = new Slider();
        Label label= new Label("1");
        GridPane grid = new GridPane();

        StackPane pane = new StackPane();
        Scene scene=new Scene(pane,800,500);
        scene.setFill(Color.rgb(242,242,242));
        Stage stage = new Stage();
        stage.setTitle("myDoodleBoard");
        Label col = new Label("Color:");
        col.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
        Label size = new Label("Size:");
        size.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
        Button erase = new Button("ERASER");
        Button exit = new Button("EXIT DOODLE MODE");

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);

        cp.setValue(Color.BLUE);
        cp.setOnAction(e->{
                    gc.setStroke(cp.getValue());
                }
        );
        erase.setOnAction(e->{
                    gc.setStroke(Color.rgb(242,242,242));
                }
        );
        //real time drawing function

        scene.setOnMousePressed(e-> {
                    gc.beginPath();
                    gc.lineTo(e.getSceneX(), e.getSceneY());
                    gc.stroke();
                }
        );
        scene.setOnMouseDragged(e->{
                    gc.lineTo(e.getSceneX(), e.getSceneY());
                    gc.stroke();
                }
        );

        exit.setOnAction(e -> {
            stage.close();
        });

        slider.setMin(1);
        slider.setMax(10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().addListener(e->{
            double val=slider.getValue();
            String str = String.format("%.1f",val);
            label.setText(str);
            gc.setLineWidth(val);
        });
        grid.addRow(0, col ,cp, size, slider, label, erase, exit);
        grid.setHgap(20);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(20,10,0,10));
        // pane.setBackground(background);


        pane.getChildren().addAll(canvas, grid);
        stage.setScene(scene);
        stage.show();


    }





}

