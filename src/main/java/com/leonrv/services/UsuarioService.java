package com.leonrv.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.leonrv.models.Usuario;
import com.leonrv.repositories.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{


    @Autowired
    private IUsuarioRepository repository;

   
    public List<Usuario> findAll(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Usuario> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Usuario>();
        }
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

    public Page<Usuario> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    
}
