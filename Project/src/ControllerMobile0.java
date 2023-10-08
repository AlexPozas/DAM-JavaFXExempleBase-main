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
      
      URL resource = this.getClass().getResource("assets/template_list_item.fxml");
      
      // Esborrar la llista actual
      ypane.getChildren().clear();
          FXMLLoader loader = new FXMLLoader(resource);
          Parent itemTemplate1 = loader.load();
          ControllerListItem itemController = loader.getController();
          itemController.setText(opcions[0]);

          FXMLLoader loader2 = new FXMLLoader(resource);
          Parent itemTemplate2 = loader2.load();
          ControllerListItem itemController2 = loader2.getController();
          itemController2.setText(opcions[1]);

          FXMLLoader loader3 = new FXMLLoader(resource);
          Parent itemTemplate3 = loader3.load();
          ControllerListItem itemController3 = loader3.getController();
          itemController3.setText(opcions[2]);


          ControllerMobile1 mobil1= new ControllerMobile1();
          itemTemplate1.setOnMouseClicked(event -> {
                        
           mobil1.initialize();
            
 
          });
          
          itemTemplate2.setOnMouseClicked(event -> {
            mobil1.initialize();
 
          });
          
          itemTemplate3.setOnMouseClicked(event -> {
           mobil1.initialize();
            
 
          });
          
          
      ypane.getChildren().add(itemTemplate1);
      ypane.getChildren().add(itemTemplate2);
      ypane.getChildren().add(itemTemplate3);
      
      
      
      
}

    
    
    


    
    
 
}
