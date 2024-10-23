package com.securecar.bo;

import com.securecar.dao.CarroDAO;
import com.securecar.to.CarroTO;

import java.util.ArrayList;

public class CarroBO {
    CarroDAO CarroDAO;

    public ArrayList<CarroTO> findAll(){
        CarroDAO = new CarroDAO();
        return CarroDAO.findAll();
    }

    public CarroTO findById(Long id){
        CarroDAO = new CarroDAO();
        return CarroDAO.findById(id);
    }

    public CarroTO save(CarroTO carro){
        CarroDAO = new CarroDAO();
        return CarroDAO.save(carro);
    }

    public boolean delete(Long codigo){
        CarroDAO = new CarroDAO();
        return CarroDAO.delete(codigo);
    }

    public CarroTO edit(Long id, CarroTO carro){
        CarroDAO = new CarroDAO();
        return CarroDAO.edit(id, carro);
    }
}
