package com.securecar.bo;

import com.securecar.dao.PecaDAO;
import com.securecar.to.PecaTO;

import java.util.ArrayList;

public class PecaBO {
    PecaDAO pecaDAO;
    public ArrayList<PecaTO> findAll(){
        pecaDAO = new PecaDAO();
        return pecaDAO.findAll();
    }
    public PecaTO findById(Long id){
        pecaDAO = new PecaDAO();
        return pecaDAO.findById(id);
    }

    public ArrayList<PecaTO> findAllByIdConserto(Long id){
        pecaDAO = new PecaDAO();
        return pecaDAO.findAllByIdConserto(id);
    }

    public PecaTO save(PecaTO pecaTO){
        pecaDAO = new PecaDAO();
        return pecaDAO.save(pecaTO);
    }
}
