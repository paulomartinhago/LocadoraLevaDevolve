import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import mapeamentos.Funcionario;
import persistencia.DAO;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtFieldUsuario;
    
    @FXML
    private PasswordField txtFieldSenha;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        if(txtFieldUsuario.getText().equals("") || txtFieldSenha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Login ou Senha inválido.", "", JOptionPane.ERROR_MESSAGE);
        } else {
            DAO dao = new DAO();
            
            ArrayList <Funcionario> lista;
            lista = (ArrayList <Funcionario>) dao.consultar(Funcionario.class);
            
            Boolean logado = false;
            Funcionario usuario = null;

            for (int i = 0; i < lista.size(); i++){
                if(
                    lista.get(i).getLogin().equals(txtFieldUsuario.getText()) &&
                    lista.get(i).getSenha().equals(txtFieldSenha.getText()) 
                ){
                    logado = true;
                    usuario = lista.get(i);
                }
            }
            
            if(logado){
                JOptionPane.showMessageDialog(null, "Seja bem vindo: " + usuario.getNome(), "", JOptionPane.INFORMATION_MESSAGE);
                
                Parent root = FXMLLoader.load(getClass().getResource("FXMLTelaInicial.fxml"));
                Scene scene = new Scene(root);
                Main.myStage.setScene(scene);
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha inválidos.", "", JOptionPane.ERROR_MESSAGE);
                txtFieldSenha.setText("");
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
