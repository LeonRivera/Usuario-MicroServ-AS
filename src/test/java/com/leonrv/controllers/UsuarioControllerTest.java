package com.leonrv.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonrv.models.Usuario;
import com.leonrv.services.IUsuarioService;


import static org.assertj.core.api.Assertions.assertThat;




import org.springframework.http.HttpStatus;






@WebMvcTest(value = UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IUsuarioService usuarioService;

    @Test
    void createUsuario() throws Exception{

        Usuario usuario = new Usuario();
        usuario.setId(2L);
        usuario.setNombre("asdfs");
        usuario.setApellido("asdfs");
        usuario.setFechaNacimiento(new Date());
        usuario.setCorreoElectronico("asdfasdf");


       String inputJson = this.mapToJson(usuario);

       String URI = "/api/v1/usuario/";

       Mockito.when(usuarioService.save(Mockito.any(Usuario.class))).thenReturn(usuario);

       RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);

      MvcResult result = mvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse response = result.getResponse();
      

      assertEquals(HttpStatus.OK.value(), response.getStatus());
       
    }


    @Test
    void getUsuario() throws Exception{

        Usuario usuario = new Usuario();
        usuario.setId(2L);
       


       String inputJson = this.mapToJson(usuario);

       String URI = "/api/v1/usuario/" + usuario.getId();


       RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);

      MvcResult result = mvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse response = result.getResponse();
      

      assertEquals(HttpStatus.OK.value(), response.getStatus());
       
    }



    @Test
    void deleteUsuario() throws Exception{

        Usuario usuario = new Usuario();
        usuario.setId(1L);
       


       String inputJson = this.mapToJson(usuario);

       String URI = "/api/v1/usuario/" + usuario.getId();


       RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);

      MvcResult result = mvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse response = result.getResponse();
      

      assertEquals(HttpStatus.OK.value(), response.getStatus());
       
    }

    @Test
    void getUsuarios() throws Exception{

        List<Usuario> usuarios = new ArrayList<>();
       


       String inputJson = this.mapToJson(usuarios);

       String URI = "/api/v1/usuario/";

       RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);

      MvcResult result = mvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse response = result.getResponse();
      

      assertEquals(HttpStatus.OK.value(), response.getStatus());
       
    }

    private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}