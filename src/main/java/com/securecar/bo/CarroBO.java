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

    public ArrayList<CarroTO> findAllByIdUsuario(Long idUsuario) {
        CarroDAO carroDAO = new CarroDAO();
        return carroDAO.findAllByIdUsuario(idUsuario);
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

    public CarroTO update(CarroTO carro){
        CarroDAO = new CarroDAO();
        return CarroDAO.update(carro);
    }
}
