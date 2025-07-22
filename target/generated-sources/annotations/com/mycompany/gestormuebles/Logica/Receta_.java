package com.mycompany.gestormuebles.Logica;

import com.mycompany.gestormuebles.Logica.Proyecto;
import com.mycompany.gestormuebles.Logica.Receta_Material;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-07-21T22:44:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Receta.class)
public class Receta_ { 

    public static volatile ListAttribute<Receta, Receta_Material> listaMateriales;
    public static volatile SingularAttribute<Receta, String> nombreReceta;
    public static volatile SingularAttribute<Receta, String> DescripcionReceta;
    public static volatile ListAttribute<Receta, Proyecto> recetasProyecto;
    public static volatile SingularAttribute<Receta, Integer> idReceta;

}