package com.killer.service.impl;

import java.util.List;

import com.killer.exception.ModelNotFoundException;
import com.killer.repository.IGenericRepository;
import com.killer.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {


    //↓↓↓ este metodo abstracto sirve para llamar al repositorio de cada entidad
    protected abstract IGenericRepository<T, ID> getRepository();

    @Override
    public T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not exist -> " + id));
        return getRepository().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not exist -> " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("Id not exist -> " + id));
        getRepository().deleteById(id);
    }

}
