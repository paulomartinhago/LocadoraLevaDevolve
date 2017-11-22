import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import mapeamentos.Cliente;
import persistencia.DAO;

public class FXMLCadastrarClienteController implements Initializable {

    private final DAO dao = new DAO();
    
    private Cliente cliente;

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
    
    @FXML
    private TableColumn columnTelefone;

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
    
    @FXML
    private void onEditarCliente(ActionEvent event) throws IOException
    {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        dao.update(cliente);
        
        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        carregaDadosTabela();        
    }
    
    @FXML
    private void onExcluirCliente(ActionEvent event) throws IOException
    {
        dao.delete(cliente);
        
        txtNome.setText(null);
        txtTelefone.setText(null);
        
        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        carregaDadosTabela();
    }
    
    @FXML
    public void eventoTabela(MouseEvent event) {
        cliente = listaClientes.get(tableList.getSelectionModel().getFocusedIndex());
        
        txtNome.setText(cliente.getNome());
        txtTelefone.setText(cliente.getTelefone());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(new PropertyValueFactory("cliente_id"));
        columnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        columnTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));

        carregaDadosTabela();
    }

    private void carregaDadosTabela() {
        listaClientes = dao.consultar(Cliente.class);
        tableList.setItems(listaClientes);
    }

}
