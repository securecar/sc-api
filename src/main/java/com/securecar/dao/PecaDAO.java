package com.securecar.dao;

import com.securecar.to.PecaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO extends Repository{
    public ArrayList<PecaTO> findAll(){
        ArrayList<PecaTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM t_securecar_peca";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs!=null){
                while(rs.next()){
                    PecaTO peca = new PecaTO();
                    peca.setIdPeca(rs.getLong(1));
                    peca.setValorPeca(rs.getDouble("vl_peca"));
                    peca.setQuantidadePeca(rs.getInt("qt_peca"));
                    peca.setDescricaoPeca(rs.getString("ds_peca"));
                    resultado.add(peca);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return resultado;
    }

    public PecaTO findById(Long id){
        String sql = "SELECT * FROM t_securecar_peca where id_peca = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                PecaTO peca = new PecaTO();
                peca.setIdPeca(rs.getLong("id_peca"));
                peca.setDescricaoPeca(rs.getString("ds_peca"));
                peca.setQuantidadePeca(rs.getInt("qt_peca"));
                peca.setValorPeca(rs.getDouble("vl_peca"));
                return peca;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public PecaTO save(PecaTO pecaTO){
        String sql = "INSERT INTO t_securecar_peca(VL_PECA, DS_PECA, QT_PECA) values (?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDouble(1, pecaTO.getValorPeca());
            ps.setString(2, pecaTO.getDescricaoPeca());
            ps.setInt(3, pecaTO.getQuantidadePeca());
            if (ps.executeUpdate() > 0){
                return pecaTO;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
