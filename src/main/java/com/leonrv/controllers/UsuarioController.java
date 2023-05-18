package com.leonrv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import com.leonrv.models.Usuario;
import com.leonrv.services.IUsuarioService;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {

        return ResponseEntity.ok(service.findAll(pageNo, pageSize, sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario updated) {
        return ResponseEntity.ok(service.save(updated));
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario created) {
        return ResponseEntity.ok(service.save(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Ok");
    }
}
