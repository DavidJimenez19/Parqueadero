package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Puesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-08T12:06:24")
@StaticMetamodel(Parqueadero.class)
public class Parqueadero_ { 

    public static volatile SingularAttribute<Parqueadero, Double> tarifa;
    public static volatile SingularAttribute<Parqueadero, Double> puestos;
    public static volatile ListAttribute<Parqueadero, Puesto> puestosList;
    public static volatile SingularAttribute<Parqueadero, Integer> id;
    public static volatile SingularAttribute<Parqueadero, Double> caja;
    public static volatile SingularAttribute<Parqueadero, Boolean> abierto;

}