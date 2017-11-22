package mapeamentos;

import java.io.Serializable;
import java.util.Collection;
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

@Entity
@SequenceGenerator(name="livro_seq", sequenceName="livro_sequence", allocationSize=1)
@Table(name="livro")
public class Livro implements Serializable 
{
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="livro_seq")
    private Integer livro_id;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaLivro categoria;
    
    @OneToMany(mappedBy = "emprestimoItem", targetEntity = Livro.class, fetch = FetchType.LAZY)
    private Collection<EmprestimoItem> emprestimoItem;
    
    @Column(nullable = false, length = 45)
    private String nome;

    public Integer getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Integer livro_id) {
        this.livro_id = livro_id;
    }

    public CategoriaLivro getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLivro categoria) {
        this.categoria = categoria;
    }

    public Collection<EmprestimoItem> getEmprestimoItem() {
        return emprestimoItem;
    }

    public void setEmprestimoItem(Collection<EmprestimoItem> emprestimoItem) {
        this.emprestimoItem = emprestimoItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }

}
