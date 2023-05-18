package com.leonrv.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.leonrv.models.Usuario;

public interface IUsuarioService {

    public Page<Usuario> getPage(Pageable pageable);

    public List<Usuario> findAll();

    public Usuario getById(Long id);

    public Usuario save(Usuario entity);

    public void delete(Long id);
    
}
