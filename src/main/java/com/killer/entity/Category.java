package com.killer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@EqualsAndHashCode.Include
//	private Integer idCategory;
//	
//	@Column(name = "name", nullable = false, length = 50)
//	private String name;
//	
//	@Column(nullable = false, length = 50)
//	private String description;
//	
//	@Column(nullable = false)
//	private boolean enable;
	
	private Integer idCategory;
	private String name;

}
