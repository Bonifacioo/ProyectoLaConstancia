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
@Table(name = "camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c")
    , @NamedQuery(name = "Camion.findByNumeroPlaca", query = "SELECT c FROM Camion c WHERE c.numeroPlaca = :numeroPlaca")
    , @NamedQuery(name = "Camion.findByModelo", query = "SELECT c FROM Camion c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Camion.findByCapacidad", query = "SELECT c FROM Camion c WHERE c.capacidad = :capacidad")
    , @NamedQuery(name = "Camion.findByAnio", query = "SELECT c FROM Camion c WHERE c.anio = :anio")
    , @NamedQuery(name = "Camion.findByMarca", query = "SELECT c FROM Camion c WHERE c.marca = :marca")
    , @NamedQuery(name = "Camion.findByDisponible", query = "SELECT c FROM Camion c WHERE c.disponible = :disponible")})
public class Camion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "numero_placa")
    private String numeroPlaca;
    @Size(max = 25)
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Column(name = "anio")
    private Integer anio;
    @Size(max = 25)
    @Column(name = "marca")
    private String marca;
    @Column(name = "disponible")
    private Boolean disponible;
    @OneToMany(mappedBy = "placaIdCamion")
    private List<ViajesRealizados> viajesRealizadosList;

    public Camion() {
    }

    public Camion(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @XmlTransient
    public List<ViajesRealizados> getViajesRealizadosList() {
        return viajesRealizadosList;
    }

    public void setViajesRealizadosList(List<ViajesRealizados> viajesRealizadosList) {
        this.viajesRealizadosList = viajesRealizadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPlaca != null ? numeroPlaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.numeroPlaca == null && other.numeroPlaca != null) || (this.numeroPlaca != null && !this.numeroPlaca.equals(other.numeroPlaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Camion[ numeroPlaca=" + numeroPlaca + " ]";
    }
    
}
