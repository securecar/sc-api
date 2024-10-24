package com.securecar.bo;

import com.securecar.dao.MensagemDAO;
import com.securecar.to.MensagemTO;

import java.util.ArrayList;

public class MensagemBO {
    MensagemDAO MensagemDAO;
    public ArrayList<MensagemTO> findAll(){
        MensagemDAO = new MensagemDAO();
        return  MensagemDAO.findAll();
    }

    public MensagemTO findById(Long id){
        MensagemDAO = new MensagemDAO();
        return MensagemDAO.findById(id);
    }

    public MensagemTO save(MensagemTO mensagemTO){
        MensagemDAO = new MensagemDAO();
        return MensagemDAO.save(mensagemTO);
    }
    public boolean delete(Long codigo){
        MensagemDAO = new MensagemDAO();
        return MensagemDAO.delete(codigo);
    }

    public MensagemTO edit(Long id, MensagemTO mensagem) {
        MensagemDAO = new MensagemDAO();
        return MensagemDAO.edit(id, mensagem);
    }
}
