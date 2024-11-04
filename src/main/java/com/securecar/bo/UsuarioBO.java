package com.securecar.bo;

import com.securecar.dao.UsuarioDAO;
import com.securecar.to.UsuarioTO;

import java.util.ArrayList;

public class UsuarioBO {
    UsuarioDAO usuarioDAO;
    public ArrayList<UsuarioTO> findAll(){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findAll();
    }

    public UsuarioTO findById(Long id){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findById(id);
    }

    public UsuarioTO save (UsuarioTO usuarioTO){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.save(usuarioTO);
    }

    public boolean delete(Long codigo){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.delete(codigo);
    }

    public UsuarioTO update (UsuarioTO contato){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.update(contato);
    }
}
