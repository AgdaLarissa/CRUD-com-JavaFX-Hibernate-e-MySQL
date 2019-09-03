package entity;
// Generated 14/08/2019 14:06:28 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios"
    ,catalog="usuario"
)
public class Usuarios  implements java.io.Serializable {


     private Integer idUsuario;
     private String nome;
     private String login;
     private String senha;

    public Usuarios() {
    }

    public Usuarios(String nome, String login, String senha) {
       this.nome = nome;
       this.login = login;
       this.senha = senha;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_usuario", unique=true, nullable=false)
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    @Column(name="nome")
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="login")
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="senha")
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }




}

