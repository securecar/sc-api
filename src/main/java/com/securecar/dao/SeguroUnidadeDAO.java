package com.securecar.dao;

import com.securecar.to.SeguroUnidadeTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeguroUnidadeDAO extends Repository{
    public ArrayList<SeguroUnidadeTO> findAll(){
        ArrayList<SeguroUnidadeTO> seguroUnidades = new ArrayList<>();
        String sql = "select * from T_SECURECAR_SEGURO_UNIDADE";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    SeguroUnidadeTO seguroUnidade = new SeguroUnidadeTO();
                    seguroUnidade.setIdSeguro(rs.getLong("id_seguro"));
                    seguroUnidade.setNomeUnidade(rs.getString("nm_unidade"));
                    seguroUnidade.setIdContato(rs.getLong("id_contato"));
                    seguroUnidade.setIdEndereco(rs.getLong("id_endereco"));
                    seguroUnidades.add(seguroUnidade);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return seguroUnidades;
    }

    public SeguroUnidadeTO findById(Long id){
        String sql = "select * from T_SECURECAR_SEGURO_UNIDADE where ID_UNIDADE = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                SeguroUnidadeTO seguroUnidade = new SeguroUnidadeTO();
                seguroUnidade.setIdSeguro(rs.getLong("id_seguro"));
                seguroUnidade.setNomeUnidade(rs.getString("nm_unidade"));
                seguroUnidade.setIdContato(rs.getLong("id_contato"));
                seguroUnidade.setIdEndereco(rs.getLong("id_endereco"));
                return seguroUnidade;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public SeguroUnidadeTO save(SeguroUnidadeTO seguroUnidade){
        String sql = "insert into T_SECURECAR_SEGURO_UNIDADE (NM_UNIDADE, ID_ENDERECO, ID_CONTATO, ID_SEGURO) values" +
                " (?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(4, seguroUnidade.getIdSeguro());
            ps.setString(1, seguroUnidade.getNomeUnidade());
            ps.setLong(2, seguroUnidade.getIdEndereco());
            ps.setLong(3, seguroUnidade.getIdContato());
            if (ps.executeUpdate() > 0){
                return seguroUnidade;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_SEGURO_UNIDADE where ID_UNIDADE = ?";
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

    public SeguroUnidadeTO update(SeguroUnidadeTO seguroUnidade){
        String sql = "update T_SECURECAR_SEGURO_UNIDADE set NM_UNIDADE = ? where ID_UNIDADE = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, seguroUnidade.getNomeUnidade());
            if (ps.executeUpdate() > 0){
                return seguroUnidade;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
