package com.securecar.dao;

import com.securecar.to.IncidenteTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IncidenteDAO extends Repository{
    public ArrayList<IncidenteTO>findAll(){
        ArrayList<IncidenteTO> incidentes = new ArrayList<>();
        String sql = "SELECT * FROM t_securecar_incidente";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    IncidenteTO incidente = new IncidenteTO();
                    incidente.setIdIncidente(rs.getLong("id_incidente"));
                    incidente.setDataIncidente(rs.getDate("dt_incidente").toLocalDate());
                    incidente.setDesciIncidente(rs.getString("ds_incidente"));
                    incidente.setIdUsuario(rs.getLong("id_usuario"));
                    incidente.setIdConversa(rs.getLong("id_conversa"));
                    incidentes.add(incidente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL!" + e.getMessage());
        } finally {
            closeConnection();
        }
        return incidentes;
    }

}
