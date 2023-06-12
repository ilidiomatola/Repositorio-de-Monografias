/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import modelo.entidade.Monografia;
import persistencia.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MonografiaDAO {

    public boolean cadastrarMonografia(Monografia monografia) {
    try {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = sessao.beginTransaction();
            sessao.save(monografia);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            sessao.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public List<Monografia> listarMonografias() {
        List<Monografia> monografias = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            monografias = new ArrayList();
            Query requisitar = sessao.createQuery("From Monografia");
            monografias = requisitar.list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monografias;
    }

    public Monografia buscarMonografia(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Monografia monografia = null;

        try {
            sessao.beginTransaction();
            monografia = (Monografia) sessao.get(Monografia.class, id);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monografia;
    }

    public boolean atualizarMonografia(Monografia monografia) {
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            sessao.update(monografia);
            sessao.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void excluirMonografia(int id) {
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            Monografia monografia = (Monografia) sessao.get(Monografia.class, id);
            if (monografia != null) {
                sessao.delete(monografia);
            }
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
