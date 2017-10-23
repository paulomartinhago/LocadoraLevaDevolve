import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import mapeamentos.Cliente;
import persistencia.DAO;

public class FXMLCadastrarClienteController implements Initializable {

    private DAO dao = new DAO();

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TableView tableList;

    @FXML
    private TableColumn columnId;

    @FXML
    private TableColumn columnNome;

    private ObservableList<Cliente> listaClientes;

    @FXML
    private void onCadastraCliente(ActionEvent event) throws IOException
    {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);

        dao.salvar(cliente);

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);

        carregaDadosTabela();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(new PropertyValueFactory("cliente_id"));
        columnNome.setCellValueFactory(new PropertyValueFactory("nome"));

        carregaDadosTabela();
    }

    private void carregaDadosTabela() {
        listaClientes = dao.consultar(Cliente.class);
        tableList.setItems(listaClientes);

//        listaPokemon = dao.consultar(Pokemon.class);
//        tv_pokemon.setItems(listaPokemon);
    }

}
