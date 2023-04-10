package com.killer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Role {

	//↓↓↓ por el momento rol no va a autogenerar el ID
	@Id
	@EqualsAndHashCode.Include
	private Integer idRole;
	
	@Column(nullable = false, length = 20	)
	private String name;
	
	@Column(nullable = false)
	private boolean enabled;
}
