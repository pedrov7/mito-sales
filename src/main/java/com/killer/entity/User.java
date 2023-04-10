package com.killer.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user_data")
public class User {

	@Id
	@EqualsAndHashCode.Include
	private Integer idUser;

	@Column(nullable = false, length = 50, unique = true)
	private String username;

	@Column(nullable = false, length = 60)
	private String password;

	@Column(nullable = false)
	private boolean enabled;

	// un rol puede pertecer a muchos usuarios
	// muchos usuarios pueden tener un rol, como tip en el mayor de los casos una FK es @ManytoOne
	// @JoinColumn(name = "xid_role", nullable = false) ← esta notacion indica que
	// se creara en la tabla User una
	// columna con este nombre y que a su vez hace el enlace con la
	// tabla Role, puede llevar cualquier nombre, tambien se le puede agragar un
	// alias con la notacion => foreignKey = @ForeignKey(name = "FK_USER_ROLE")
	//↧↧↧↧↧↧↧↧↧↧↧↧
	@ManyToOne
	@JoinColumn(name = "xid_role", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_ROLE"))
	private Role role;

	
}
