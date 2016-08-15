package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LIVRO")
public class Livro implements Serializable{
    
    @Id
    @Column(name = "ID_LIVRO",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "TITULO",nullable = false)
    private String titulo;
    
    @Column(name = "AUTORES",nullable = false)
    private String autores;
    
    @Column(name = "EDICAO")
    private int edicao;
    
    @Column(name = "EDITORA",nullable = false)
    private String editora;
    
    @Column(name = "CIDADE")
    private String cidade;
    
    @Column(name = "ANO",nullable = false)
    private int ano;
    
    @Column(name = "DESCRICAO",length = 100000)
    private String descricao;

    public Livro() {
    }

    public Livro(int id, String titulo, String autores, int edicao, String editora, String cidade, int ano, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.edicao = edicao;
        this.editora = editora;
        this.cidade = cidade;
        this.ano = ano;
        this.descricao = descricao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
