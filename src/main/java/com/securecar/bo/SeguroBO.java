package com.securecar.bo;


import com.securecar.dao.SeguroDAO;

import com.securecar.to.SeguroTO;


import java.util.ArrayList;

public class SeguroBO {
    
    SeguroDAO seguroDAO;
    public ArrayList<SeguroTO> findAll(){
        seguroDAO = new SeguroDAO();
        return seguroDAO.findAll();
    }

    public SeguroTO findById(Long id){
        seguroDAO = new SeguroDAO();
        return seguroDAO.findById(id);
    }

    public SeguroTO save (SeguroTO seguroTO){
        seguroDAO = new SeguroDAO();
        return seguroDAO.save(seguroTO);
    }
    public boolean delete(Long codigo){
        seguroDAO = new SeguroDAO();
        return seguroDAO.delete(codigo);
    }

    public SeguroTO update (SeguroTO seguro){
        seguroDAO = new SeguroDAO();
        return seguroDAO.update(seguro);
    }
}
