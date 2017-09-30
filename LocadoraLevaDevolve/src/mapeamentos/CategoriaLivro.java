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
@SequenceGenerator(name="categoria_livro_seq", sequenceName="categoria_livro_sequence", allocationSize=1)
@Table(name="categoria_livro")
public class CategoriaLivro implements Serializable 
{
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_livro_seq")
    private Integer categoria_id;
    
    @OneToMany(mappedBy = "categoria", targetEntity = Livro.class, fetch = FetchType.LAZY)
    private List<Livro> livros;
    
    @Column(nullable = false, length = 30)
    private String nome;
    
    @Column
    private String descricao;
    
    @Column
    private Double preco;

    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    
}
