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
@Table(name = "detalle_viaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleViaje.findAll", query = "SELECT d FROM DetalleViaje d")
    , @NamedQuery(name = "DetalleViaje.findByIdDetalleViaje", query = "SELECT d FROM DetalleViaje d WHERE d.idDetalleViaje = :idDetalleViaje")})
public class DetalleViaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle_viaje")
    private Integer idDetalleViaje;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne
    private Pedidos idPedido;
    @JoinColumn(name = "id_viaje_realizado", referencedColumnName = "id_viaje_realizado")
    @ManyToOne
    private ViajesRealizados idViajeRealizado;

    public DetalleViaje() {
    }

    public DetalleViaje(Integer idDetalleViaje) {
        this.idDetalleViaje = idDetalleViaje;
    }

    public Integer getIdDetalleViaje() {
        return idDetalleViaje;
    }

    public void setIdDetalleViaje(Integer idDetalleViaje) {
        this.idDetalleViaje = idDetalleViaje;
    }

    public Pedidos getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedidos idPedido) {
        this.idPedido = idPedido;
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
        hash += (idDetalleViaje != null ? idDetalleViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleViaje)) {
            return false;
        }
        DetalleViaje other = (DetalleViaje) object;
        if ((this.idDetalleViaje == null && other.idDetalleViaje != null) || (this.idDetalleViaje != null && !this.idDetalleViaje.equals(other.idDetalleViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.DetalleViaje[ idDetalleViaje=" + idDetalleViaje + " ]";
    }
    
}
