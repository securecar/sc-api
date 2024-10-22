package com.securecar.dao;

import com.securecar.to.IncidenteTO;

import java.sql.Date;
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
    public IncidenteTO findById(Long id){
        IncidenteTO incidente = new IncidenteTO();
        String sql = "select from t_securecar_incidente where id_incidente = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                incidente.setIdIncidente(rs.getLong("id_incidente"));
                incidente.setDataIncidente(rs.getDate("dt_incidente").toLocalDate());
                incidente.setDesciIncidente(rs.getString("ds_incidente"));
                incidente.setIdUsuario(rs.getLong("id_usuario"));
                incidente.setIdConversa(rs.getLong("id_conversa"));
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally{
            closeConnection();
        }
        return incidente;
    }

    public IncidenteTO save(IncidenteTO incidenteTO) {
        String sql = "insert into T_SECURECAR_INCIDENTE (DT_INCIDENTE, DS_INCIDENTE, ID_CONVERSA) values (?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(incidenteTO.getDataIncidente()));
            ps.setString( 2, incidenteTO.getDesciIncidente());
            ps.setLong(3, incidenteTO.getIdUsuario());
            ps.setLong(4, incidenteTO.getIdConversa());
            if (ps.executeUpdate() > 0 ){
                return incidenteTO;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL!" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;

    }

    public boolean delete(Long codigo){
        String sql = "delete T_SECURECAR_INCIDENTE where ID_INCIDENTE = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public IncidenteTO edit(Long id, IncidenteTO incidente) {
        String sql = "update T_SECURECAR_INCIDENTE set DT_INCIDENTE = ?, DS_INCIDENTE = ? ";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, incidente.getIdIncidente());
            ps.setDate(2, Date.valueOf(incidente.getDataIncidente()));
            ps.setString(3, incidente.getDesciIncidente());
        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
