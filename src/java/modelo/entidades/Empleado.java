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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByDui", query = "SELECT e FROM Empleado e WHERE e.dui = :dui")
    , @NamedQuery(name = "Empleado.findByNit", query = "SELECT e FROM Empleado e WHERE e.nit = :nit")
    , @NamedQuery(name = "Empleado.findByNup", query = "SELECT e FROM Empleado e WHERE e.nup = :nup")
    , @NamedQuery(name = "Empleado.findByAfp", query = "SELECT e FROM Empleado e WHERE e.afp = :afp")
    , @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Empleado.findByFechaNacimiento", query = "SELECT e FROM Empleado e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Empleado.findByFechaContrato", query = "SELECT e FROM Empleado e WHERE e.fechaContrato = :fechaContrato")
    , @NamedQuery(name = "Empleado.findByTipoContrato", query = "SELECT e FROM Empleado e WHERE e.tipoContrato = :tipoContrato")
    , @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Empleado.findByActivo", query = "SELECT e FROM Empleado e WHERE e.activo = :activo")
    , @NamedQuery(name = "Empleado.findByFechaDespido", query = "SELECT e FROM Empleado e WHERE e.fechaDespido = :fechaDespido")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dui")
    private String dui;
    @Size(max = 17)
    @Column(name = "nit")
    private String nit;
    @Column(name = "nup")
    private Integer nup;
    @Size(max = 6)
    @Column(name = "afp")
    private String afp;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_contrato")
    @Temporal(TemporalType.DATE)
    private Date fechaContrato;
    @Size(max = 10)
    @Column(name = "tipo_contrato")
    private String tipoContrato;
    @Size(max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_despido")
    @Temporal(TemporalType.DATE)
    private Date fechaDespido;
    @OneToMany(mappedBy = "idMotoristaEmpleado")
    private List<ViajesRealizados> viajesRealizadosList;
    @OneToMany(mappedBy = "idRepartidorEmpleado")
    private List<ViajesRealizados> viajesRealizadosList1;
    @OneToMany(mappedBy = "dui")
    private List<Indemnizacion> indemnizacionList;
    @OneToMany(mappedBy = "empleado")
    private List<Login> loginList;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne
    private Area idArea;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne
    private Cargo idCargo;

    public Empleado() {
    }

    public Empleado(String dui) {
        this.dui = dui;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getNup() {
        return nup;
    }

    public void setNup(Integer nup) {
        this.nup = nup;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaDespido() {
        return fechaDespido;
    }

    public void setFechaDespido(Date fechaDespido) {
        this.fechaDespido = fechaDespido;
    }

    @XmlTransient
    public List<ViajesRealizados> getViajesRealizadosList() {
        return viajesRealizadosList;
    }

    public void setViajesRealizadosList(List<ViajesRealizados> viajesRealizadosList) {
        this.viajesRealizadosList = viajesRealizadosList;
    }

    @XmlTransient
    public List<ViajesRealizados> getViajesRealizadosList1() {
        return viajesRealizadosList1;
    }

    public void setViajesRealizadosList1(List<ViajesRealizados> viajesRealizadosList1) {
        this.viajesRealizadosList1 = viajesRealizadosList1;
    }

    @XmlTransient
    public List<Indemnizacion> getIndemnizacionList() {
        return indemnizacionList;
    }

    public void setIndemnizacionList(List<Indemnizacion> indemnizacionList) {
        this.indemnizacionList = indemnizacionList;
    }

    @XmlTransient
    public List<Login> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<Login> loginList) {
        this.loginList = loginList;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dui != null ? dui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Empleado[ dui=" + dui + " ]";
    }
    
}
