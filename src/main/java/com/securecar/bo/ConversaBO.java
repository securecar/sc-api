package com.securecar.bo;



import com.securecar.dao.ConversaDAO;
import com.securecar.to.ConversaTO;

import java.util.ArrayList;

public class ConversaBO {
    ConversaDAO conversaDAO;
    public ArrayList<ConversaTO> findAll(){
        conversaDAO = new ConversaDAO();
        return conversaDAO.findAll();
    }

    public ConversaTO findById(Long id){
        conversaDAO = new ConversaDAO();
        return conversaDAO.findById(id);
    }

    public ConversaTO save (ConversaTO conversa){
        conversaDAO = new ConversaDAO();
        return conversaDAO.save(conversa);
    }
    public boolean delete(Long codigo){
        conversaDAO = new ConversaDAO();
        return conversaDAO.delete(codigo);
    }

    public ConversaTO edit (Long id, ConversaTO conversa){
        conversaDAO = new ConversaDAO();
        return conversaDAO.edit(id, conversa);
    }
}
