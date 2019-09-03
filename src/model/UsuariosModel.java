/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Usuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author agda_larissa
 */
public class UsuariosModel {
    
    Session s;
    Transaction t;

    public UsuariosModel() {
    }
    
    public void inserir(Usuarios usuario){
        s = HibernateUtil.getSessionFactory().openSession();
         t = null;
        try {
            t = s.beginTransaction();
            s.save(usuario);
            t.commit();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw ex;

        } finally {
            s.close();
        }
    }
    
    public void atualizar(Usuarios usuario){
         s = HibernateUtil.getSessionFactory().openSession();
         t = null;
        try {
            t = s.beginTransaction();
            s.update(usuario);
            t.commit();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw ex;

        } finally {
            s.close();
        }
    }
    
    public void deletar(Usuarios usuario){
          s = HibernateUtil.getSessionFactory().openSession();
         t = null;
        try {
            t = s.beginTransaction();
            s.delete(usuario);
            t.commit();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw ex;

        } finally {
            s.close();
        }
    }
    
    public List<Usuarios> listar(){
        s = HibernateUtil.getSessionFactory().openSession();
        Query query = s.createQuery("from Usuarios");
        List<Usuarios> l = query.list();
        return l;        
    }
    
     public List buscarPorNome(String nome) {
        s = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = s.createCriteria(Usuarios.class);
        crit.add(Restrictions.eq("nome", nome));
        List results = crit.list();
        return results;
    }
    
}
