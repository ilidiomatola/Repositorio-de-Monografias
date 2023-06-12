
package modelo.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Curso;
import modelo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class CursoDAO{
    public boolean cadastrarCurso(Curso curso){ 
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.save(curso);
            sessao.getTransaction().commit();
            sessao.flush();
            sessao.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public List<Curso> listarCursos(){
            List<Curso> listaCursos = null;
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                listaCursos = new ArrayList();
                Query requisitar = sessao.createQuery("From Curso");
                listaCursos = requisitar.list();
                sessao.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listaCursos;
        }
        
    
        public Curso  buscarCurso(int id) {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            Curso curso = null;
            try {
                sessao.beginTransaction();
                curso = (Curso) sessao.get(Curso.class,id);
                  sessao.getTransaction().commit();
              } catch (Exception e) {
                  e.printStackTrace();
              }
            return curso;
        }
        
        public boolean atualizarCurso(Curso curso) {
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                sessao.update(curso);
                sessao.getTransaction().commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public void removerCurso(int id) {
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                Curso curso = (Curso) sessao.get(Curso.class, id);
                if (curso != null) {
                    sessao.delete(curso);
                }
                sessao.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
