package com.killer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Sale {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;

    @ManyToOne
    @JoinColumn(name = "xid_client", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_CLIENT"))
    private Client client;

    @ManyToOne
    @JoinColumn(name = "xid_user", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_USER"))
    private User user;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double total;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double tax;

    //esto significa que la cabecera de la venta va a tener varios detalles
    //se utiliza casacade para que cuando se elimine el padre, se eliminen tambien los hijos
    //para conservar la integridad de la data y que no haya informacion huerfana
    //SOLO CUANDO SE USA @OneToMany si o si va a tener una contraparte por lo que se usa
    //mappedBy que se enlaza con el atributo "sale" de la tabla SaleDetail
    // ↓↓↓↓↓ debe conservar el mismo nombre del atributo de su contraparte
    @OneToMany(mappedBy = "sale",cascade = CascadeType.ALL)
    private List<SaleDetail> details;

}
