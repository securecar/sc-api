package com.securecar.bo;

import com.securecar.dao.DadosDAO;

import java.util.ArrayList;

public class DadosBO {
    DadosDAO dadosDAO;
    public ArrayList<DadosTO> findAll(){
        dadosDAO = new DadosDAO();
        return dadosDAO.findAll();
    }
    public DadosTO findById(Long id){
        dadosDAO = new DadosDAO();
        return dadosDAO.findById(id);
    }

    public DadosTO save(DadosTO DadosTO){
        dadosDAO = new DadosDAO();
        return dadosDAO.save(DadosTO);
    }

    public boolean delete(Long codigo){
        dadosDAO = new DadosDAO();
        return dadosDAO.delete(codigo);
    }

    public DadosTO edit (Long id, DadosTO dados){
        dadosDAO = new DadosDAO();
        return dadosDAO.edit(id, dados);
    }
}
