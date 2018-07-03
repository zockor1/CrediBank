package Bean;

import DAOs.PostularDAO;
import Modelo.Comuna;
import Modelo.Postulacion;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Zockor
 */
@Named(value = "postularBean")
@SessionScoped
public class PostularBean implements Serializable {

    private String rut;
    private Comuna comuna = new Comuna();
    private String nombre;
    private String apppaterno;
    private String appmaterno;
    private Date fecnac = new Date();
    private Character sexo;
    private Character estadocivil;
    private Short hijos;
    private String telefono;
    private String email;
    private String direccion;
    private String educacion;
    private String renta;
    private Short sueldoLiquido;
    private Boolean enfermedad;
    private String estado;
    private Date inicio = new Date();
    private Date fin = new Date();

    //Habilitar/Desahibilitar ingreso de Hijos
    private boolean enabled;

    public void toggle() {
        enabled = !enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public PostularBean() {
    }

    public void agregarPostulacion() throws IOException {
        Postulacion postulacion = new Postulacion(getRut(), getComuna(), getNombre(), getApppaterno(), getAppmaterno(),
                getFecnac(), getSexo(), getEstadocivil(), getHijos(), getTelefono(), getEmail(), getDireccion(), getEducacion(),
                getRenta(), getSueldoLiquido(), getEnfermedad(), "Pendiente");
        PostularDAO postularDAO = new PostularDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if (postularDAO.agregaPostulacion(postulacion)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Postulacion ingresada con Exito!", null));
            //limpiarCampos();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una Postulacion del Cliente :" + postulacion.getRut(), null));
        }
    }

    public void actualizarPostulacion() throws IOException {
        Postulacion postulacion = new Postulacion(getRut(), getComuna(), getNombre(), getApppaterno(), getAppmaterno(),
                getFecnac(), getSexo(), getEstadocivil(), getHijos(), getTelefono(), getEmail(), getDireccion(), getEducacion(),
                 getRenta(), getSueldoLiquido(), getEnfermedad(), getEstado());
        PostularDAO postularDAO = new PostularDAO();
        postularDAO.actualizarPostulacion(postulacion);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ActualizarPostulacion.xhtml");
    }

    public void eliminarPostulacion() {
        Postulacion postulacion = new Postulacion(getRut());
        PostularDAO postularDAO = new PostularDAO();
        postularDAO.eliminarPostulacion(postulacion);
    }

    public void eliminarPostulacion2(String rut) {
        Postulacion postulacion = new Postulacion(rut);
        PostularDAO postularDAO = new PostularDAO();
        postularDAO.eliminarPostulacion(postulacion);
    }

    public void buscarPostulacion() {
        PostularDAO postularDAO = new PostularDAO();
        Postulacion p = postularDAO.buscarPostulacion(rut);
        if (p != null) {
            rut = p.getRut();
            comuna = p.getComuna();
            nombre = p.getNombre();
            apppaterno = p.getApppaterno();
            appmaterno = p.getAppmaterno();
            fecnac = p.getFecnac();
            sexo = p.getSexo();
            estadocivil = p.getEstadocivil();
            hijos = p.getHijos();
            telefono = p.getTelefono();
            email = p.getEmail();
            direccion = p.getDireccion();
            educacion = p.getEducacion();
            renta = p.getRenta();
            sueldoLiquido = p.getSueldoLiquido();
            enfermedad = p.getEnfermedad();
            estado = p.getEstado();
        } else {
            rut = "";
            nombre = "";
            apppaterno = "";
            appmaterno = "";
            fecnac = null;
            sexo = ' ';
            estadocivil = ' ';
            hijos = 0;
            telefono = "";
            email = "";
            direccion = "";
            educacion = "";
            renta = "";
            sueldoLiquido = null;
            enfermedad = false;
            estado = null;
        }
    }

    public void buscarPostulacion2(String rut1) throws IOException {
        PostularDAO postularDAO = new PostularDAO();
        Postulacion p = postularDAO.buscarPostulacion(rut1);
        if (p != null) {
            rut = p.getRut();
            comuna = p.getComuna();
            nombre = p.getNombre();
            apppaterno = p.getApppaterno();
            appmaterno = p.getAppmaterno();
            fecnac = p.getFecnac();
            sexo = p.getSexo();
            estadocivil = p.getEstadocivil();
            hijos = p.getHijos();
            telefono = p.getTelefono();
            email = p.getEmail();
            direccion = p.getDireccion();
            educacion = p.getEducacion();
            renta = p.getRenta();
            sueldoLiquido = p.getSueldoLiquido();
            enfermedad = p.getEnfermedad();
            estado = p.getEstado();
            FacesContext.getCurrentInstance().getExternalContext().redirect("ActualizarPostulacion.xhtml");
        } else {
            rut = "";
            nombre = "";
            apppaterno = "";
            appmaterno = "";
            fecnac = null;
            sexo = ' ';
            estadocivil = ' ';
            hijos = 0;
            telefono = "";
            email = "";
            direccion = "";
            educacion = "";
            renta = "";
            sueldoLiquido = null;
            enfermedad = false;
            estado = null;
        }
    }

    public void buscarPostulacion3(String rut1) throws IOException {
        PostularDAO postularDAO = new PostularDAO();
        Postulacion p = postularDAO.buscarPostulacion(rut1);
        if (p != null) {
            rut = p.getRut();
            comuna = p.getComuna();
            nombre = p.getNombre();
            apppaterno = p.getApppaterno();
            appmaterno = p.getAppmaterno();
            fecnac = p.getFecnac();
            sexo = p.getSexo();
            estadocivil = p.getEstadocivil();
            hijos = p.getHijos();
            telefono = p.getTelefono();
            email = p.getEmail();
            direccion = p.getDireccion();
            educacion = p.getEducacion();
            renta = p.getRenta();
            sueldoLiquido = p.getSueldoLiquido();
            enfermedad = p.getEnfermedad();
            estado = p.getEstado();
            FacesContext.getCurrentInstance().getExternalContext().redirect("DetallePostulacion.xhtml");
        } else {
            rut = "";
            nombre = "";
            apppaterno = "";
            appmaterno = "";
            fecnac = null;
            sexo = ' ';
            estadocivil = ' ';
            hijos = 0;
            telefono = "";
            email = "";
            direccion = "";
            educacion = "";
            renta = "";
            sueldoLiquido = null;
            enfermedad = false;
            estado = null;
        }
    }

    public void buscarPostulacion4(String rut1, String estado1, Date inicio, Date fin) throws IOException {
        PostularDAO postularDAO = new PostularDAO();
        Postulacion p = postularDAO.buscarPostulacionEjecutivo(rut1, estado1, getInicio(), getFin());
        if (p != null) {
            rut = p.getRut();
            comuna = p.getComuna();
            nombre = p.getNombre();
            apppaterno = p.getApppaterno();
            appmaterno = p.getAppmaterno();
            fecnac = p.getFecnac();
            sexo = p.getSexo();
            estadocivil = p.getEstadocivil();
            hijos = p.getHijos();
            telefono = p.getTelefono();
            email = p.getEmail();
            direccion = p.getDireccion();
            educacion = p.getEducacion();
            renta = p.getRenta();
            sueldoLiquido = p.getSueldoLiquido();
            enfermedad = p.getEnfermedad();
            estado = p.getEstado();
            FacesContext.getCurrentInstance().getExternalContext().redirect("DetallePostulacion.xhtml");
        } else {
            rut = "";
            nombre = "";
            apppaterno = "";
            appmaterno = "";
            fecnac = null;
            sexo = ' ';
            estadocivil = ' ';
            hijos = 0;
            telefono = "";
            email = "";
            direccion = "";
            educacion = "";
            renta = "";
            sueldoLiquido = null;
            enfermedad = false;
            estado = null;
        }
    }
    
    public void consultarEstado() {
        PostularDAO p = new PostularDAO();
        Postulacion ps = p.buscarPostulacion(getRut());
        FacesContext context = FacesContext.getCurrentInstance();
        switch (ps.getEstado()) {
            case "Pendiente":
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Postulacion Pendiente", null));
                break;
            case "Aprobado":
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Postulacion Aprobada", null));
                break;
            case "Rechazado":
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Postulacion Rechazada", null));
                break;    
            default:
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No existen registros", null));
                break;
        }
    }

    public List listaPostulaciones() {
        PostularDAO postularDAO = new PostularDAO();
        return postularDAO.listaPostulacion();
    }

    public List listaComuna() {
        PostularDAO postular = new PostularDAO();
        return postular.listaComunas();
    }

    public String getRut() {
        return rut;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApppaterno() {
        return apppaterno;
    }

    public String getAppmaterno() {
        return appmaterno;
    }

    public Date getFecnac() {
        return fecnac;
    }

    public Character getSexo() {
        return sexo;
    }

    public Character getEstadocivil() {
        return estadocivil;
    }

    public Short getHijos() {
        return hijos;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
    

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEducacion() {
        return educacion;
    }

    public String getRenta() {
        return renta;
    }

    public Short getSueldoLiquido() {
        return sueldoLiquido;
    }

    public Boolean getEnfermedad() {
        return enfermedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApppaterno(String apppaterno) {
        this.apppaterno = apppaterno;
    }

    public void setAppmaterno(String appmaterno) {
        this.appmaterno = appmaterno;
    }

    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public void setEstadocivil(Character estadocivil) {
        this.estadocivil = estadocivil;
    }

    public void setHijos(Short hijos) {
        this.hijos = hijos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public void setRenta(String renta) {
        this.renta = renta;
    }

    public void setSueldoLiquido(Short sueldoLiquido) {
        this.sueldoLiquido = sueldoLiquido;
    }

    public void setEnfermedad(Boolean enfermedad) {
        this.enfermedad = enfermedad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
