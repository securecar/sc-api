package com.securecar.dao;

import com.securecar.to.ConsertoTO;
import com.securecar.to.ContatoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatoDAO extends Repository{
    public ArrayList<ContatoTO> findAll(){
        ArrayList<ContatoTO> contatos = new ArrayList<>();
        String sql = "select * from T_SECURECAR_CONTATO ";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    ContatoTO contato = new ContatoTO();
                    contato.setIdContato(rs.getLong("id_contato"));
                    contato.setTelefone(rs.getLong("nr_telefone"));
                    contato.setEmail(rs.getString("nm_email"));
                    contatos.add(contato);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return contatos;
    }

    public ContatoTO findById(Long id){
        String sql = "select * from T_SECURECAR_CONTATO where ID_CONTATO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                ContatoTO contato = new ContatoTO();
                contato.setEmail(rs.getString("nm_email"));
                contato.setTelefone(rs.getLong("nr_telefone"));
                contato.setIdContato(rs.getLong("id_contato"));
                return contato;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ContatoTO save(ContatoTO contato){
        String sql = "insert into T_SECURECAR_CONTATO(NM_EMAIL, NR_TELEFONE) VALUES (?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, contato.getEmail());
            ps.setLong(2, contato.getTelefone());
            if (ps.executeUpdate() > 0){
                return contato;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }



    public boolean delete(Long id){
        String sql = "Delete T_SECURECAR_CONTATO where ID_CONTATO = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
        return false;
    }

    public ContatoTO update(ContatoTO contato){
        String sql = "update T_SECURECAR_CONTATO set NM_EMAIL = ?, NR_TELEFONE = ? where ID_CONTATO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, contato.getEmail());
            ps.setLong(2, contato.getTelefone());
            ps.setLong(3,contato.getIdContato());
            if (ps.executeUpdate() > 0){
                return contato;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }
}
