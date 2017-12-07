package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Parqueadero;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T16:12:48")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile ListAttribute<Puesto, Carro> carrosList;
    public static volatile SingularAttribute<Puesto, Double> puestoSeleccionado;
    public static volatile SingularAttribute<Puesto, Integer> id;
    public static volatile SingularAttribute<Puesto, Parqueadero> parqueaderos;
    public static volatile SingularAttribute<Puesto, Boolean> disponible;

}