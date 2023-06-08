package Model;
// Generated 09/06/2023 00:04:05 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */

@Entity
@Table(name="usuario"
    ,catalog="gestao_rpmonografia")

public class Usuario  implements java.io.Serializable {


     @Id
     private Integer id;
     private String nome;
     private String username;
     private String senha;
     private Set monografias = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nome, String username, String senha) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
    }
    public Usuario(String nome, String username, String senha, Set monografias) {
       this.nome = nome;
       this.username = username;
       this.senha = senha;
       this.monografias = monografias;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Set getMonografias() {
        return this.monografias;
    }
    
    public void setMonografias(Set monografias) {
        this.monografias = monografias;
    }




}

