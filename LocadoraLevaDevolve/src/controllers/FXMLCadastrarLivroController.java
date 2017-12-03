package controllers;

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
import mapeamentos.CategoriaLivro;
import mapeamentos.Livro;
import persistencia.DAO;

public class FXMLCadastrarLivroController implements Initializable 
{    
    private final DAO dao = new DAO();
    
    private Livro livro;
    
    @FXML
    private TableView tableList;

    @FXML
    private TableColumn columnId;

    @FXML
    private TableColumn columnNome;
    
    @FXML
    private TableColumn columnCategoria;
    
    @FXML
    TextField txtNome;
    
    @FXML
    private ComboBox comboCategoria;
    
    private ObservableList<CategoriaLivro> listaCategorias;
    private ObservableList<Livro> listaLivros;
    
    @FXML
    private void onCadastraLivro(ActionEvent event) throws IOException
    {       
        String nome = txtNome.getText();
        
        Livro livro = new Livro();
        livro.setNome(nome);
        livro.setCategoria(listaCategorias.get(comboCategoria.getSelectionModel().getSelectedIndex()));
        
        dao.salvar(livro);

        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);

        carregaDadosTabela();
    }
    
    @FXML
    private void onEditarLivro(ActionEvent event) throws IOException
    {
        String nome = txtNome.getText();
        
        livro.setNome(nome);
        livro.setCategoria(listaCategorias.get(comboCategoria.getSelectionModel().getSelectedIndex()));
        
        dao.update(livro);
        
        JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        carregaDadosTabela();        
    }
    
    @FXML
    private void onExcluirLivro(ActionEvent event) throws IOException
    {
        dao.delete(livro);
        
        txtNome.setText(null);
        comboCategoria.getSelectionModel().select(null);
        
        JOptionPane.showMessageDialog(null, "Livro removido com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        
        carregaDadosTabela();
    }
    
    @FXML
    public void eventoTabela(MouseEvent event) {
        livro = listaLivros.get(tableList.getSelectionModel().getFocusedIndex());
        
        txtNome.setText(livro.getNome());
        comboCategoria.getSelectionModel().select(livro.getCategoria());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnId.setCellValueFactory(new PropertyValueFactory("livro_id"));
        columnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        columnCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
        
        listaCategorias = dao.consultar(CategoriaLivro.class);
        comboCategoria.setItems(listaCategorias);

        carregaDadosTabela();
    }    
    
    private void carregaDadosTabela() {
        listaLivros = dao.consultar(Livro.class);
        tableList.setItems(listaLivros);
    } 
    
}
