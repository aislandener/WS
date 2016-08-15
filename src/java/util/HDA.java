package util;

import java.util.Date;
import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class HDA {
    
    private static Session session;
    
    public boolean inserir(Object obj){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            session.close();
        return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }
    
    public boolean alterar(Object obj){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
            session.close();    
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }
    
    
    public List<Usuario> listUsuario(String nome){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        if(nome != null & !nome.isEmpty())
            criteria.add(Restrictions.like("nome", "%"+nome+"%"));
        List lista = criteria.list();
        session.close();
        return lista;
    }
    
    public Usuario login(String email, String senha){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        Usuario user = (Usuario) criteria.add(Restrictions.eq("email", email)).add(Restrictions.eq("senha", senha)).uniqueResult();
        if(user != null)
            return user;
        return null;
    }
    
    public Usuario findUser(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        Usuario user = (Usuario) criteria.add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return user;
    }
  
    public List<Livro> findBooks(String titulo){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Livro.class);
        if(titulo != null & !titulo.isEmpty()){
            criteria.add(Restrictions.like("titulo", "%"+titulo+"%"));
        }
        List books = criteria.list();
        session.close();
        return books;
    }

    public Livro findBook(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Livro.class);
        Livro book = (Livro) criteria.add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return book;
    }
    
    public Emprestimo findEmprestimo(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Emprestimo.class);
        Emprestimo emprestimo = (Emprestimo) criteria.add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return emprestimo;
    }
    
    public List<Emprestimo> listEmprestimo(int status){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Emprestimo.class);
        switch(status){
            case 1:{
                criteria.add(Restrictions.eq("status", false));
                break;
            }
            case 2:{
                criteria.add(Restrictions.eq("status", true));
                break;
            }
            default:{
                return null;
            }
        }
        List<Emprestimo> emprestimos = criteria.list();
        session.close();
        return !emprestimos.isEmpty() ? emprestimos : null;
    }

}
