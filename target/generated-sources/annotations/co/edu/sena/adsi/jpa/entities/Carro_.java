package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Puesto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T09:40:37")
@StaticMetamodel(Carro.class)
public class Carro_ { 

    public static volatile SingularAttribute<Carro, Double> horaLlegada;
    public static volatile ListAttribute<Carro, Puesto> puestosList;
    public static volatile SingularAttribute<Carro, Integer> id;
    public static volatile SingularAttribute<Carro, Double> horaSalida;
    public static volatile SingularAttribute<Carro, String> placa;
    public static volatile SingularAttribute<Carro, Boolean> activo;

}