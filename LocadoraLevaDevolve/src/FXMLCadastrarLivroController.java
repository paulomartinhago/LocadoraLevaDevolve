import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLCadastrarLivroController implements Initializable {
    
    @FXML
    TextField txtNome;
    
    @FXML
    ToggleGroup grupoCategoria;
    
    @FXML
    RadioButton btnNovo;
    RadioButton btnImportado;
    RadioButton btnRaro;
    
    @FXML
    Button btnCadastrarLivro;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
