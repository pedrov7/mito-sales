package com.killer.mapperConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//esta notacion permite crear un @Bean de una libreria creada por terceros
//y asi poderla usar como inyeccion de dependencias
//de esta manera se hace que spring use librerias de terceros
// @Configuration -> hace que el bean generado sea sobre el metodo ModelMapper, mas no
//sobre la clase
@Configuration
public class MapperConfig {

    //con esta notacion crea el Bean para poder hacer inyeccion de dependencias
    //en cualquier clase
    //se puede colocar @Bean a metodos que retornen una instancia
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper(); //<- por lo tanto esto retorna la instacia
    }
}
