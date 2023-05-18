package com.leonrv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.leonrv.models.Usuario;
import com.leonrv.repositories.IUsuarioRepository;

public class UsuarioService implements IUsuarioService{


    @Autowired
    private IUsuarioRepository repository;

   
    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario getById(Long id){
        return repository.findById(id).orElseThrow(null);
    }

    public Usuario save(Usuario entity){
        return repository.save(entity);
    }

    public void delete(Long id){
        if(getById(id)!=null){
            repository.deleteById(id);
        }
    }

    @Override
    public Page<Usuario> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
