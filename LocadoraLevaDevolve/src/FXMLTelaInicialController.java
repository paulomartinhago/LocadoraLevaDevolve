import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FXMLTelaInicialController implements Initializable {
    
    @FXML
    private void onMenuCadastrarCliente(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCadastrarCliente.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
