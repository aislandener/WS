package control;

import java.util.Date;
import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import util.HDA;

public class EmprestimoDAO {
    
    private Emprestimo emprestimo;
    private HDA db;
    
    public EmprestimoDAO(){
        db = new HDA();
    }
    
    public boolean emprestarLivro(int usuario, int livro){
        Usuario user = new UsuarioDAO().localizarUsuario(usuario);
        Livro book = new LivroDAO().localizarLivro(livro);
        emprestimo = new Emprestimo();
        emprestimo.setUsuario(user);
        emprestimo.setLivro(book);
        emprestimo.setDataEmprestimo(new Date());
        emprestimo.setStatus(false);
        return db.inserir(emprestimo);
    }
    
    public boolean devolverLivro(int id){
        emprestimo = db.findEmprestimo(id);
        emprestimo.setDataDevolucao(new Date());
        emprestimo.setStatus(true);
        return db.alterar(emprestimo);
    }
    
    public List<Emprestimo> pesquisar(int status){
        return db.listEmprestimo(status);
    }
    
}
