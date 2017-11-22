import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mapeamentos.Emprestimo;
import persistencia.DAO;

public class FXMLRegistrarDevolucaoLivroController implements Initializable 
{
    private final DAO dao = new DAO();
    
    private Emprestimo emprestimo;
    
    @FXML
    private TableView tableList;
    
    @FXML
    private TableColumn columnId;

    @FXML
    private TableColumn columnNome;

    @FXML
    private TableColumn columnDataEmprestimo;
    
    @FXML
    private TableColumn columnDataDevolucao;
    
    @FXML
    private TableColumn colummTotal;
    
    @FXML
    private DatePicker pickerData;
    
    private ObservableList<Emprestimo> listaEmprestimos;
    
    @FXML
    public void eventoTabela(MouseEvent event) {
        emprestimo = listaEmprestimos.get(tableList.getSelectionModel().getFocusedIndex());
    }
    
    @FXML
    private void onRegistrarDevolucao(ActionEvent event) throws IOException
    {
        LocalDate localDate = pickerData.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        
        emprestimo.setData_devolucao(date);
        emprestimo.setStatus("concluido");
        
        dao.update(emprestimo);
        
        carregaDadosTabela();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(new PropertyValueFactory("emprestimo_id"));
        columnNome.setCellValueFactory(new PropertyValueFactory("cliente"));
        columnDataEmprestimo.setCellValueFactory(new PropertyValueFactory("data_emprestimo"));
        columnDataDevolucao.setCellValueFactory(new PropertyValueFactory("data_devolucao"));
        colummTotal.setCellValueFactory(new PropertyValueFactory("total"));
        
        carregaDadosTabela();
    }    
    
    private void carregaDadosTabela()
    {
        listaEmprestimos = dao.consultar(Emprestimo.class);
        tableList.setItems(listaEmprestimos);
    }
}
