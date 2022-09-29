package com.CRUDtitanes.titanes.controller;

import com.CRUDtitanes.titanes.model.ObjetoRespuesta;
import com.CRUDtitanes.titanes.model.Usuario;
import com.CRUDtitanes.titanes.service.GestorUsuarioList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//GET consulta la lista completa
@RestController
public class UsuarioControlador {
    private GestorUsuarioList gestorUsuario = new GestorUsuarioList();
    @GetMapping("/usuarios") //vamos a mapear una entrada, una direccion web
    public ResponseEntity<ArrayList<Usuario>> getUsuario(){
        return new ResponseEntity<>(gestorUsuario.getUsuarios(), HttpStatus.ACCEPTED); //trae todos los usuarios
    }

    //GET consulta una busqueda por id -tomano el nombreUsuario
    @GetMapping("/usuario")
    public ResponseEntity<Object> getUsuario(@RequestParam String id){
        try {
            Usuario usuario = gestorUsuario.getUsuarios(id);
            return new ResponseEntity<>(usuario,HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //GET ruta /
    @GetMapping("/usuario/{id}")
    public ResponseEntity<String> getUsuarioPath(@PathVariable String id){
        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
    }

    //POST
    @PostMapping("/usuario")
    public ResponseEntity<String> postUsuario(@RequestBody Usuario usuario_parametro){
        try {
            String mensaje = gestorUsuario.setUsuario(usuario_parametro);
            return new ResponseEntity<>(mensaje,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> putUsuario(@RequestBody Usuario usuario_update, @PathVariable String id){

        try {
            Usuario usuario_db = gestorUsuario.update_usuarioAll(usuario_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa",usuario_db ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PATCH
    @PatchMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> patchUsuario(@RequestBody Usuario usuario_update, @PathVariable String id){

        try {
            Usuario usuario_db = gestorUsuario.update_usuario(usuario_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa",usuario_db ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> DeleteUsuario(@PathVariable String id){
        try {
            String mensaje = gestorUsuario.detele_usuario(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje, null ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}