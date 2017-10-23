import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import persistencia.TesteDePersistencia;

public class Main extends Application 
{
    public static Stage myStage;
    
    @Override
    public void start(final Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTelaInicial.fxml"));
        
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
