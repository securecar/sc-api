package com.securecar.bo;

import com.securecar.dao.TelefoneDAO;
import com.securecar.to.TelefoneTO;

import java.util.ArrayList;

public class TelefoneBO {
    TelefoneDAO TelefoneDAO;
    public ArrayList<TelefoneTO> findAll(){
        TelefoneDAO = new TelefoneDAO();
        return TelefoneDAO.findAll();
    }
    public TelefoneTO findById(Long id){
        TelefoneDAO = new TelefoneDAO();
        return TelefoneDAO.findById(id);
    }

    public TelefoneTO save(TelefoneTO TelefoneTO){
        TelefoneDAO = new TelefoneDAO();
        return TelefoneDAO.save(TelefoneTO);
    }

    public boolean delete(Long codigo){
        TelefoneDAO = new TelefoneDAO();
        return TelefoneDAO.delete(codigo);
    }

    public TelefoneTO edit (Long id, TelefoneTO email){
        TelefoneDAO = new TelefoneDAO();
        return TelefoneDAO.edit(id, email);
    }

}
