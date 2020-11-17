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
@Table(name = "categoria_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaClientes.findAll", query = "SELECT c FROM CategoriaClientes c")
    , @NamedQuery(name = "CategoriaClientes.findByIdCategoriaClientes", query = "SELECT c FROM CategoriaClientes c WHERE c.idCategoriaClientes = :idCategoriaClientes")
    , @NamedQuery(name = "CategoriaClientes.findByCategoria", query = "SELECT c FROM CategoriaClientes c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "CategoriaClientes.findByNombreCliente", query = "SELECT c FROM CategoriaClientes c WHERE c.nombreCliente = :nombreCliente")})
public class CategoriaClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria_clientes")
    private Integer idCategoriaClientes;
    @Size(max = 12)
    @Column(name = "categoria")
    private String categoria;
    @Size(max = 50)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @OneToMany(mappedBy = "idCliente")
    private List<Pedidos> pedidosList;

    public CategoriaClientes() {
    }

    public CategoriaClientes(Integer idCategoriaClientes) {
        this.idCategoriaClientes = idCategoriaClientes;
    }

    public Integer getIdCategoriaClientes() {
        return idCategoriaClientes;
    }

    public void setIdCategoriaClientes(Integer idCategoriaClientes) {
        this.idCategoriaClientes = idCategoriaClientes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
        hash += (idCategoriaClientes != null ? idCategoriaClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaClientes)) {
            return false;
        }
        CategoriaClientes other = (CategoriaClientes) object;
        if ((this.idCategoriaClientes == null && other.idCategoriaClientes != null) || (this.idCategoriaClientes != null && !this.idCategoriaClientes.equals(other.idCategoriaClientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.CategoriaClientes[ idCategoriaClientes=" + idCategoriaClientes + " ]";
    }
    
}
