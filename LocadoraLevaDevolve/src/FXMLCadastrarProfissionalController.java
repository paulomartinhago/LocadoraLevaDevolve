import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLCadastrarProfissionalController implements Initializable {
    
    @FXML
    TextField txtNome;
    TextField txtLogin;
    TextField txtSenha;
    
    @FXML
    ToggleGroup groupPermissao;
    
    @FXML
    RadioButton radioGerente;
    RadioButton radioFuncionario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
