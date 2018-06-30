
package DAOs;

import Modelo.Postulacion;
import Util.HibernateUtil;
import static java.awt.SystemColor.window;
import java.sql.SQLException;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Zockor
 */
public class PostularDAO {
    
    public boolean agregaPostulacion(Postulacion postulacion) {
        try {

            Transaction tx = null;
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
            sesion.save(postulacion);
            sesion.getTransaction().commit();
            sesion.flush();
            sesion.close();
            return true;

        } catch (JDBCException ex) {
            return false;
        }
    }

               
    public void actualizarPostulacion(Postulacion postulacion){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        sesion.update(postulacion);
        sesion.getTransaction().commit();
        sesion.flush();
        sesion.close();
    }
    
    public void eliminarPostulacion(Postulacion postulacion){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        sesion.delete(postulacion);
        sesion.getTransaction().commit();
        sesion.flush();
        sesion.close();
    }

    public List listaPostulacion(){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        Query q = sesion.createQuery("from Postulacion");
        List postulaciones = q.list();        
        sesion.flush();
        sesion.close();
        return postulaciones;
    }    
    public Postulacion buscarPostulacion(String rut){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        Query q = sesion.createQuery("from Postulacion where rut="+rut);
        Postulacion postulacion = (Postulacion) q.uniqueResult();
        sesion.flush();
        sesion.close();
        return postulacion;
    }
    
     public List listaComunas(){
        Transaction tx=null;
        Session sesion=HibernateUtil.getSessionFactory().openSession();
        tx=sesion.beginTransaction();
        Query q = sesion.createQuery("from Comuna");
        List comunas = q.list();        
        sesion.flush();
        sesion.close();
        return comunas;
    }    
}
