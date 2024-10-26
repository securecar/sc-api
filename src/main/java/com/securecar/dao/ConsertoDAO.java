package com.securecar.dao;

import com.securecar.to.ConsertoTO;
import com.securecar.to.consertoTO;
import com.securecar.to.consertoTO;
import jakarta.validation.constraints.conserto;

import java.sql.Date;
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
                    conserto.setIdIncidente(rs.getLong("id_usuario"));
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
                conserto.setIdIncidente(rs.getLong("id_usuario"));
                conserto.setDescricaoConserto(rs.getString("ds_conserto"));
                conserto.setValorConserto(rs.getDouble("vl_conserto"));
                conserto.setDataConserto(rs.getDate("dt_conserto").toLocalDate());
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

    public ConsertoTO save(ConsertoTO conserto){
        String sql = "insert into t_securecar_conserto (DT_CONSERTO, DS_CONSERTO, VL_CONSERTO, ID_USUARIO) values (?, ?)";
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

    public boolean delete(Long id){
        String sql = "Delete t_securecar_conserto where id_conserto = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
        return false;
    }
    public ConsertoTO edit(Long id, ConsertoTO conserto){
        String sql = "update t_securecar_conserto set dt_conserto=?, DS_CONSERTO=? where id_conserto =?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDate(1, Date.valueOf(conserto.getDataconserto()));
            ps.setLong(2, conserto.getIdIncidente());
            ps.setLong(3,id);
            conserto.setIdconserto(id);
            if (ps.executeUpdate() > 0){
                return conserto;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
