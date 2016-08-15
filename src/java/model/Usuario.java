package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    
    @Id
    @Column(name = "ID_USUARIO",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "NOME", nullable = false)
    private String nome;
    
    @Column(name = "TELEFONE")
    private String telefone;
    
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    
    @Column(name = "SENHA", nullable = false)
    private String senha;

    public Usuario() {
    }

    public Usuario(int id, String nome, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
