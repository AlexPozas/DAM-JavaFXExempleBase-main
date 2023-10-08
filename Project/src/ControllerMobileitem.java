import java.net.URL;

import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class ControllerMobileitem {
@FXML
private AnchorPane info;

  @FXML
  private ImageView img;
  @FXML
  private Label title = new Label();
  @FXML
  private Label text = new Label();
  @FXML
  private Label text2 = new Label();

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
    this.text.setTextFill(Color.web(text));
    this.text.setText(text);
  }
  public void setText1(String text) {

    // Estableix el contingut del Label
    this.text2.setText(text);
  }
  String opcions[] = { "Personatges", "Jocs", "Consoles" };
  public void initialize() { 
    int numero =(int)Math.random()*2+1;
        

      try{

        UtilsViews.setView("Mobileitem"); 
        showInfo(opcions[numero-1],1);
        title.setText(opcions[numero-1]);

      }catch (Exception e) {
              
              e.printStackTrace();
          }

      
  }


  void showInfo(String type, int index) {
  
  AppData appData = AppData.getInstance();
  JSONObject dades = appData.getItemData(type, index);

  URL resource = this.getClass().getResource("assets/layout_info_mobil.fxml");
  info.getChildren().clear();
  try {
    FXMLLoader loader = new FXMLLoader(resource);
    Parent itemTemplate = loader.load();
    ControllerMobileitem itemController = loader.getController();
    itemController.setImage("assets/images/" + dades.getString("imatge"));
    itemController.setTitle(dades.getString("nom"));
    
    // Afegeix la informació a la vista
    info.getChildren().add(itemTemplate);

    } catch (Exception e) {
      System.out.println("ControllerDesktop: Error showing info.");
      System.out.println(e);
    }
  }
    
}
