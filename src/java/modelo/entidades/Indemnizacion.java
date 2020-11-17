/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BONIFACIO
 */
@Entity
@Table(name = "indemnizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indemnizacion.findAll", query = "SELECT i FROM Indemnizacion i")
    , @NamedQuery(name = "Indemnizacion.findByIdIndemnizacion", query = "SELECT i FROM Indemnizacion i WHERE i.idIndemnizacion = :idIndemnizacion")
    , @NamedQuery(name = "Indemnizacion.findByMontoIndemnizacion", query = "SELECT i FROM Indemnizacion i WHERE i.montoIndemnizacion = :montoIndemnizacion")})
public class Indemnizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_indemnizacion")
    private Integer idIndemnizacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_indemnizacion")
    private Double montoIndemnizacion;
    @JoinColumn(name = "dui", referencedColumnName = "dui")
    @ManyToOne
    private Empleado dui;

    public Indemnizacion() {
    }

    public Indemnizacion(Integer idIndemnizacion) {
        this.idIndemnizacion = idIndemnizacion;
    }

    public Integer getIdIndemnizacion() {
        return idIndemnizacion;
    }

    public void setIdIndemnizacion(Integer idIndemnizacion) {
        this.idIndemnizacion = idIndemnizacion;
    }

    public Double getMontoIndemnizacion() {
        return montoIndemnizacion;
    }

    public void setMontoIndemnizacion(Double montoIndemnizacion) {
        this.montoIndemnizacion = montoIndemnizacion;
    }

    public Empleado getDui() {
        return dui;
    }

    public void setDui(Empleado dui) {
        this.dui = dui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIndemnizacion != null ? idIndemnizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indemnizacion)) {
            return false;
        }
        Indemnizacion other = (Indemnizacion) object;
        if ((this.idIndemnizacion == null && other.idIndemnizacion != null) || (this.idIndemnizacion != null && !this.idIndemnizacion.equals(other.idIndemnizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Indemnizacion[ idIndemnizacion=" + idIndemnizacion + " ]";
    }
    
}
