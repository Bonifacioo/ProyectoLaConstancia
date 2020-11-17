/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BONIFACIO
 */
@Entity
@Table(name = "presentacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presentacion.findAll", query = "SELECT p FROM Presentacion p")
    , @NamedQuery(name = "Presentacion.findByIdPresentacion", query = "SELECT p FROM Presentacion p WHERE p.idPresentacion = :idPresentacion")
    , @NamedQuery(name = "Presentacion.findByPresentacion", query = "SELECT p FROM Presentacion p WHERE p.presentacion = :presentacion")
    , @NamedQuery(name = "Presentacion.findByDescripcionPresentacion", query = "SELECT p FROM Presentacion p WHERE p.descripcionPresentacion = :descripcionPresentacion")})
public class Presentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_presentacion")
    private Integer idPresentacion;
    @Size(max = 20)
    @Column(name = "presentacion")
    private String presentacion;
    @Size(max = 25)
    @Column(name = "descripcion_presentacion")
    private String descripcionPresentacion;
    @OneToMany(mappedBy = "idPresentacion")
    private List<Producto> productoList;

    public Presentacion() {
    }

    public Presentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescripcionPresentacion() {
        return descripcionPresentacion;
    }

    public void setDescripcionPresentacion(String descripcionPresentacion) {
        this.descripcionPresentacion = descripcionPresentacion;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresentacion != null ? idPresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentacion)) {
            return false;
        }
        Presentacion other = (Presentacion) object;
        if ((this.idPresentacion == null && other.idPresentacion != null) || (this.idPresentacion != null && !this.idPresentacion.equals(other.idPresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Presentacion[ idPresentacion=" + idPresentacion + " ]";
    }
    
}
