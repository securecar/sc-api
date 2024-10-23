package com.securecar.bo;

import com.securecar.dao.IncidenteDAO;
import com.securecar.to.IncidenteTO;

import java.util.ArrayList;

public class IncidenteBO {
    IncidenteDAO IncidenteDAO;
    public ArrayList<IncidenteTO> findAll(){
        IncidenteDAO = new IncidenteDAO();
        return IncidenteDAO.findAll();
    }

    public IncidenteTO  findById(Long id) {
       IncidenteDAO = new IncidenteDAO();
       return IncidenteDAO.findById(id);
    }

    public IncidenteTO save(IncidenteTO IncidenteTO) {
        IncidenteDAO = new IncidenteDAO();
        return IncidenteDAO.save(IncidenteTO);
    }

    public boolean delete(Long codigo) {
        IncidenteDAO = new IncidenteDAO();
        return IncidenteDAO.delete(codigo);
    }

    public IncidenteTO edit(Long id, IncidenteTO incidente) {
        IncidenteDAO = new IncidenteDAO();
        return IncidenteDAO.edit(id, incidente);
    }
}
