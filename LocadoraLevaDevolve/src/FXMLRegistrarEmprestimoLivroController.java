import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import mapeamentos.Cliente;
import mapeamentos.Emprestimo;
import mapeamentos.EmprestimoItem;
import mapeamentos.EmprestimoItemPk;
import mapeamentos.Livro;
import persistencia.DAO;

public class FXMLRegistrarEmprestimoLivroController implements Initializable 
{
    private final DAO dao = new DAO();
    
    private Emprestimo emprestimo;
    private Livro livro;
    
    @FXML
    private TableView tableList;

    @FXML
    private TableColumn columnLivroNome;

    @FXML
    private TableColumn columnLivroPreco;
    
    @FXML
    private ComboBox comboLivro;
    
    @FXML
    private ComboBox comboCliente;
    
    @FXML
    DatePicker pickerData;
    
    private ObservableList livrosEmprestimo = FXCollections.observableArrayList();
    private ObservableList<Livro> listaLivros;
    private ObservableList<Cliente> listaClientes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnLivroNome.setCellValueFactory(new PropertyValueFactory("nome"));
        columnLivroPreco.setCellValueFactory(new PropertyValueFactory("categoria"));
        
        listaLivros = dao.consultar(Livro.class);
        comboLivro.setItems(listaLivros);
        
        listaClientes = dao.consultar(Cliente.class);
        comboCliente.setItems(listaClientes);
    }
    
    @FXML
    private void onAddLivro(ActionEvent event) throws IOException
    {
        livro = listaLivros.get(comboLivro.getSelectionModel().getSelectedIndex());
        
        livrosEmprestimo.add(livro);
        
        tableList.setItems(livrosEmprestimo);
        
        comboLivro.getItems().remove(livro);
    }
    
    @FXML
    private void onRemoverLivro(ActionEvent event) throws IOException
    {   
        int selectedIndex = tableList.getSelectionModel().getSelectedIndex();
        
        comboLivro.getItems().add(livrosEmprestimo.get(selectedIndex));
        tableList.getItems().remove(selectedIndex);
    }
    
    @FXML
    private void onRegistrarEmprestimo(ActionEvent event) throws IOException
    {   
        Cliente cliente = listaClientes.get(comboCliente.getSelectionModel().getSelectedIndex());
        
        LocalDate localDate = pickerData.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(cliente);
        emprestimo.setData_emprestimo(date);
        emprestimo.setStatus("em andamento");
        
        dao.salvar(emprestimo);
        
        double total = 0;

        for(int i = 0; i < livrosEmprestimo.size(); i++){
            EmprestimoItem item = new EmprestimoItem();
            
            Livro livro = (Livro) livrosEmprestimo.get(i);
            
            item.setChaveComposta(new EmprestimoItemPk());
            item.getChaveComposta().setLivro(livro);
            item.getChaveComposta().setEmprestimo(emprestimo);
            item.setPreco_livro(livro.getCategoria().getPreco());
            
            dao.salvar(item);
            
            total += livro.getCategoria().getPreco();
        }
        
        emprestimo.setTotal(total);
        dao.update(emprestimo);
        
        JOptionPane.showMessageDialog(null, "Empréstimo registrado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        comboCliente.getSelectionModel().select(null);
        pickerData.getEditor().clear();
        
        livrosEmprestimo.clear();
        tableList.getItems().clear();
    }
        
}
