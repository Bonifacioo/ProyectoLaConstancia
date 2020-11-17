/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Marcas;
import modelo.entidades.Presentacion;
import modelo.entidades.Producto;
import modelo.sesion.beans.MarcasFacade;
import modelo.sesion.beans.PresentacionFacade;
import modelo.sesion.beans.ProductoFacade;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author BONIFACIO
 */
@ManagedBean (name="prob")
@ViewScoped
public class ProductosBeans  implements Serializable{
    // Agregado para subir la imagen
    private UploadedFile file;
    @Inject//para cada paquete que ocupemos, nos sirve para poder insertar los datos
    private ProductoFacade productoF;
    private Producto producto;
    @Inject//para cada paquete que ocupemos, nos sirve para poder insertar los datos
    private MarcasFacade marcasF;
    private Marcas marca;
    @Inject//para cada paquete que ocupemos, nos sirve para poder insertar los datos
    private PresentacionFacade presentacionF;
    private Presentacion presentacion;
    private List<Marcas> lstMarcas;
    private List<Presentacion> lstPresentaciones;
    private List<Producto> lstProductos;
    
    @PostConstruct
    private void init(){
        presentacion = new Presentacion();
        marca = new Marcas();
        producto = new Producto();
        obtenerListaProductos();
        obtenerListaMarcas();
        obtenerListaPresentaciones();
    }
    
    private List<Marcas> obtenerListaMarcas(){
        return lstMarcas = marcasF.findAll();//obteniendo la lista de registros 
    }
    private List<Presentacion> obtenerListaPresentaciones(){
        return lstPresentaciones = presentacionF.findAll();//obteniendo la lista de registros 
    }
    private List<Producto> obtenerListaProductos(){
        return lstProductos = productoF.findAll();//obteniendo la lista de registros 
    }
    
    public String insertarProducto(){
        List<Producto> prodcts = obtenerListaProductos();
        Producto prod = null;
        if(prodcts.size()>0) prod = prodcts.get(prodcts.size()-1);
        int id=0;
        if(prod != null){
            id = prod.getIdProducto()+1;
            producto.setIdMarca(marca);
            producto.setIdPresentacion(presentacion);
            producto.setIdProducto(id);
            productoF.create(producto);
        }else{
            producto.setIdProducto(id);
            producto.setIdMarca(marca);
            producto.setIdPresentacion(presentacion);
            productoF.create(producto);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Producto Agregado"));
        return "TablaProductos.xhtml?faces-redirect=true";
    }
    
    public String modificarProducto(){
        producto.setIdPresentacion(presentacion);
        producto.setIdMarca(marca);
        productoF.edit(producto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Producto Modificado"));
        return "TablaProductos.xhtml?faces-redirect=true";
    }
    
    public String eliminarProducto(){
        productoF.remove(producto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Producto Eliminado"));
        return "TablaProductos.xhtml?faces-redirect=true";
    }
    
    // Mostrar imagen
    public void view() throws IOException {
        try {
            Producto a = productoF.find(producto.getIdProducto());
            byte[] arreglo = a.getImagen();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.getOutputStream().write(arreglo);
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERROR");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

//   Método para subir la imagen
    public void upLoad() {
        System.out.println("   ");
        producto.getImagen();
        if (this.file != null) {
            try {
                InputStream input = file.getInputstream();
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];

                for (int i = 0; (i = input.read(buffer)) > 0;) {
                    output.write(buffer, 0, i);
                }
                producto.setImagen(output.toByteArray());
            } catch (Exception e) {
            }
        }
    }
    
     // Métodos set y get de File (subir imagen)
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public ProductoFacade getProductoF() {
        return productoF;
    }

    public void setProductoF(ProductoFacade productoF) {
        this.productoF = productoF;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public void setMarca(Marcas marcas) {
        this.marca = marcas;
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

    public List<Marcas> getLstMarcas() {
        return lstMarcas;
    }

    public void setLstMarcas(List<Marcas> lstMarcas) {
        this.lstMarcas = lstMarcas;
    }

    public List<Presentacion> getLstPresentaciones() {
        return lstPresentaciones;
    }

    public void setLstPresentaciones(List<Presentacion> lstPresentaciones) {
        this.lstPresentaciones = lstPresentaciones;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProducto) {
        this.lstProductos = lstProducto;
    }
    
    
}
