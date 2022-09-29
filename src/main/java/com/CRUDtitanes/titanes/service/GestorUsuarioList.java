package com.CRUDtitanes.titanes.service;

import com.CRUDtitanes.titanes.model.Usuario;

import java.util.ArrayList;

public class GestorUsuarioList {
    private ArrayList<Usuario> usuarios;

    public GestorUsuarioList(){
        this.usuarios = new ArrayList<>();

        this.usuarios.add(new Usuario("nombre", "prueba","123"));

    }

    public Usuario getUsuarios(String nombreUsuario) throws Exception {
        for(Usuario usuario: this.usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                return usuario;
            }
        }
        throw new Exception("Usuario no Existe");
    }

    public String setUsuario(Usuario usuario_parametro) throws Exception {
        try {
            //consultamos los usuarios existentes
            getUsuarios(usuario_parametro.getNombreUsuario());
        } catch (Exception e) {
            //si no existe se crea
            this.usuarios.add(usuario_parametro);
            return "Creacion del usuario Exitosa";
        } //si existe sale mensaje de que ya existe usuario
        throw new Exception("Usuario Existe");
    }

    public Usuario update_usuario(Usuario usuario_uptate, String id) throws Exception {
        try {
            Usuario usuario_bd = getUsuarios(id);
            if(usuario_bd.getNombreUsuario() != null && !usuario_uptate.getNombreUsuario().equals("")){
                usuario_bd.setNombreUsuario(usuario_uptate.getNombreUsuario());
            }
            if(usuario_bd.getNombre() != null && !usuario_uptate.getNombre().equals("")){
                usuario_bd.setNombre(usuario_uptate.getNombre());
            }
            if(usuario_bd.getPassword() != null && !usuario_uptate.getPassword().equals("")){
                usuario_bd.setPassword(usuario_uptate.getPassword());
            }
            return usuario_bd;
        } catch (Exception e) {
            throw new Exception("Usuario No existe, fallo actualización de datos");
        }
    }

    public Usuario update_usuarioAll(Usuario usuario_update, String id) throws Exception {
        try {
            Usuario usuario_bd = getUsuarios(id);

            usuario_bd.setNombreUsuario(usuario_update.getNombreUsuario());
            usuario_bd.setNombre(usuario_update.getNombre());
            usuario_bd.setPassword(usuario_update.getPassword());
            return usuario_bd;

        } catch (Exception e) {
            throw new Exception("Usuario No existe, fallo actualización de datos");
        }
    }

    public String detele_usuario(String id) throws Exception {
        try {
            Usuario usuario = getUsuarios(id);
            this.usuarios.remove(usuario);
            return "Eliminado Exitoso";
        } catch (Exception e) {
            throw new Exception("Usuario No existe");
        }

    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
