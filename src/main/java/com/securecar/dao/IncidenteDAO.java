package com.securecar.dao;

import com.securecar.to.IncidenteTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class IncidenteDAO extends Repository{
    public ArrayList<IncidenteTO>findAll(){
        ArrayList<IncidenteTO> incidente = new ArrayList<>();
        String sql = "SELECT * FROM t_securecar_incidente";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

        } catch (SQLException e) {
            System.out.println("Erro de SQL!" + e.getMessage());
        }
    }
}
