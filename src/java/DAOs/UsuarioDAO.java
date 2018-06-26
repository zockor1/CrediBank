/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Modelo.Usuario;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Luis
 */
public class UsuarioDAO {
    public void agregaUsuario(Usuario usuario){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        sesion.save(usuario);
        sesion.getTransaction().commit();
        sesion.flush();
        sesion.close();
    }
    
            
    
    public void actualizarUsuario(Usuario usuario){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        sesion.update(usuario);
        sesion.getTransaction().commit();
        sesion.flush();
        sesion.close();
    }
    
    public void eliminarUsuario(Usuario usuario){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        sesion.delete(usuario);
        sesion.getTransaction().commit();
        sesion.flush();
        sesion.close();
    }

    public List listaUsuario(){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        Query q = sesion.createQuery("from Usuario");
        List usuario = q.list();        
        sesion.flush();
        sesion.close();
        return usuario;
    }    
    public Usuario buscarUsuario(String cod){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        Query q = sesion.createQuery("from Usuario where us="+cod);
        Usuario usuario = (Usuario) q.uniqueResult();
        sesion.flush();
        sesion.close();
        return usuario;
    }
    
    public Usuario buscarUsuario(String cod,String pass){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        Query q = sesion.createQuery("from Usuario where us="+cod+ "and clave = " + pass);
        Usuario usuario = (Usuario) q.uniqueResult();
        sesion.flush();
        sesion.close();
        return usuario;
    }
}
