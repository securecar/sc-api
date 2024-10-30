package com.securecar.dao;

import com.securecar.to.PecaConsertoTO;
import com.securecar.to.PecaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaConsertoDAO extends Repository {
    public ArrayList<PecaConsertoTO> findAll(){
        ArrayList<PecaConsertoTO> pecasConserto = new ArrayList<>();
        String sql = "select * from T_SECURECAR_PECA_CONSERTO ";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    PecaConsertoTO pecaConserto = new PecaConsertoTO();
                    pecaConserto.setIdConserto(rs.getLong("id_conserto"));
                    pecaConserto.setIdPeca(rs.getLong("id_peca"));
                    pecaConserto.setIdPecaConserto(rs.getLong("id_peca_conserto" +
                            ""));
                    pecasConserto.add(pecaConserto);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pecasConserto;
    }

    public PecaConsertoTO findById(Long id){
        String sql = "select * from T_SECURECAR_PECA_CONSERTO where ID_PECA_CONSERTO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                PecaConsertoTO pecaConserto = new PecaConsertoTO();
                pecaConserto.setIdPeca(rs.getLong("id_peca"));
                pecaConserto.setIdConserto(rs.getLong("id_conserto"));
                pecaConserto.setIdPecaConserto(rs.getLong("id_peca_conserto"));
                return pecaConserto;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }



    public PecaConsertoTO save(PecaConsertoTO pecaConserto){
        String sql = "insert into T_SECURECAR_PECA_CONSERTO (ID_CONSERTO, ID_PECA) VALUES (?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, pecaConserto.getIdConserto());
            ps.setLong(2, pecaConserto.getIdPeca());

            if (ps.executeUpdate() > 0){
                return pecaConserto;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_PECA_CONSERTO where ID_PECA_CONSERTO = ?";
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

}
