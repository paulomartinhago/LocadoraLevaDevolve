package mapeamentos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@SequenceGenerator(name="emprestimo_seq", sequenceName="emprestimo_sequence", allocationSize=1)
@Table(name="emprestimo")
public class Emprestimo implements Serializable 
{
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="emprestimo_seq")
    private Integer emprestimo_id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "emprestimoItem", targetEntity = Emprestimo.class, fetch = FetchType.LAZY)
    private Collection<EmprestimoItem> emprestimoItem;
    
    @Column(nullable = false, length = 15)
    private String status;

    @Column(nullable = false)
    @Type(type="date")
    private Date data_emprestimo;

    @Column
    @Type(type="date")
    private Date data_devolucao;

    public Integer getEmprestimo_id() {
        return emprestimo_id;
    }

    public void setEmprestimo_id(Integer emprestimo_id) {
        this.emprestimo_id = emprestimo_id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Collection<EmprestimoItem> getEmprestimoItem() {
        return emprestimoItem;
    }

    public void setEmprestimoItem(Collection<EmprestimoItem> emprestimoItem) {
        this.emprestimoItem = emprestimoItem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String s = "em andamento";
        
        if(!status.equals(s))
            s = "concluído";
        
        this.status = s;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    

}
