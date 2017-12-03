package controllers;

import main.Main;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import mapeamentos.Funcionario;
import persistencia.DAO;

public class FXMLLoginController implements Initializable 
{    
    @FXML
    private TextField txtFieldUsuario;
    
    @FXML
    private PasswordField txtFieldSenha;
    
    @FXML
    private Button btnLogin;
    
    private ObservableList<Funcionario> listaFuncionarios;
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        if(txtFieldUsuario.getText().equals("") || txtFieldSenha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Login ou Senha inválido.", "", JOptionPane.ERROR_MESSAGE);
        } else {
            DAO dao = new DAO();
            
            listaFuncionarios = dao.consultar(Funcionario.class);
            
            Boolean logado = false;
            Funcionario usuario = null;

            for (int i = 0; i < listaFuncionarios.size(); i++){
                if(
                    listaFuncionarios.get(i).getLogin().equals(txtFieldUsuario.getText()) &&
                    listaFuncionarios.get(i).getSenha().equals(txtFieldSenha.getText()) 
                ){
                    logado = true;
                    usuario = listaFuncionarios.get(i);
                }
            }
            
            if(logado){
                Main.usuario = usuario;
                
                Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLTelaInicial.fxml"));
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
