/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BONIFACIO
 */
@Entity
@Table(name = "perdida_garrafones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerdidaGarrafones.findAll", query = "SELECT p FROM PerdidaGarrafones p")
    , @NamedQuery(name = "PerdidaGarrafones.findByIdPerdida", query = "SELECT p FROM PerdidaGarrafones p WHERE p.idPerdida = :idPerdida")
    , @NamedQuery(name = "PerdidaGarrafones.findByFechaRegistro", query = "SELECT p FROM PerdidaGarrafones p WHERE p.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "PerdidaGarrafones.findByCantidadPerdida", query = "SELECT p FROM PerdidaGarrafones p WHERE p.cantidadPerdida = :cantidadPerdida")})
public class PerdidaGarrafones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_perdida")
    private Integer idPerdida;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "cantidad_perdida")
    private Integer cantidadPerdida;
    @JoinColumn(name = "id_viaje_realizado", referencedColumnName = "id_viaje_realizado")
    @ManyToOne
    private ViajesRealizados idViajeRealizado;

    public PerdidaGarrafones() {
    }

    public PerdidaGarrafones(Integer idPerdida) {
        this.idPerdida = idPerdida;
    }

    public Integer getIdPerdida() {
        return idPerdida;
    }

    public void setIdPerdida(Integer idPerdida) {
        this.idPerdida = idPerdida;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getCantidadPerdida() {
        return cantidadPerdida;
    }

    public void setCantidadPerdida(Integer cantidadPerdida) {
        this.cantidadPerdida = cantidadPerdida;
    }

    public ViajesRealizados getIdViajeRealizado() {
        return idViajeRealizado;
    }

    public void setIdViajeRealizado(ViajesRealizados idViajeRealizado) {
        this.idViajeRealizado = idViajeRealizado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerdida != null ? idPerdida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerdidaGarrafones)) {
            return false;
        }
        PerdidaGarrafones other = (PerdidaGarrafones) object;
        if ((this.idPerdida == null && other.idPerdida != null) || (this.idPerdida != null && !this.idPerdida.equals(other.idPerdida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.PerdidaGarrafones[ idPerdida=" + idPerdida + " ]";
    }
    
}
