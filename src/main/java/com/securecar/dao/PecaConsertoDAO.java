package com.securecar.dao;

import com.securecar.to.PecaConsertoTO;
import com.securecar.to.SeguroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaConsertoDAO extends Repository {
    public ArrayList<PecaConsertoTO> findAll() {
        ArrayList<PecaConsertoTO> pecas = new ArrayList<>();
        String sql = "select * from t_securecar_peca_conserto order by id_peca_conserto";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PecaConsertoTO peca = new PecaConsertoTO();
                    peca.setIdPecaConserto(rs.getLong("id_peca_conserto"));
                    peca.setIdConserto(rs.getLong("id_conserto"));
                    peca.setIdPeca(rs.getLong("id_peca"));
                    pecas.add(peca);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler: " + e.getMessage());
            ;
        } finally {
            closeConnection();
        }
        return pecas;
    }
    public PecaConsertoTO findById(Long id){
        PecaConsertoTO peca = new PecaConsertoTO();
        String sql = "select * from t_securecar_peca_conserto where id_peca_conserto = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                peca.setIdPecaConserto(rs.getLong("id_peca_conserto"));
                peca.setIdConserto(rs.getLong("id_conserto"));
                peca.setIdPeca(rs.getLong("id_peca"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return peca;
    }
    public PecaConsertoTO save(PecaConsertoTO peca){
        String sql = "insert into t_securecar_peca_conserto (id_peca_conserto,id_conserto,id_peca) values (?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,peca.getIdPecaConserto());
            ps.setLong(2,peca.getIdConserto());
            ps.setLong(3,peca.getIdPeca());
            if(ps.executeUpdate() > 0){
                return peca;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
    public boolean delete(Long id){
        String sql = "Delete t_securecar_seguro where id_peca_conserto=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
        return false;
    }

    public PecaConsertoTO edit(Long id, PecaConsertoTO peca){
        String sql = "update t_securecar_peca_conserto set id_conserto=?,id_peca=? where id_peca_seguro =?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,peca.getIdConserto());
            ps.setLong(2,peca.getIdPeca());
            ps.setLong(3,id);
            peca.setIdPecaConserto(id);
            if (ps.executeUpdate() > 0){
                return peca;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
