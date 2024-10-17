package com.securecar.dao;

import com.securecar.to.ConversaTO;
import com.securecar.to.SeguroTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConversaDAO extends Repository{
    public ArrayList<ConversaTO> findAll() {
        ArrayList<ConversaTO> conversas = new ArrayList<>();
        String sql = "select * from t_securecar_conversa order by id_conversa";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ConversaTO conversa = new ConversaTO();
                    conversa.setIdConversa(rs.getLong("id_conversa"));
                    conversa.setDataConversa(rs.getDate("dt_conversa").toLocalDate());
                    conversa.setIdIncidente(rs.getLong("id_incidente"));
                    conversas.add(conversa);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler: " + e.getMessage());;
        }finally {
            closeConnection();
        }
        return conversas;
    }
    public ConversaTO findById(Long id){
        ConversaTO conversa = new ConversaTO();
        String sql = "select * from t_securecar_conversa where id_conversa = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                conversa.setIdConversa(rs.getLong("id_conversa"));
                conversa.setDataConversa(rs.getDate("dt_conversa").toLocalDate());
                conversa.setIdIncidente(rs.getLong("id_incidente"));
            }


        } catch (SQLException e) {
            System.out.println("Erro ao ler: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return conversa;
    }
    public ConversaTO save(ConversaTO conversa){
        String sql = "insert into t_securecar_conversa (id_conversa,dt_conversa,id_incidente) values (?,?,? )";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,conversa.getIdConversa());
            ps.setDate(2, Date.valueOf(conversa.getDataConversa()));
            ps.setLong(3,conversa.getIdIncidente());
            if(ps.executeUpdate() > 0){
                return conversa;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
    public boolean delete(Long id){
        String sql = "Delete t_securecar_conversa where id_conversa=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
        return false;
    }
    public ConversaTO edit(Long id, ConversaTO conversa){
        String sql = "update t_securecar_conversa set dt_conversa=?,id_incidente=? where id_conversa =?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDate(1, Date.valueOf(conversa.getDataConversa()));
            ps.setLong(2, conversa.getIdIncidente());
            ps.setLong(3,id);
            conversa.setIdConversa(id);
            if (ps.executeUpdate() > 0){
                return conversa;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
