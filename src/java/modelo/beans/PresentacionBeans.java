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
import modelo.entidades.Presentacion;
import modelo.sesion.beans.PresentacionFacade;

/**
 *
 * @author BONIFACIO
 */
@ManagedBean (name="pb")
@ViewScoped
public class PresentacionBeans  implements Serializable {
    @Inject//para cada paquete que ocupemos, nos sirve para poder insertar los datos
    private PresentacionFacade presentacionF;
    private Presentacion presentacion;
    private List<Presentacion> lstPresentaciones;
    
    @PostConstruct
    public void init(){
        presentacion = new Presentacion();
        obtenerPresentaciones();
    }
    
    public List<Presentacion> obtenerPresentaciones(){
        return lstPresentaciones = presentacionF.findAll();//obteniendo la lista de registros 
    }
    
    public String insertarPresentacion(){
        List<Presentacion> presents = obtenerPresentaciones();
        Presentacion pre = null;
        if(presents.size()>0) pre = presents.get(presents.size()-1);
        
        if(pre != null){
            int id = pre.getIdPresentacion()+1;
            presentacion.setIdPresentacion(id);
            presentacionF.create(presentacion);
        }else{
            presentacion.setIdPresentacion(1);
            presentacionF.create(presentacion);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Presentación Agregada"));
        return "TablaPresentaciones.xhtml?faces-redirect=true";
    }
    
    public String modificarPresentacion(){
        presentacionF.edit(presentacion);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Presentación Modificada"));
        return "TablaPresentaciones.xhtml?faces-redirect=true";
    }
    
    public String eliminarPresentacion(){
        presentacionF.remove(presentacion);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Presentación Eliminada"));
        return "TablaPresentaciones.xhtml?faces-redirect=true";
    }

    public PresentacionFacade getPresentacionF() {
        return presentacionF;
    }

    public void setPresentacionF(PresentacionFacade presentacionF) {
        this.presentacionF = presentacionF;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public List<Presentacion> getLstPresentaciones() {
        return lstPresentaciones;
    }

    public void setLstPresentaciones(List<Presentacion> lstPresentaciones) {
        this.lstPresentaciones = lstPresentaciones;
    }

    
}
