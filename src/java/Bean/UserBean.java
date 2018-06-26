package Bean;

import DAOs.UsuarioDAO;
import Modelo.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;


@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
    private String us;
    private String clave;
    private String nombre;

    public UserBean() {
    }
    
    public void agregarUsuario() throws IOException{
        Usuario usuario = new Usuario(getUs(),getClave(),getNombre());
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        usuarioDAO.agregaUsuario(usuario);
        FacesContext.getCurrentInstance().getExternalContext().redirect("Administrar.xhtml");
    }
     
    public void actualizarUsuario(){
        Usuario p = new Usuario(getUs(),getClave(),getNombre());
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        usuarioDAO.actualizarUsuario(p);
    }
    
    public void buscarUsuario() throws IOException{
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        Usuario p = usuarioDAO.buscarUsuario(us,clave);
        if (p != null){
                this.clave = p.getClave();
                this.nombre = p.getNombre();
                this.us = p.getUs();
                FacesContext.getCurrentInstance().getExternalContext().redirect("Administrar.xhtml");
        }
        else{
                this.clave = null;
                this.nombre = null;
                this.us = null;
                FacesContext.getCurrentInstance().getExternalContext().redirect("Registrar.xhtml");
        }
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
