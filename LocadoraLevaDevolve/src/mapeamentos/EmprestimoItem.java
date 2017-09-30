package mapeamentos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmprestimoItem implements Serializable 
{    
    @EmbeddedId
    private EmprestimoItemPk chaveComposta;
    
    @Column(nullable = false)
    private Double preco_livro;

    public EmprestimoItemPk getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(EmprestimoItemPk chaveComposta) {
        this.chaveComposta = chaveComposta;
    }

    public Double getPreco_livro() {
        return preco_livro;
    }

    public void setPreco_livro(Double preco_livro) {
        this.preco_livro = preco_livro;
    }
    
    

}
