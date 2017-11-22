import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import reports.Gerador;

public class FXMLRelatorioEmprestimosEmAndamentoController implements Initializable 
{    
    @FXML
    private void onGerarRelatorio(ActionEvent event) throws IOException
    {   
        Gerador gerador = new Gerador();
        gerador.geraRelatorioEmprestimosEmAndamento();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }    
    
}
