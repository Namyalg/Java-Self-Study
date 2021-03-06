package CS151;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class savePngFile extends InputWindow {
	public savePngFile(Whiteboard gui, String title, String lbl, String btn, String defaultTxt) {
		super(gui, title, lbl, btn, defaultTxt);
	}

	public void save(File file) {
		gui.getCanvas().removeKnobs();
		WritableImage image = gui.getCanvas().snapshot(new SnapshotParameters(), null);

		if (canvas.getSelected() != null)
		    gui.getCanvas().addKnobs();
		
		// TODO: probably use a file chooser here
		
		
		try {
		    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		} catch (IOException e) {
		    // ignored?
		}
	}

	public void performAction(TextField input) {
		if (input.getText().length() == 0) {
			Warning.display();
		}	
		else {
			File f = new File(input.getText());
			save(f);
			stage.close();
		}
	}



}
