package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class BasicOpsTest extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("WhiteBoard");



        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);

        cp.setValue(Color.BLUE);
        cp.setOnAction(e->{
            gc.setStroke(cp.getValue());

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
        grid.addRow(0, cp, slider, label);
        grid.setHgap(20);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(20,10,0,10));


        pane.getChildren().addAll(canvas, grid);
        stage.setScene(scene);
        stage.show();


    }
    Canvas canvas = new Canvas(800, 500);
    GraphicsContext gc;
    ColorPicker cp = new ColorPicker();
    Slider slider = new Slider();
    Label label= new Label("1");
    GridPane grid = new GridPane();

    StackPane pane = new StackPane();
    Scene scene=new Scene(pane,800,500);

    public static void main(String[] args) {
        launch(args);
    }

}


