package com.killer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Ingress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idIngress;

    @ManyToOne
    @JoinColumn(name = "xid_provider", nullable = false, foreignKey = @ForeignKey(name = "FK_INGRESS_PROVIDER"))
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "xid_user", nullable = false, foreignKey = @ForeignKey(name = "FK_INGRESS_USER"))
    private User user;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double total;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double tax;

    @Column(length = 10, nullable = false)
    private String serialNumber;

    @Column(    nullable = false)
    private boolean enabled;
}
