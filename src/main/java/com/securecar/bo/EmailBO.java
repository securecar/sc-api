package com.securecar.bo;

import com.securecar.dao.EmailDAO;
import com.securecar.to.EmailTO;

import java.util.ArrayList;

public class EmailBO {
    EmailDAO emailDAO;
    public ArrayList<EmailTO> findAll(){
        emailDAO = new EmailDAO();
        return emailDAO.findAll();
    }
    public EmailTO findById(Long id){
        emailDAO = new EmailDAO();
        return emailDAO.findById(id);
    }

    public EmailTO save(EmailTO EmailTO){
        emailDAO = new EmailDAO();
        return emailDAO.save(EmailTO);
    }
}