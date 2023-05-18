package com.leonrv.services;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.leonrv.models.Usuario;
import com.leonrv.repositories.IUsuarioRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class usuarioRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IUsuarioRepository repository;

    @Test
    public void encontrarTodosLosUsuarios() {
        Iterable usuarios = repository.findAll();
        assertThat(usuarios).isNotEmpty();
    }

    @Test
    public void guardarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Test");

        Usuario usuarioSaved = repository.save(usuario);

        assertThat(usuarioSaved).hasFieldOrPropertyWithValue("nombre", "Test");
    }

    @Test
    public void encontrarUsuarioPorId() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Test");

        entityManager.persist(usuario);

        Usuario foundUsuario = repository.findById(usuario.getId()).get();

        assertThat(foundUsuario).isEqualTo(usuario);
    }

    @Test
    public void eliminarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Test");

        entityManager.persist(usuario);

        repository.deleteById(usuario.getId());

        Iterable usuarios = repository.findAll();

        assertThat(usuarios).hasSize(1);
    }

}
