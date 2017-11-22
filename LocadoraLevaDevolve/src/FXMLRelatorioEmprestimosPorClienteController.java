import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import mapeamentos.Cliente;
import persistencia.DAO;
import reports.Gerador;

public class FXMLRelatorioEmprestimosPorClienteController implements Initializable 
{    
    private final DAO dao = new DAO();
    
    @FXML
    private ComboBox comboClientes;
    
    private ObservableList<Cliente> listaClientes;
    
    @FXML
    private void onGerarRelatorio(ActionEvent event) throws IOException
    {
        Cliente cliente = listaClientes.get(comboClientes.getSelectionModel().getSelectedIndex());
        
        Gerador gerador = new Gerador();
        gerador.geraRelatorioEmprestimosPorCliente(cliente);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        listaClientes = dao.consultar(Cliente.class);
        comboClientes.setItems(listaClientes);
    }    
    
}
