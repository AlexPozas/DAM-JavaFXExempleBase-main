import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ControllerMobile0 implements Initializable{


    @FXML
    private VBox ypane;
    @FXML
    private Label title;

    String opcions[] = { "Personatges", "Jocs", "Consoles" };
    public void initialize(URL url, ResourceBundle rb) {  
        try{
            title.setText("Nintendo DB");
            loadList();
        }catch (Exception e) {
                
                e.printStackTrace();
            }
        
    }
    public void loadList() {
        // Obtenir l'opció seleccionada
        String opcio = opcions[0];
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
                showList();
              } catch (Exception e) {
                System.out.println("ControllerDesktop: Error showing list.");
              }
            }
          });
    
        }
        public void showList() throws Exception{
      String opcioSeleccionada = opcions[0];
      AppData appData = AppData.getInstance();
      JSONArray dades = appData.getData(opcioSeleccionada);
      URL resource = this.getClass().getResource("assets/template_list_item.fxml");
      
      // Esborrar la llista actual
      ypane.getChildren().clear();

      for (int i = 0; i < opcions.length; i++) {
        
          FXMLLoader loader = new FXMLLoader(resource);
          Parent itemTemplate = loader.load();
          ControllerListItem itemController = loader.getController();
          itemController.setText(opcions[i]);
          
            final String type = opcioSeleccionada;
            
            final int index = i;
            ControllerMobile1 mobil1 = new ControllerMobile1();
            
          itemTemplate.setOnMouseClicked(event -> {
            mobil1.initialize(type);

          });
      ypane.getChildren().add(itemTemplate);
      
      }
}

    
    
    


    
    
 
}
