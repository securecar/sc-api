package com.securecar.bo;

import com.securecar.dao.FeedbackDAO;
import com.securecar.to.FeedbackTO;

import java.util.ArrayList;

public class FeedbackBO {
    FeedbackDAO FeedbackDAO;
    public ArrayList<FeedbackTO> findAll(){
        FeedbackDAO = new FeedbackDAO();
        return FeedbackDAO.findAll();
    }
    public FeedbackTO findById(Long id){
        FeedbackDAO = new FeedbackDAO();
        return FeedbackDAO.findById(id);
    }

    public FeedbackTO save(FeedbackTO FeedbackTO){
        FeedbackDAO = new FeedbackDAO();
        return FeedbackDAO.save(FeedbackTO);
    }

    public boolean delete(Long codigo){
        FeedbackDAO = new FeedbackDAO();
        return FeedbackDAO.delete(codigo);
    }

    public FeedbackTO edit (Long id, FeedbackTO email){
        FeedbackDAO = new FeedbackDAO();
        return FeedbackDAO.edit(id, email);
    }
    
}
