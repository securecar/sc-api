package com.securecar.bo;

import com.securecar.dao.EnderecoDAO;
import com.securecar.to.EnderecoTO;

import java.util.ArrayList;

public class EnderecoBO {
    EnderecoDAO enderecoDAO;
    public ArrayList<EnderecoTO> findAll(){
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findAll();
    }
    public EnderecoTO findById(Long id){
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.findById(id);
    }

    public EnderecoTO save(EnderecoTO EnderecoTO){
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.save(EnderecoTO);
    }

    public boolean delete(Long codigo){
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.delete(codigo);
    }

    public EnderecoTO update (EnderecoTO contato){
        enderecoDAO = new EnderecoDAO();
        return enderecoDAO.update(contato);
    }
}
