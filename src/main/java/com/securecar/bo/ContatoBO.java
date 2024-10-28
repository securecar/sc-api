package com.securecar.bo;

import com.securecar.dao.ContatoDAO;
import com.securecar.to.ContatoTO;

import java.util.ArrayList;

public class ContatoBO {
    ContatoDAO contatoDAO;
    public ArrayList<ContatoTO> findAll(){
        contatoDAO = new ContatoDAO();
        return contatoDAO.findAll();
    }
    public ContatoTO findById(Long id){
        contatoDAO = new ContatoDAO();
        return contatoDAO.findById(id);
    }

    public ContatoTO save(ContatoTO ContatoTO){
        contatoDAO = new ContatoDAO();
        return contatoDAO.save(ContatoTO);
    }

    public boolean delete(Long codigo){
        contatoDAO = new ContatoDAO();
        return contatoDAO.delete(codigo);
    }

    public ContatoTO update (ContatoTO contato){
        contatoDAO = new ContatoDAO();
        return contatoDAO.update(contato);
    }
}
