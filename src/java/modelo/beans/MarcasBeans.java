/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.entidades.Marcas;
import modelo.sesion.beans.MarcasFacade;

/**
 *
 * @author BONIFACIO
 */
@ManagedBean (name="mb")
@ViewScoped
public class MarcasBeans implements Serializable{
    @Inject//para cada paquete que ocupemos, nos sirve para poder insertar los datos
    private MarcasFacade marcasF;
    private Marcas marca;
    private List<Marcas> lstMarcas;
    
    @PostConstruct
    public void init(){
        marca = new Marcas();
        obtenerMarcas();
    }
    
    public List<Marcas> obtenerMarcas(){
        return lstMarcas = marcasF.findAll();//obteniendo la lista de registros 
    }
    
    public String insertarMarca(){
        List<Marcas> marcs = obtenerMarcas();
        Marcas marc = null;
       if(marcs.size()>0) marc = marcs.get(marcs.size()-1);
        
        if(marc != null){
            int id = marc.getIdMarca()+1;
            marca.setIdMarca(id);
            marcasF.create(marca);
        }else{
            int id = 1;
            marca.setIdMarca(id);
            marcasF.create(marca);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Marca Agregada"));
        return "TablaMarcas.xhtml?faces-redirect=true";
    }
    
    public String modificarMarca(){
        marcasF.edit(marca);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Marca Modificada"));
        return "TablaMarcas.xhtml?faces-redirect=true";
    }
    
    public String eliminarMarca(){
        marcasF.remove(marca);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Marca Eliminada"));
        return "TablaMarcas.xhtml?faces-redirect=true";
    }

    public MarcasFacade getMarcasF() {
        return marcasF;
    }

    public void setMarcasF(MarcasFacade marcasF) {
        this.marcasF = marcasF;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public List<Marcas> getLstMarcas() {
        return lstMarcas;
    }

    public void setLstMarcas(List<Marcas> lstMarcas) {
        this.lstMarcas = lstMarcas;
    }

   
    
    
}
