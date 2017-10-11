import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.text.html.ListView;

public class FXMLRegistrarEmprestimoLivroController implements Initializable {
    
    @FXML
    TextField txtNomeLivro;
    TextField txtNomeCliente;
    DatePicker pickerData;
    Button btnAddLivro;
    ListView listLivros;
    Button btnRegistrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
