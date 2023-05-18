package com.leonrv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonrv.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
}
