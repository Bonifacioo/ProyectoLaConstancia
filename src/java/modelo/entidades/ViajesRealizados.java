/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BONIFACIO
 */
@Entity
@Table(name = "viajes_realizados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViajesRealizados.findAll", query = "SELECT v FROM ViajesRealizados v")
    , @NamedQuery(name = "ViajesRealizados.findByIdViajeRealizado", query = "SELECT v FROM ViajesRealizados v WHERE v.idViajeRealizado = :idViajeRealizado")
    , @NamedQuery(name = "ViajesRealizados.findByFechaViaje", query = "SELECT v FROM ViajesRealizados v WHERE v.fechaViaje = :fechaViaje")})
public class ViajesRealizados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_viaje_realizado")
    private Integer idViajeRealizado;
    @Column(name = "fecha_viaje")
    @Temporal(TemporalType.DATE)
    private Date fechaViaje;
    @JoinColumn(name = "placa_id_camion", referencedColumnName = "numero_placa")
    @ManyToOne
    private Camion placaIdCamion;
    @JoinColumn(name = "id_motorista_empleado", referencedColumnName = "dui")
    @ManyToOne
    private Empleado idMotoristaEmpleado;
    @JoinColumn(name = "id_repartidor_empleado", referencedColumnName = "dui")
    @ManyToOne
    private Empleado idRepartidorEmpleado;
    @OneToMany(mappedBy = "idViajeRealizado")
    private List<DetalleViaje> detalleViajeList;
    @OneToMany(mappedBy = "idViajeRealizado")
    private List<PerdidaGarrafones> perdidaGarrafonesList;

    public ViajesRealizados() {
    }

    public ViajesRealizados(Integer idViajeRealizado) {
        this.idViajeRealizado = idViajeRealizado;
    }

    public Integer getIdViajeRealizado() {
        return idViajeRealizado;
    }

    public void setIdViajeRealizado(Integer idViajeRealizado) {
        this.idViajeRealizado = idViajeRealizado;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public Camion getPlacaIdCamion() {
        return placaIdCamion;
    }

    public void setPlacaIdCamion(Camion placaIdCamion) {
        this.placaIdCamion = placaIdCamion;
    }

    public Empleado getIdMotoristaEmpleado() {
        return idMotoristaEmpleado;
    }

    public void setIdMotoristaEmpleado(Empleado idMotoristaEmpleado) {
        this.idMotoristaEmpleado = idMotoristaEmpleado;
    }

    public Empleado getIdRepartidorEmpleado() {
        return idRepartidorEmpleado;
    }

    public void setIdRepartidorEmpleado(Empleado idRepartidorEmpleado) {
        this.idRepartidorEmpleado = idRepartidorEmpleado;
    }

    @XmlTransient
    public List<DetalleViaje> getDetalleViajeList() {
        return detalleViajeList;
    }

    public void setDetalleViajeList(List<DetalleViaje> detalleViajeList) {
        this.detalleViajeList = detalleViajeList;
    }

    @XmlTransient
    public List<PerdidaGarrafones> getPerdidaGarrafonesList() {
        return perdidaGarrafonesList;
    }

    public void setPerdidaGarrafonesList(List<PerdidaGarrafones> perdidaGarrafonesList) {
        this.perdidaGarrafonesList = perdidaGarrafonesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViajeRealizado != null ? idViajeRealizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViajesRealizados)) {
            return false;
        }
        ViajesRealizados other = (ViajesRealizados) object;
        if ((this.idViajeRealizado == null && other.idViajeRealizado != null) || (this.idViajeRealizado != null && !this.idViajeRealizado.equals(other.idViajeRealizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.ViajesRealizados[ idViajeRealizado=" + idViajeRealizado + " ]";
    }
    
}
