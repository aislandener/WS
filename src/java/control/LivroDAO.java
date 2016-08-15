package control;

import java.util.List;
import model.Livro;
import util.HDA;

public class LivroDAO {
    
    private Livro book;
    private HDA db;
    
    public LivroDAO(){
        db = new HDA();
    }
    
    public boolean insert(String titulo, String autores, int edicao, String editora, String cidade, int ano, String descricao){
        book = new Livro();
        book.setTitulo(titulo);
        book.setAutores(autores);
        book.setEdicao(edicao);
        book.setEditora(editora);
        book.setCidade(cidade);
        book.setAno(ano);
        book.setDescricao(descricao);
        return db.inserir(book);
    }
    
    public boolean update(int id,String titulo, String autores, int edicao, String editora, String cidade, int ano, String descricao){
        book = new Livro();
        book.setId(id);
        book.setTitulo(titulo);
        book.setAutores(autores);
        book.setEdicao(edicao);
        book.setEditora(editora);
        book.setCidade(cidade);
        book.setAno(ano);
        book.setDescricao(descricao);
        return db.alterar(book);
    }
    
    public List<Livro> listBooks(String nome){
        return db.findBooks(nome);
    }

    public Livro localizarLivro(int livro) {
        return db.findBook(livro);
    }
    
}
