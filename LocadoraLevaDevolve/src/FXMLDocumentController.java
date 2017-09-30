import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtFieldUsuario;
    
    @FXML
    private TextField txtFieldSenha;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private void Login(ActionEvent event) {
        txtFieldUsuario.getText();
        txtFieldUsuario.getText();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
