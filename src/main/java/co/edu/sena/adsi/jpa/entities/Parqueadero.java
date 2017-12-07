package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "parqueadero")
@XmlRootElement
public class Parqueadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarifa")
    private double tarifa;
    @Column(name = "caja")
    private double caja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abierto")
    private boolean abierto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puestos")
    private double puestos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parqueaderos")
    private List<Puesto> puestosList;

    public Parqueadero() {
    }

    public Parqueadero(Integer id) {
        this.id = id;
    }

    public Parqueadero(Integer id, double tarifa, boolean abierto, double puestos) {
        this.id = id;
        this.tarifa = tarifa;
        this.abierto = abierto;
        this.puestos = puestos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }

    public boolean getAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public double getPuestos() {
        return puestos;
    }

    public void setPuestos(double puestos) {
        this.puestos = puestos;
    }

    @XmlTransient
    public List<Puesto> getPuestosList() {
        return puestosList;
    }

    public void setPuestosList(List<Puesto> puestosList) {
        this.puestosList = puestosList;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Parqueadero[ id=" + id + " ]";
    }
    
}
