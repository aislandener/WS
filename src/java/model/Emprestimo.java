package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPRESTIMO")
public class Emprestimo implements Serializable{
    
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    //@Column(name = "id_livro", nullable = false)
    @ManyToOne(targetEntity = Livro.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_LIVRO")
    private Livro livro;
    
    //@Column(name = "id_usuario",nullable = false)
    @ManyToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @Column(name = "DATA_EMPRESTIMO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    
    @Column(name = "DATA_DEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    
    @Column(name = "STATUS", nullable = false)
    private boolean status;

    public Emprestimo() {
    }

    public Emprestimo(int id, Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucao, boolean status) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
