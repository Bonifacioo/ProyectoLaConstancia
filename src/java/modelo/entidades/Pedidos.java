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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BONIFACIO
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByIdPedido", query = "SELECT p FROM Pedidos p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedidos.findByFechaPedido", query = "SELECT p FROM Pedidos p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Pedidos.findByFechaEntrega", query = "SELECT p FROM Pedidos p WHERE p.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Pedidos.findByDireccionEntrega", query = "SELECT p FROM Pedidos p WHERE p.direccionEntrega = :direccionEntrega")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Size(max = 100)
    @Column(name = "direccion_entrega")
    private String direccionEntrega;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_categoria_clientes")
    @ManyToOne
    private CategoriaClientes idCliente;
    @JoinColumn(name = "id_pedido_personas", referencedColumnName = "id_pedido_personas")
    @ManyToOne
    private PedidoPersonas idPedidoPersonas;
    @JoinColumn(name = "id_zona", referencedColumnName = "id_zona")
    @ManyToOne
    private Zona idZona;
    @OneToMany(mappedBy = "idPedido")
    private List<DetallePedido> detallePedidoList;
    @OneToMany(mappedBy = "idPedido")
    private List<DetalleViaje> detalleViajeList;

    public Pedidos() {
    }

    public Pedidos(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public CategoriaClientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(CategoriaClientes idCliente) {
        this.idCliente = idCliente;
    }

    public PedidoPersonas getIdPedidoPersonas() {
        return idPedidoPersonas;
    }

    public void setIdPedidoPersonas(PedidoPersonas idPedidoPersonas) {
        this.idPedidoPersonas = idPedidoPersonas;
    }

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    @XmlTransient
    public List<DetallePedido> getDetallePedidoList() {
        return detallePedidoList;
    }

    public void setDetallePedidoList(List<DetallePedido> detallePedidoList) {
        this.detallePedidoList = detallePedidoList;
    }

    @XmlTransient
    public List<DetalleViaje> getDetalleViajeList() {
        return detalleViajeList;
    }

    public void setDetalleViajeList(List<DetalleViaje> detalleViajeList) {
        this.detalleViajeList = detalleViajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Pedidos[ idPedido=" + idPedido + " ]";
    }
    
}
