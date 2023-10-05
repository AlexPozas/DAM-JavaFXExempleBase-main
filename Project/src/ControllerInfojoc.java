import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerInfojoc {

@FXML
  private ImageView img;

  @FXML
  private Label title = new Label();

  @FXML
  private Label text = new Label();
  private Label text1 = new Label();
  private Label text11 = new Label();

  public void setImage(String resourceName) {

    // Obté una referència al recurs dins del .jar
    ClassLoader classLoader = getClass().getClassLoader();
    Image image = new Image(classLoader.getResourceAsStream(resourceName));

    // Estableix la imatge a l'ImageView
    img.setImage(image);
  }
  public void setTitle(String text) {

    // Estableix el contingut del Label
    this.title.setText(text);
  }

  public void setText(String text) {
    // Estableix el contingut del Label
    this.text.setText(text);
  }
  public void setText1(String text) {
    // Estableix el contingut del Label
    this.text1.setText(text);

  }
  public void setText11(String text) {
    // Estableix el contingut del Label
    this.text11.setText(text);
  }

    
}
