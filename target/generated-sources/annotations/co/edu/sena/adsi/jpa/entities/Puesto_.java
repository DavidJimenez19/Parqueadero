package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Parqueadero;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T09:40:37")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile SingularAttribute<Puesto, Double> numeroPuestosDisponibles;
    public static volatile SingularAttribute<Puesto, Parqueadero> parqueadero;
    public static volatile SingularAttribute<Puesto, Double> numeroPuestos;
    public static volatile SingularAttribute<Puesto, Integer> id;
    public static volatile SingularAttribute<Puesto, Carro> carros;
    public static volatile SingularAttribute<Puesto, Boolean> disponible;

}