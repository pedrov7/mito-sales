package com.killer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@IdClass(IngressDetailPK.class)  //esta notacion hace el enlace con otra clase donde contiene la informacion de las llaves primarias
public class IngressDetail {

    //estas dos llaves primarias compuestas(ingress, product) estan definidas en la clase IngressDetailPK
    @Id
    private Ingress ingress;

    @Id
    private Product product;

    @Column(nullable = false)
    private short quantity;

    @Column(columnDefinition = "decimal(6,2)" ,nullable = false)
    private double cost;
}
