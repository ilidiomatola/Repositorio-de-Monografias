
package modelo.DAO;

import java.util.ArrayList;
import java.util.List;
import modelo.entidade.Areaconhecimento;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.HibernateUtil;


public class AreaConhecimentoDAO {
    public boolean cadastrarAreaconhecimento(Areaconhecimento areaConhecimento){ 
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.save(areaConhecimento);
            sessao.getTransaction().commit();
            sessao.flush();
            sessao.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public List<Areaconhecimento> listarAreaconhecimentos(){
            List<Areaconhecimento> listaAreaconhecimentos = null;
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                listaAreaconhecimentos = new ArrayList();
                Query requisitar = sessao.createQuery("From Areaconhecimento");
                listaAreaconhecimentos = requisitar.list();
                sessao.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listaAreaconhecimentos;
        }
        
    
        public Areaconhecimento  buscarAreaconhecimento(int id) {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            Areaconhecimento areaConhecimento = null;
            try {
                sessao.beginTransaction();
                areaConhecimento = (Areaconhecimento) sessao.get(Areaconhecimento.class,id);
                  sessao.getTransaction().commit();
              } catch (Exception e) {
                  e.printStackTrace();
              }
            return areaConhecimento;
        }
        
        public boolean atualizarAreaconhecimento(Areaconhecimento areaConhecimento) {
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                sessao.update(areaConhecimento);
                sessao.getTransaction().commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public void removerAreaconhecimento(int id) {
            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                Areaconhecimento areaConhecimento = (Areaconhecimento) sessao.get(Areaconhecimento.class, id);
                if (areaConhecimento != null) {
                    sessao.delete(areaConhecimento);
                }
                sessao.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
