package com.killer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class SaleDetail {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSaleDetail;

    @ManyToOne
    @JoinColumn(name = "xid_sale", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_SALE"))
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "xid_product", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_PRODUCT"))
    private Product product;

    @Column(nullable = false)
    private short quantity;

    @Column(nullable = false)
    private double salePrice;

    @Column(nullable = false)
    private double discount;
}
