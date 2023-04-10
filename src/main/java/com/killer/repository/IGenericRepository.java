package com.killer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean   //instruccion para no generar un bean
public interface IGenericRepository<T,ID> extends JpaRepository<T, ID>{

}
