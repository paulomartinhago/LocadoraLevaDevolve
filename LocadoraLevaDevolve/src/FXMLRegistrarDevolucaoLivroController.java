import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class FXMLRegistrarDevolucaoLivroController implements Initializable {
    
    @FXML
    TextField txtNomeCliente;
    DatePicker dataDevolucao;
    Label labelTotal;
    Button btnRegistrar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
