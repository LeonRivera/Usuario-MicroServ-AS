package com.leonrv.repositories;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.leonrv.models.Usuario;

public interface IUsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
}
