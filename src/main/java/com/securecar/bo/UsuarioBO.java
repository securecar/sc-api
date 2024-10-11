package com.securecar.bo;

import com.securecar.to.UsuarioTO;

import java.util.ArrayList;

public class UsuarioBO {
    public ArrayList<UsuarioTO> findAll(){
        UsuarioBO usuarioBO = new UsuarioBO();
        return usuarioBO.findAll();
    }
}
