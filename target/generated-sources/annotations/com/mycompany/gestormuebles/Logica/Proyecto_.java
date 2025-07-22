package com.mycompany.gestormuebles.Logica;

import com.mycompany.gestormuebles.Logica.Receta;
import com.mycompany.gestormuebles.Logica.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-07-21T22:44:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, Integer> idProyecto;
    public static volatile SingularAttribute<Proyecto, Boolean> estado;
    public static volatile SingularAttribute<Proyecto, Date> fechaInicio;
    public static volatile SingularAttribute<Proyecto, Receta> recetaUsada;
    public static volatile SingularAttribute<Proyecto, String> nombreProyecto;
    public static volatile SingularAttribute<Proyecto, Date> fechaterminada;
    public static volatile SingularAttribute<Proyecto, Usuario> usuario_Proyecto;

}