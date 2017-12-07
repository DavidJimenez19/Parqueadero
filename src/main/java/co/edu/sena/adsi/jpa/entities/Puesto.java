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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "puestos")
@XmlRootElement
public class Puesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "puesto_seleccionado")
    private Double puestoSeleccionado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponible")
    private boolean disponible;
    @JoinColumn(name = "parqueadero_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parqueadero parqueaderos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puestos")
    private List<Carro> carrosList;

    public Puesto() {
    }

    public Puesto(Integer id) {
        this.id = id;
    }

    public Puesto(Integer id, boolean disponible) {
        this.id = id;
        this.disponible = disponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPuestoSeleccionado() {
        return puestoSeleccionado;
    }

    public void setPuestoSeleccionado(Double puestoSeleccionado) {
        this.puestoSeleccionado = puestoSeleccionado;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public Parqueadero getParqueaderos() {
        return parqueaderos;
    }

    public void setParqueaderos(Parqueadero parqueaderos) {
        this.parqueaderos = parqueaderos;
    }

    @XmlTransient
    public List<Carro> getCarrosList() {
        return carrosList;
    }

    public void setCarrosList(List<Carro> carrosList) {
        this.carrosList = carrosList;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Puesto[ id=" + id + " ]";
    }
    
}
