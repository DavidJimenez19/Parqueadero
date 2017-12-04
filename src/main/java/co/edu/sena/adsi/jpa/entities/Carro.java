package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "carros")
@XmlRootElement
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_llegada")
    private double horaLlegada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "hora_salida")
    private Double horaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(mappedBy = "carros")
    private List<Puesto> puestosList;

    public Carro() {
    }

    public Carro(Integer id) {
        this.id = id;
    }

    public Carro(Integer id, String placa, double horaLlegada, boolean activo) {
        this.id = id;
        this.placa = placa;
        this.horaLlegada = horaLlegada;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(double horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Double getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Double horaSalida) {
        this.horaSalida = horaSalida;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        return "co.edu.sena.adsi.jpa.entities.Carro[ id=" + id + " ]";
    }
    
}
