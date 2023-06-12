
package modelo.DAO;

import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.HibernateUtil;


public class UsuarioDAO {
    public boolean cadastrarUsuario(Usuario usuario){ 
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.save(usuario);
            sessao.getTransaction().commit();
            sessao.flush();
            sessao.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public List<Usuario> listarUsuarios(){
            List<Usuario> listaUsuarios = null;
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                listaUsuarios = new ArrayList();
                Query requisitar = sessao.createQuery("From Usuario");
                listaUsuarios = requisitar.list();
                sessao.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listaUsuarios;
        }
        
    
        public Usuario  buscarUsuario(int id) {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            Usuario usuario = null;
            try {
                sessao.beginTransaction();
                usuario = (Usuario) sessao.get(Usuario.class,id);
                  sessao.getTransaction().commit();
              } catch (Exception e) {
                  e.printStackTrace();
              }
            return usuario;
        }
        
        public boolean atualizarUsuario(Usuario usuario) {
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                sessao.update(usuario);
                sessao.getTransaction().commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public void removerUsuario(int id) {
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                Usuario usuario = (Usuario) sessao.get(Usuario.class, id);
                if (usuario != null) {
                    sessao.delete(usuario);
                }
                sessao.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
