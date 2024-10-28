package com.securecar.bo;

import com.securecar.dao.SeguroUnidadeDAO;
import com.securecar.to.SeguroUnidadeTO;

import java.util.ArrayList;

public class SeguroUnidadeBO {
    SeguroUnidadeDAO seguroUnidadeDAO;
    public ArrayList<SeguroUnidadeTO> findAll(){
        seguroUnidadeDAO = new SeguroUnidadeDAO();
        return seguroUnidadeDAO.findAll();
    }
    public SeguroUnidadeTO findById(Long id){
        seguroUnidadeDAO = new SeguroUnidadeDAO();
        return seguroUnidadeDAO.findById(id);
    }

    public SeguroUnidadeTO save(SeguroUnidadeTO SeguroUnidadeTO){
        seguroUnidadeDAO = new SeguroUnidadeDAO();
        return seguroUnidadeDAO.save(SeguroUnidadeTO);
    }

    public boolean delete(Long codigo){
        seguroUnidadeDAO = new SeguroUnidadeDAO();
        return seguroUnidadeDAO.delete(codigo);
    }

    public SeguroUnidadeTO update (SeguroUnidadeTO contato){
        seguroUnidadeDAO = new SeguroUnidadeDAO();
        return seguroUnidadeDAO.update(contato);
    }
}
