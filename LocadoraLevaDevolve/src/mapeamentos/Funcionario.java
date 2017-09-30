package mapeamentos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="funcionario_seq", sequenceName="funcionario_sequence", allocationSize=1)
@Table(name="funcionario")
public class Funcionario implements Serializable 
{
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="funcionario_seq")
    private Integer profissional_id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(unique = true, nullable = false, length = 45)
    private String login;
    
    @Column(nullable = false, length = 20)
    private String senha;
    
    @Column(nullable = false, length = 10)
    private String permissao;

    public Integer getProfissional_id() {
        return profissional_id;
    }

    public void setProfissional_id(Integer profissional_id) {
        this.profissional_id = profissional_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        String p = "gerente";
        
        if(!permissao.equals(p))
            p = "locador";
        
        this.permissao = p;
    }
}
