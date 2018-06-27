package Modelo;
// Generated 24-06-2018 1:21:23 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Comuna generated by hbm2java
 */
public class Comuna  implements java.io.Serializable {


     private short idComuna;
     private String nomComuna;
     private Set postulacions = new HashSet(0);

    public Comuna() {
    }

	
    public Comuna(short idComuna, String nomComuna) {
        this.idComuna = idComuna;
        this.nomComuna = nomComuna;
    }
    public Comuna(short idComuna, String nomComuna, Set postulacions) {
       this.idComuna = idComuna;
       this.nomComuna = nomComuna;
       this.postulacions = postulacions;
    }
   
    public short getIdComuna() {
        return this.idComuna;
    }
    
    public void setIdComuna(short idComuna) {
        this.idComuna = idComuna;
    }
    public String getNomComuna() {
        return this.nomComuna;
    }
    
    public void setNomComuna(String nomComuna) {
        this.nomComuna = nomComuna;
    }
    public Set getPostulacions() {
        return this.postulacions;
    }
    
    public void setPostulacions(Set postulacions) {
        this.postulacions = postulacions;
    }





}


