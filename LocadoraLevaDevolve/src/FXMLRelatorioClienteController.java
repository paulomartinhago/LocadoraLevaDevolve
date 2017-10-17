import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import mapeamentos.Emprestimo;

public class FXMLRelatorioClienteController implements Initializable {
    
    @FXML
    TextField txtNomeCliente;
    Button btnPesquisar;
    TableView<Emprestimo> tableEmprestimo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
