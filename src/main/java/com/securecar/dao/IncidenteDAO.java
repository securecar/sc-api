package com.securecar.dao;

import com.securecar.to.IncidenteTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IncidenteDAO extends Repository{
    public ArrayList<IncidenteTO> findAll(){
        ArrayList<IncidenteTO> incidentes = new ArrayList<>();
        String sql = "select * from t_securecar_incidente";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    IncidenteTO incidente = new IncidenteTO();
                    incidente.setIdIncidente(rs.getLong("id_incidente"));
                    incidente.setDesciIncidente(rs.getString("ds_incidente"));
                    incidente.setDataIncidente(rs.getDate("dt_incidente").toLocalDate());
                    incidente.setIdConversa(rs.getLong("id_conversa"));
                    incidente.setIdUsuario(rs.getLong("id_usuario"));
                    incidentes.add(incidente);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return incidentes;
    }

    public IncidenteTO findById(Long id){
        String sql = "select * from t_securecar_incidente where id_incidente = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                IncidenteTO incidente = new IncidenteTO();
                incidente.setIdIncidente(rs.getLong("id_incidente"));
                incidente.setDesciIncidente(rs.getString("ds_incidente"));
                incidente.setDataIncidente(rs.getDate("dt_incidente").toLocalDate());
                incidente.setIdUsuario(rs.getLong("id_usuario"));
                incidente.setIdConversa(rs.getLong("id_conversa"));
                return incidente;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public IncidenteTO save(IncidenteTO incidente){
        String sql = "insert into t_securecar_incidente () values (?, ?, " +
                "?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, incidente.get());
            ps.setInt(2, incidente.getEstrelasincidente());
            ps.setLong(3, incidente.getIdUsuario());
            if (ps.executeUpdate() > 0){
                return incidente;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_incidente where ID_incidente = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public IncidenteTO edit(Long id, IncidenteTO incidente){
        String sql = "update T_SECURECAR_incidente set DS_incidente = ?, VL_ESTRELAS_incidente = ? where ID_incidente =" +
                " ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(3, id);
            ps.setString(1, incidente.getComentarioincidente());
            ps.setInt(2, incidente.getEstrelasincidente());
            incidente.setIdincidente(id);
            if (ps.executeUpdate() > 0){
                return incidente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
