package Bean;

import DAOs.UsuarioDAO;
import Modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
    private String us;
    private String clave;
    private String nombre;

    public UserBean() {
    }
    
    public void agregarUsuario(){
        Usuario usuario = new Usuario(getUs(),getClave(),getNombre());
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        usuarioDAO.agregaUsuario(usuario);
    }
     
    public void actualizarUsuario(){
        Usuario p = new Usuario(getUs(),getClave(),getNombre());
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        usuarioDAO.actualizarUsuario(p);
    }

    
    public String getUs() {
        return us;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
