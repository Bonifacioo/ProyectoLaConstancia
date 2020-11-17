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
@Table(name = "pedido_personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoPersonas.findAll", query = "SELECT p FROM PedidoPersonas p")
    , @NamedQuery(name = "PedidoPersonas.findByIdPedidoPersonas", query = "SELECT p FROM PedidoPersonas p WHERE p.idPedidoPersonas = :idPedidoPersonas")
    , @NamedQuery(name = "PedidoPersonas.findByNombrePersona", query = "SELECT p FROM PedidoPersonas p WHERE p.nombrePersona = :nombrePersona")
    , @NamedQuery(name = "PedidoPersonas.findByCorreoElectronico", query = "SELECT p FROM PedidoPersonas p WHERE p.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "PedidoPersonas.findByTelefono", query = "SELECT p FROM PedidoPersonas p WHERE p.telefono = :telefono")})
public class PedidoPersonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pedido_personas")
    private Integer idPedidoPersonas;
    @Size(max = 50)
    @Column(name = "nombre_persona")
    private String nombrePersona;
    @Size(max = 25)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Size(max = 9)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "idPedidoPersonas")
    private List<Pedidos> pedidosList;

    public PedidoPersonas() {
    }

    public PedidoPersonas(Integer idPedidoPersonas) {
        this.idPedidoPersonas = idPedidoPersonas;
    }

    public Integer getIdPedidoPersonas() {
        return idPedidoPersonas;
    }

    public void setIdPedidoPersonas(Integer idPedidoPersonas) {
        this.idPedidoPersonas = idPedidoPersonas;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Pedidos> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedidos> pedidosList) {
        this.pedidosList = pedidosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoPersonas != null ? idPedidoPersonas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoPersonas)) {
            return false;
        }
        PedidoPersonas other = (PedidoPersonas) object;
        if ((this.idPedidoPersonas == null && other.idPedidoPersonas != null) || (this.idPedidoPersonas != null && !this.idPedidoPersonas.equals(other.idPedidoPersonas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.PedidoPersonas[ idPedidoPersonas=" + idPedidoPersonas + " ]";
    }
    
}
