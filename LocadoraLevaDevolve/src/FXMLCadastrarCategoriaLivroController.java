import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLCadastrarCategoriaLivroController implements Initializable {
    
    @FXML
    TextField txtNome;
    TextField txtDescricao;
    TextField txtPreco;
    Button btnCadastrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
