package com.securecar.dao;

import com.securecar.to.EmailTO;
import jakarta.validation.constraints.Email;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmailDAO extends Repository{
    public ArrayList<EmailTO> findAll(){
        ArrayList<EmailTO> emails = new ArrayList<>();
        String sql = "select * from t_securecar_email";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    EmailTO email = new EmailTO();
                    email.setIdEmail(rs.getLong("id_email"));
                    email.setDescricao(rs.getString("ds_email"));
                    email.setStatus(rs.getString("st_email").charAt(0));
                    emails.add(email);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return emails;
    }

    public EmailTO findById(Long id){
        String sql = "select * from t_securecar_email where id_email = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                EmailTO email = new EmailTO();
                email.setIdEmail(rs.getLong("id_email"));
                email.setDescricao(rs.getString("ds_email"));
                email.setStatus(rs.getString("st_email").charAt(0));
                return email;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public EmailTO save(EmailTO email){
        String sql = "insert into t_securecar_email (ds_email, st_email) values (?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, email.getDescricao());
            ps.setString(2, String.valueOf(email.getStatus()));
            if (ps.executeUpdate() > 0){
                return email;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_EMAIL where ID_EMAIL = ?";
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

    public EmailTO edit(Long id, EmailTO email){
        String sql = "update T_SECURECAR_EMAIL set DS_EMAIL = ?, ST_EMAIL = ? where ID_EMAIL = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(3, id);
            ps.setString(1, email.getDescricao());
            ps.setString(2, String.valueOf(email.getStatus()));
            email.setIdEmail(id);
            if (ps.executeUpdate() > 0){
                return email;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

}
