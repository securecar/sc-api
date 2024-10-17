package com.securecar.bo;

import com.securecar.dao.PecaConsertoDAO;

import com.securecar.to.PecaConsertoTO;

import java.util.ArrayList;

public class PecaConsertoBO {
    PecaConsertoDAO pecaConsertoDAO;
    public ArrayList<PecaConsertoTO> findAll(){
        pecaConsertoDAO = new PecaConsertoDAO();
        return pecaConsertoDAO.findAll();
    }

    public PecaConsertoTO findById(Long id){
        pecaConsertoDAO = new PecaConsertoDAO();
        return pecaConsertoDAO.findById(id);
    }

    public PecaConsertoTO save (PecaConsertoTO seguroTO){
        pecaConsertoDAO = new PecaConsertoDAO();
        return pecaConsertoDAO.save(seguroTO);
    }
    public boolean delete(Long codigo){
        pecaConsertoDAO = new PecaConsertoDAO();
        return pecaConsertoDAO.delete(codigo);
    }

    public PecaConsertoTO edit (Long id, PecaConsertoTO peca){
        pecaConsertoDAO = new PecaConsertoDAO();
        return pecaConsertoDAO.edit(id, peca);
    }
}
