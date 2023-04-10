package com.killer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Producto {
	
	@Id
	@EqualsAndHashCode.Include
	private Integer idProduct;
	
	@ManyToOne //(FK)
	@JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY"))
	private Category category;
	
	@Column(nullable = false, length = 50)
	private String name;

	@Column(columnDefinition = "decimal(6,2)", nullable = false)
	private double price;

	@Column(nullable = false, length = 150)
	private String description;
	
	@Column(nullable = false)
	private boolean enabled;

}
