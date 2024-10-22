package com.securecar.dao;

import com.securecar.to.TelefoneTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelefoneDAO extends Repository{
    public ArrayList<TelefoneTO> findAll(){
        ArrayList<TelefoneTO> telefones = new ArrayList<>();
        String sql = "select * from T_SECURECAR_TELEFONE";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    TelefoneTO telefone = new TelefoneTO();
                    telefone.setIdTelefone(rs.getLong("id_telefone"));
                    telefone.setTipo(rs.getString("tp_telefone").charAt(0));
                    telefone.setStatus(rs.getString("st_telefone").charAt(0));
                    telefone.setDdd(rs.getInt("ddd_telefone"));
                    telefone.setDdi(rs.getInt("ddi_telefone"));
                    telefone.setTelefone(rs.getInt("nr_telefone"));
                    telefones.add(telefone);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return telefones;
    }

    public TelefoneTO findById(Long id){
        String sql = "select * from t_securecar_telefone where id_telefone = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                TelefoneTO telefone = new TelefoneTO();
                telefone.setIdTelefone(rs.getLong("id_telefone"));
                telefone.setTipo(rs.getString("tp_telefone").charAt(0));
                telefone.setStatus(rs.getString("st_telefone").charAt(0));
                telefone.setDdd(rs.getInt("ddd_telefone"));
                telefone.setDdi(rs.getInt("ddi_telefone"));
                telefone.setTelefone(rs.getInt("nr_telefone"));
                return telefone;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public TelefoneTO save(TelefoneTO telefone){
        String sql = "insert into t_securecar_telefone (ST_TELEFONE, TP_TELEFONE, NR_DDI, NR_DDD, NR_TELEFONE) values" +
                " (?, ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, String.valueOf(telefone.getStatus()));
            ps.setString(2, String.valueOf(telefone.getTipo()));
            ps.setInt(3, telefone.getDdi());
            ps.setInt(4, telefone.getDdd());
            ps.setInt(5, telefone.getTelefone());
            if (ps.executeUpdate() > 0){
                return telefone;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_telefone where ID_telefone = ?";
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

    public TelefoneTO edit(Long id, TelefoneTO telefone){
        String sql = "update T_SECURECAR_telefone set TP_TELEFONE = ?, ST_telefone = ?, NR_DDD = ?, NR_DDI = ?, " +
                "NR_TELEFONE = ? where ID_telefone = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, String.valueOf(telefone.getTipo()));
            ps.setString(2, String.valueOf(telefone.getStatus()));
            ps.setInt(3, telefone.getDdd());
            ps.setInt(4, telefone.getDdi());
            ps.setInt(5, telefone.getTelefone());
            telefone.setIdTelefone(id);
            ps.setLong(6, telefone.getIdTelefone());
            if (ps.executeUpdate() > 0){
                return telefone;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
