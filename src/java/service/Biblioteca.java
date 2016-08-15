package service;

import control.EmprestimoDAO;
import control.LivroDAO;
import control.UsuarioDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

@WebService(serviceName = "Biblioteca")
public class Biblioteca {

//    @WebMethod(operationName = "hello")
//    public String hello() {
//        return "Hello";
//    }

    //<editor-fold desc="Usuario">
    /**
     * A operação "inserirUsuario" é passado os parametros
     * @param nome
     * @param telefone
     * @param email
     * @param senha
     * @return 
     */
    @WebMethod(operationName = "inserirUsuario")
    public String inserirUsuario(@WebParam(name = "nome") String nome,
            @WebParam(name = "telefone") String telefone,
            @WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha
    ) {
        if (new UsuarioDAO().insert(nome, telefone, email, senha)) {
            return "success";
        }
        return "fail";
    }

    @WebMethod(operationName = "listarUsuario")
    public List<Usuario> listarUsuario(@WebParam(name = "nome") String nome) {
        return new UsuarioDAO().listUsers(nome);
    }

    @WebMethod(operationName = "login")
    public Usuario login(@WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha) {
        return new UsuarioDAO().login(email, senha);
    }
    
    @WebMethod(operationName = "buscaUsuario")
    public Usuario buscaUsuario(@WebParam(name = "id") int id) {
        return new UsuarioDAO().localizarUsuario(id);
    }
    //</editor-fold>

    //<editor-fold desc="Livro">
    @WebMethod(operationName = "inserirLivro")
    public String inserirLivro(
            @WebParam(name = "titulo") String titulo,
            @WebParam(name = "autores") String autores,
            @WebParam(name = "edicao") int edicao,
            @WebParam(name = "editora") String editora,
            @WebParam(name = "cidade") String cidade,
            @WebParam(name = "ano") int ano,
            @WebParam(name = "descricao") String descricao
    ) {
        if (new LivroDAO().insert(titulo, autores, edicao, editora, cidade, ano,descricao)) {
            return "success";
        }
        return "fail";
    }

    @WebMethod(operationName = "alterarLivro")
    public String alterarLivro(
            @WebParam(name = "id") int id,
            @WebParam(name = "titulo") String titulo,
            @WebParam(name = "autores") String autores,
            @WebParam(name = "edicao") int edicao,
            @WebParam(name = "editora") String editora,
            @WebParam(name = "cidade") String cidade,
            @WebParam(name = "ano") int ano,
            @WebParam(name = "descricao") String descricao
            
    ) {
        if (new LivroDAO().update(id, titulo, autores, edicao, editora, cidade, ano,descricao)) {
            return "success";
        }
        return "fail";
    }
    
    @WebMethod(operationName = "pesquisarLivro")
    public Livro pesquisarLivro(
            @WebParam(name = "id_livro") int id
    ) {
        return new LivroDAO().localizarLivro(id);
    }

    /**
     * Essa operação é de consulta a base de dados<br />
     * O parametro"<b>
     *
     * @param nome
     * </b>"é passado quando quer retorna com algum titulo<br />
     * Porem caso queira passar o parametro como vazio ou nulo, retornara com
     * todos os livros
     * @return
     */
    @WebMethod(operationName = "pesquisarLivros")
    public List<Livro> pesquisarLivros(@WebParam(name = "nome_livro") String nome) {
        return new LivroDAO().listBooks(nome);
    }

    //</editor-fold>
    
    //<editor-fold desc="Emprestimo">
    @WebMethod(operationName = "emprestar")
    public String emprestar(
            @WebParam(name = "id_livro") int id_livro,
            @WebParam(name = "id_usuario") int id_usuario) {
        if (new EmprestimoDAO().emprestarLivro(id_usuario, id_livro)) {
            return "success";
        }
        return "fail";
    }

    @WebMethod(operationName = "devolver")
    public String devolver(@WebParam(name = "id") int id) {
        if (new EmprestimoDAO().devolverLivro(id)) {
            return "success";
        }
        return "fail";

    }

    @WebMethod(operationName = "pesquisarEmprestados")
    public List<Emprestimo> pesquisarEmprestados() {
        return new EmprestimoDAO().pesquisar(1);
    }

    @WebMethod(operationName = "pesquisarDevolvidos")
    public List<Emprestimo> pesquisarDevolvidos() {
        return new EmprestimoDAO().pesquisar(2);
    }

    //</editor-fold>
}
