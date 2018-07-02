/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAOs.ComunaDAO;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Luis
 */
@Named(value = "comunaBean")
@SessionScoped
public class ComunaBean implements Serializable{
     public List listaComunas(){
        ComunaDAO comunaDAO=new ComunaDAO();
        return comunaDAO.listaComunas();
    }
}
