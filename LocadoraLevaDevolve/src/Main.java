import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mapeamentos.Funcionario;
//import persistencia.TesteDePersistencia;

public class Main extends Application 
{
    public static Stage myStage;
    public static Funcionario usuario;
    
    @Override
    public void start(final Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        myStage = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
//        TesteDePersistencia testeDePersistencia = new TesteDePersistencia();
//        testeDePersistencia.testar();
    }
    
}
