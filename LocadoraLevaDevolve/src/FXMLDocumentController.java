import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import mapeamentos.Funcionario;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtFieldUsuario;
    
    @FXML
    private TextField txtFieldSenha;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private void Login(ActionEvent event) {
        
        if(txtFieldUsuario.getText().equals("") || txtFieldSenha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Login ou Senha inválido.", "", JOptionPane.ERROR_MESSAGE);
        }else{
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("endereço_do_banco:5432","postgres","postgres");
                Statement stm = con.createStatement();
                String SQL = "Select login, senha from funcionarios where login = '"+ txtFieldUsuario.getText()+"';";
                ResultSet rs = stm.executeQuery(SQL);
                while(rs.next()) {
                    String loginn = rs.getString("login");
                    String senhaa = rs.getString("senha");
                    String nomee = rs.getString("nome");
                    if(txtFieldUsuario.getText().equals(loginn) && txtFieldSenha.getText().equals(senhaa)){
                        JOptionPane.showMessageDialog(null,"Seja bem vindo: " + nomee,"",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"Login ou Senha inválidos.","",JOptionPane.ERROR_MESSAGE);
                        txtFieldSenha.setText("");
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","",JOptionPane.WARNING_MESSAGE);
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                try{
                    con.close();
                }catch(SQLException onConClose){
                    JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                }
            }
        }
        txtFieldUsuario.setText("");
        txtFieldSenha.setText("");

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
