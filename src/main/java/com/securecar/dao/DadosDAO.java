package com.securecar.dao;

import com.securecar.to.DadosTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DadosDAO extends Repository{
    public ArrayList<DadosTO> findAll(){
        ArrayList<DadosTO> dadoss = new ArrayList<>();
        String sql = "select * from T_SECURECAR_DADOS";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    DadosTO dados = new DadosTO();
                    dados.setIdDados(rs.getLong("id_dados"));
                    dados.setIdEmail(rs.getLong("id_email"));
                    dados.setIdLogradouro(rs.getLong("id_logradouro"));
                    dados.setIdTelefone(rs.getLong("id_telefone"));
                    dadoss.add(dados);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return dadoss;
    }

    public DadosTO findById(Long id){
        String sql = "select * from T_SECURECAR_DADOS where id_dados = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                DadosTO dados = new DadosTO();
                dados.setIdDados(rs.getLong("id_dados"));
                dados.setIdEmail(rs.getLong("id_email"));
                dados.setIdLogradouro(rs.getLong("id_logradouro"));
                dados.setIdTelefone(rs.getLong("id_telefone"));
                return dados;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public DadosTO save(DadosTO dados){
        String sql = "insert into T_SECURECAR_DADOS (ID_LOGRADOURO, ID_EMAIL, ID_TELEFONE) values (?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, dados.getIdLogradouro());
            ps.setLong(2, dados.getIdEmail());
            ps.setLong(3, dados.getIdTelefone());
            if (ps.executeUpdate() > 0){
                return dados;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_dados where ID_dados = ?";
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

    public DadosTO edit(Long id, DadosTO dados){
        String sql = "update T_SECURECAR_dados set ID_EMAIL = ?, ID_TELEFONE = ?, ID_LOGRADOURO = ? where ID_dados = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            dados.setIdDados(id);
            ps.setLong(4, dados.getIdDados());
            ps.setLong(1, dados.getIdEmail());
            ps.setLong(2, dados.getIdTelefone());
            ps.setLong(3, dados.getIdLogradouro());
            if (ps.executeUpdate() > 0){
                return dados;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
