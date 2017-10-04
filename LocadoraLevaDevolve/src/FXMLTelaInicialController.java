import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class FXMLTelaInicialController implements Initializable {
    
    @FXML
    private MenuBar menuBar;
    
    @FXML
    private Menu menu;
    
    @FXML
    private MenuItem btnCadastrar;
    private MenuItem btnRegistrar;
    private MenuItem btnRelatorios;
    private MenuItem btnSair;
    
    @FXML
    private MenuItem btnProfissional;
    private MenuItem btnLivro;
    private MenuItem btnCLiente;
    private MenuItem btnCategoriaLivro;
    
    @FXML
    private MenuItem btnEmprestimo;
    private MenuItem btnDevolucao;
    
    @FXML
    private MenuItem btnEmprestimoCLiente;
    private MenuItem btnEmprestimoAndamento;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
