import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.print.DocFlavor.STRING;

import org.json.JSONArray;
import org.json.JSONObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ControllerMobile1 {


    @FXML
    private VBox ypane;
    @FXML
    private Label title;
    @FXML
    private Button button;

    String opcions[] = { "Personatges", "Jocs", "Consoles" };
    public void initialize(String type) {  
        try{
          System.out.println(type);
            title.setText(type);
            loadList(type);
        }catch (Exception e) {
                
                e.printStackTrace();
            }

        
    }
    public void loadList(String type) {
        // Obtenir l'opció seleccionada
        String opcio = type;
        // Obtenir una referència a AppData que gestiona les dades
        AppData appData = AppData.getInstance();
        // Mostrar el missatge de càrrega
        
        // Demanar les dades
        appData.load(opcio, (result) -> {
            if (result == null) {
              System.out.println("ControllerDesktop: Error loading data.");
            } else {
              // Cal afegir el try/catch a la crida de ‘showList’
              try {
                showList( type);
              } catch (Exception e) {
                System.out.println("ControllerDesktop: Error showing list.");
              }
            }
          });
    
        }
        public void showList(String type) throws Exception{
      String opcioSeleccionada = type;
      AppData appData = AppData.getInstance();
      JSONArray dades = appData.getData(opcioSeleccionada);
      URL resource = this.getClass().getResource("assets/template_list_item.fxml");
      
      // Esborrar la llista actual
      ypane.getChildren().clear();

      for (int i = 0; i < dades.length(); i++) {
        JSONObject consoleObject = dades.getJSONObject(i);
        if (consoleObject.has("nom")) {
          String nom = consoleObject.getString("nom");
          String imatge = "assets/images/" + consoleObject.getString("imatge");
          FXMLLoader loader = new FXMLLoader(resource);
          Parent itemTemplate = loader.load();
          ControllerListItem itemController = loader.getController();
          itemController.setText(nom);
          itemController.setImage(imatge);

        final String type2 = opcioSeleccionada;
        final int index = i;
        
        
      ypane.getChildren().add(itemTemplate);
      }
      }
}

    
    
    


    
    
 
}
