package CS151;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BrushSize  {


    public double display() {
        Stage stage = new Stage();
        Label  label  = new Label();
        Slider slider = new Slider(1, 10, 5);
        Label title = new Label("Brush Size:");
        title.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
        label.textProperty().bind(
                Bindings.format(
                        "%.2f",
                        slider.valueProperty()
                )
        );
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            stage.close();
        });

        VBox layout = new VBox(10,title, label, slider, saveButton);
        layout.setStyle("-fx-padding: 10px; -fx-alignment: baseline-right");

        stage.setScene(new Scene(layout));
        stage.setTitle("Brush Size");
        stage.show();
        return slider.valueProperty().getValue();

    }


}