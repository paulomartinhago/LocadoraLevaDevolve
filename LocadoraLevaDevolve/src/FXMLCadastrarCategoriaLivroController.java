import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import mapeamentos.CategoriaLivro;
import persistencia.DAO;

public class FXMLCadastrarCategoriaLivroController implements Initializable 
{    
    private final DAO dao = new DAO();
    
    private CategoriaLivro categoria;
    
    @FXML
    private TableView tableList;

    @FXML
    private TableColumn columnId;

    @FXML
    private TableColumn columnNome;
    
    @FXML
    private TableColumn columnPreco;
    
    @FXML
    TextField txtNome;
    
    @FXML
    TextArea txtDescricao;
    
    @FXML
    TextField txtPreco;
    
    private ObservableList<CategoriaLivro> listaCategorias;
    
    @FXML
    private void onCadastraCategoria(ActionEvent event) throws IOException
    {       
        String nome = txtNome.getText();
        String preco = txtPreco.getText();
        String descricao = txtDescricao.getText();

        CategoriaLivro categoria = new CategoriaLivro();
        categoria.setNome(nome);
        categoria.setPreco(Double.parseDouble(preco));
        categoria.setDescricao(descricao);
        
        dao.salvar(categoria);

        JOptionPane.showMessageDialog(null, "Categoria de Livro cadastrada com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);

        carregaDadosTabela();
    }
    
    @FXML
    private void onEditarCategoria(ActionEvent event) throws IOException
    {
        String nome = txtNome.getText();
        String preco = txtPreco.getText();
        String descricao = txtDescricao.getText();

        categoria.setNome(nome);
        categoria.setPreco(Double.parseDouble(preco));
        categoria.setDescricao(descricao);
        
        dao.update(categoria);
        
        JOptionPane.showMessageDialog(null, "Categoria de Livro atualizada com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        carregaDadosTabela();        
    }
    
    @FXML
    private void onExcluirCategoria(ActionEvent event) throws IOException
    {
        dao.delete(categoria);
        
        txtNome.setText(null);
        txtPreco.setText(null);
        txtDescricao.setText(null);
        
        JOptionPane.showMessageDialog(null, "Categoria de Livro removida com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        carregaDadosTabela();
    }
    
    @FXML
    public void eventoTabela(MouseEvent event) {
        categoria = listaCategorias.get(tableList.getSelectionModel().getFocusedIndex());
        
        txtNome.setText(categoria.getNome());
        txtPreco.setText(categoria.getPreco().toString());
        txtDescricao.setText(categoria.getDescricao());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(new PropertyValueFactory("categoria_id"));
        columnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        columnPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        
        carregaDadosTabela();
    }    
    
    private void carregaDadosTabela() {
        listaCategorias = dao.consultar(CategoriaLivro.class);
        tableList.setItems(listaCategorias);
    }
    
}
