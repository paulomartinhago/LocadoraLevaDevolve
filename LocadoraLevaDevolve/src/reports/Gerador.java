package reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import mapeamentos.Cliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Gerador 
{
   public void geraRelatorioEmprestimosPorCliente(Cliente cliente){
        try{
            Map<String, Object> parameters = new HashMap<>();
            Connection connection = new Conexao().getConnection(); 
            
            String sql = "SELECT" +
                " emprestimo.\"emprestimo_id\" AS emprestimo_emprestimo_id," +
                " emprestimo.\"data_devolucao\" AS emprestimo_data_devolucao," +
                " emprestimo.\"data_emprestimo\" AS emprestimo_data_emprestimo," +
                " emprestimo.\"status\" AS emprestimo_status," +
                " emprestimo.\"cliente_id\" AS emprestimo_cliente_id," +
                " cliente.\"nome\" AS nome_cliente" +
                " FROM" +
                " \"public\".\"emprestimo\" emprestimo" +
                " INNER JOIN" +
                " \"public\".\"cliente\" cliente ON cliente.cliente_id = emprestimo.cliente_id" +
                " WHERE emprestimo.cliente_id = " + cliente.getCliente_id() + "";
            
            System.out.println(sql);
            
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            JasperCompileManager.compileReportToFile("src/reports/report1.jrxml",
                                                        "src/reports/report1.jasper");
            
            JRResultSetDataSource jrRs = new JRResultSetDataSource (rs);
                        
            JasperPrint print = JasperFillManager.fillReport("src/reports/report1.jasper",
                                                                          parameters, jrRs);
            JasperViewer viewer = new JasperViewer(print, true );
            viewer.show();
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException | JRException e) {
            throw new RuntimeException(e);	
        }
    }
   
   public void geraRelatorioEmprestimosEmAndamento(){
        try{
            Map<String, Object> parameters = new HashMap<>();
            Connection connection = new Conexao().getConnection(); 
            
            String sql = "SELECT\n" +
            "     emprestimo.\"emprestimo_id\" AS emprestimo_emprestimo_id,\n" +
            "     emprestimo.\"data_emprestimo\" AS emprestimo_data_emprestimo,\n" +
            "     emprestimo.\"total\" AS emprestimo_total,\n" +
            "     cliente.\"nome\" AS cliente_nome\n" +
            "FROM\n" +
            "     \"public\".\"cliente\" cliente INNER JOIN \"public\".\"emprestimo\" emprestimo ON cliente.\"cliente_id\" = emprestimo.\"cliente_id\"";
            
            System.out.println(sql);
            
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            JasperCompileManager.compileReportToFile("src/reports/report2.jrxml",
                                                        "src/reports/report2.jasper");
            
            JRResultSetDataSource jrRs = new JRResultSetDataSource (rs);
                        
            JasperPrint print = JasperFillManager.fillReport("src/reports/report2.jasper",
                                                                          parameters, jrRs);
            JasperViewer viewer = new JasperViewer(print, true );
            viewer.show();
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException | JRException e) {
            throw new RuntimeException(e);	
        }
    }
}
