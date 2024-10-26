package com.securecar.bo;

import com.securecar.dao.ConsertoDAO;
import com.securecar.to.ConsertoTO;

import java.util.ArrayList;

public class ConsertoBO {
    ConsertoDAO consertoDAO;

    public ArrayList<ConsertoTO> findAll(){
        consertoDAO = new ConsertoDAO();
        return consertoDAO.findAll();
    }

    public ConsertoTO findById(Long id){
        consertoDAO = new ConsertoDAO();
        return consertoDAO.findById(id);
    }

    public ConsertoTO save(ConsertoTO conserto){
        consertoDAO = new ConsertoDAO();
        return consertoDAO.save(conserto);
    }

    public boolean delete(Long codigo){
        consertoDAO = new ConsertoDAO();
        return consertoDAO.delete(codigo);
    }

    public ConsertoTO edit(Long id, ConsertoTO conserto){
        consertoDAO = new ConsertoDAO();
        return consertoDAO.edit(id, conserto);
    }
}
