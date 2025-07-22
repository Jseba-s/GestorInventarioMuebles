package com.mycompany.gestormuebles.Logica;

import com.mycompany.gestormuebles.Logica.Materiales;
import com.mycompany.gestormuebles.Logica.Receta;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-07-21T22:44:21", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Receta_Material.class)
public class Receta_Material_ { 

    public static volatile SingularAttribute<Receta_Material, Integer> idRecetaMaterial;
    public static volatile SingularAttribute<Receta_Material, Materiales> materialReceta;
    public static volatile SingularAttribute<Receta_Material, Double> cantidad;
    public static volatile SingularAttribute<Receta_Material, Receta> recetaMaterial;

}