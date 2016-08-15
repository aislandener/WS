package control;

import java.util.List;
import model.Usuario;
import util.HDA;

public class UsuarioDAO {
    
    private Usuario user;
    private HDA db;
    
    public UsuarioDAO(){
        db = new HDA();
    }
    
    public boolean insert(String nome, String telefone, String email, String senha){
        
        user = new Usuario();
        user.setNome(nome);
        user.setTelefone(telefone);
        user.setEmail(email);
        user.setSenha(senha);
        return db.inserir(user);
    }
    
    public List<Usuario> listUsers(String nome){
        return db.listUsuario(nome);
    }
    
    public Usuario login(String email, String senha){
        return db.login(email, senha);
    }
    
    public Usuario localizarUsuario(int id){
        return db.findUser(id);
    }
    
}
