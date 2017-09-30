package mapeamentos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="cliente_seq", sequenceName="cliente_sequence", allocationSize=1)
@Table(name="cliente")
public class Cliente implements Serializable 
{
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
    private Integer cliente_id;
    
    @OneToMany(mappedBy = "cliente", targetEntity = Emprestimo.class, fetch = FetchType.LAZY)
    private List<Emprestimo> emprestimos;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(length = 15)
    private String telefone;

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    

}
