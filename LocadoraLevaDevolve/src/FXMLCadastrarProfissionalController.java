import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import mapeamentos.Funcionario;
import persistencia.DAO;

public class FXMLCadastrarProfissionalController implements Initializable 
{    
    private final DAO dao = new DAO();
    
    private Funcionario funcionario;
    
    @FXML
    private TableView tableList;

    @FXML
    private TableColumn columnId;

    @FXML
    private TableColumn columnNome;
    
    @FXML
    private TableColumn columnLogin;
    
    @FXML
    private TableColumn columnPermissao;
    
    @FXML
    TextField txtNome;
    
    @FXML
    TextField txtLogin;
    
    @FXML
    TextField txtSenha;
    
    @FXML
    private ComboBox comboPermissao;
    
    private ObservableList<Funcionario> listaFuncionarios;
    
    @FXML
    private void onCadastraFuncionario(ActionEvent event) throws IOException
    {       
        String nome = txtNome.getText();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        String permissao = comboPermissao.getSelectionModel().getSelectedItem().toString();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setLogin(login);
        funcionario.setSenha(senha);
        funcionario.setPermissao(permissao);
        
        dao.salvar(funcionario);

        JOptionPane.showMessageDialog(null, "Profissional cadastrado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);

        carregaDadosTabela();
    }
    
    @FXML
    private void onEditarFuncionario(ActionEvent event) throws IOException
    {
        String nome = txtNome.getText();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        String permissao = comboPermissao.getSelectionModel().getSelectedItem().toString();
        
        funcionario.setNome(nome);
        funcionario.setLogin(login);
        funcionario.setSenha(senha);
        funcionario.setPermissao(permissao);
        
        dao.update(funcionario);
        
        JOptionPane.showMessageDialog(null, "Profissional atualizado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        carregaDadosTabela();        
    }
    
    @FXML
    private void onExcluirFuncionario(ActionEvent event) throws IOException
    {
        dao.delete(funcionario);
        
        txtNome.setText(null);
        txtLogin.setText(null);
        txtSenha.setText(null);
        comboPermissao.getSelectionModel().select(null);
        
        JOptionPane.showMessageDialog(null, "Profissional removido com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        carregaDadosTabela();
    }
    
    @FXML
    public void eventoTabela(MouseEvent event) {
        funcionario = listaFuncionarios.get(tableList.getSelectionModel().getFocusedIndex());
        
        txtNome.setText(funcionario.getNome());
        txtLogin.setText(funcionario.getLogin());
        comboPermissao.getSelectionModel().select(funcionario.getPermissao());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(new PropertyValueFactory("profissional_id"));
        columnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        columnLogin.setCellValueFactory(new PropertyValueFactory("login"));
        columnPermissao.setCellValueFactory(new PropertyValueFactory("permissao"));
        
        comboPermissao.getItems().addAll("gerente", "locador");

        carregaDadosTabela();
    }    
    
    private void carregaDadosTabela() {
        listaFuncionarios = dao.consultar(Funcionario.class);
        tableList.setItems(listaFuncionarios);
    }
    
}
