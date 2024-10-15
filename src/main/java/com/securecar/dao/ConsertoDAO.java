package com.securecar.dao;

import com.securecar.to.ConsertoTO;
import com.securecar.to.consertoTO;
import jakarta.validation.constraints.conserto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsertoDAO extends Repository{
    public ArrayList<ConsertoTO> findAll(){
        ArrayList<ConsertoTO> consertos = new ArrayList<>();
        String sql = "select * from t_securecar_conserto";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    ConsertoTO conserto = new ConsertoTO();
                    conserto.setIdConserto(rs.getLong("id_conserto"));
                    conserto.setDescricaoConserto(rs.getString("ds_conserto"));
                    conserto.setValorConserto(rs.getDouble("vl_conserto"));
                    conserto.setDataConserto(rs.getDate("dt_conserto").toLocalDate());
                    conserto.setIdIncidente(rs.getLong("id_incidente"));
                    consertos.add(conserto);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return consertos;
    }

    public ConsertoTO findById(Long id){
        String sql = "select * from t_securecar_conserto where id_conserto = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                ConsertoTO conserto = new ConsertoTO();
                conserto.setIdConserto(rs.getLong("id_conserto"));
                conserto.setIdIncidente(rs.getLong("id_incidente"));
                conserto.setDescricaoConserto(rs.getString("ds_conserto"));
                conserto.setValorConserto(rs.getDouble("vl_conserto"));
                conserto.setDataConserto(rs.getDate("dt_consert").toLocalDate());
                return conserto;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ConsertoTO save(consertoTO conserto){
        String sql = "insert into t_securecar_conserto (ds_conserto, st_conserto) values (?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, conserto.getDescricao());
            ps.setString(2, String.valueOf(conserto.getStatus()));
            if (ps.executeUpdate() > 0){
                return conserto;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
