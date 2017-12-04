package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "numero_puestos")
    private Double numeroPuestos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_puestos_disponibles")
    private double numeroPuestosDisponibles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponible")
    private boolean disponible;
    @JoinColumn(name = "carros_id", referencedColumnName = "id")
    @ManyToOne
    private Carro carros;
    @JoinColumn(name = "parqueadero_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parqueadero parqueadero;

    public Puesto() {
    }

    public Puesto(Integer id) {
        this.id = id;
    }

    public Puesto(Integer id, double numeroPuestosDisponibles, boolean disponible) {
        this.id = id;
        this.numeroPuestosDisponibles = numeroPuestosDisponibles;
        this.disponible = disponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNumeroPuestos() {
        return numeroPuestos;
    }

    public void setNumeroPuestos(Double numeroPuestos) {
        this.numeroPuestos = numeroPuestos;
    }

    public double getNumeroPuestosDisponibles() {
        return numeroPuestosDisponibles;
    }

    public void setNumeroPuestosDisponibles(double numeroPuestosDisponibles) {
        this.numeroPuestosDisponibles = numeroPuestosDisponibles;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Carro getCarros() {
        return carros;
    }

    public void setCarros(Carro carros) {
        this.carros = carros;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Puesto[ id=" + id + " ]";
    }
    
}
