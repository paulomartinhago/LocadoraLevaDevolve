import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class FXMLTelaInicialController implements Initializable 
{
    @FXML
    private AnchorPane content;
    
    @FXML
    private MenuItem btnProfissional;
    
    @FXML
    private MenuItem btnCategoria;
    
    @FXML
    private Text txtNome;

    @FXML
    private void onMenuCadastrarCliente(ActionEvent event) throws IOException
    {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLCadastrarCliente.fxml"));
        content.getChildren().setAll(tela);
    }
    
    @FXML
    private void onMenuCadastrarProfissional(ActionEvent event) throws IOException
    {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLCadastrarProfissional.fxml"));
        content.getChildren().setAll(tela);
    }
    
    @FXML
    private void onMenuCadastrarCategoriaLivro(ActionEvent event) throws IOException
    {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLCadastrarCategoriaLivro.fxml"));
        content.getChildren().setAll(tela);
    }
    
    @FXML
    private void onMenuCadastrarLivro(ActionEvent event) throws IOException
    {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLCadastrarLivro.fxml"));
        content.getChildren().setAll(tela);
    }
    
    @FXML
    private void onMenuRegistrarEmprestimoLivro(ActionEvent event) throws IOException
    {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLRegistrarEmprestimoLivro.fxml"));
        content.getChildren().setAll(tela);
    }
    
    @FXML
    private void onMenuRegistrarDevolucaoLivro(ActionEvent event) throws IOException
    {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLRegistrarDevolucaoLivro.fxml"));
        content.getChildren().setAll(tela);
    }
    
    @FXML
    public void onMenuRelatorioEmprestimosPorCliente(ActionEvent event) throws IOException
    {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLRelatorioEmprestimosPorCliente.fxml"));
        content.getChildren().setAll(tela);
    }
    
    @FXML
    public void onMenuRelatorioEmprestimosEmAndamento(ActionEvent event) throws IOException
    {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLRelatorioEmprestimosEmAndamento.fxml"));
        content.getChildren().setAll(tela);
    }
    
    @FXML
    public void onLogout(ActionEvent event) throws IOException
    {
        Dialog<ButtonType> confirm = new Dialog<>();
        confirm.getDialogPane().setContentText("Deseja realmente sair?");
        confirm.getDialogPane().getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        
        if( ! confirm.showAndWait().filter(ButtonType.YES::equals).isPresent() )
            return;
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNome.setText("Seja bem-vindo(a), " + Main.usuario.getNome());
        
        if(Main.usuario.getPermissao().equals("locador")){
            btnProfissional.setVisible(false);
            btnCategoria.setVisible(false);
        }
    }

}
