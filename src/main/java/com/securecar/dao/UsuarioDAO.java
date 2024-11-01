package com.securecar.dao;

import com.securecar.to.UsuarioTO;
import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioDAO extends Repository {
    public ArrayList<UsuarioTO> findAll(){
        ArrayList<UsuarioTO> usuarios = new ArrayList<>();
        String sql = "select * from t_securecar_usuario order by id_usuario";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setIdUsuario(rs.getLong("id_usuario"));
                    usuario.setNomeUsuario(rs.getString("nm_usuario"));
                    usuario.setCpf(rs.getString("nr_cpf"));
                    usuario.setGenero(rs.getString("ds_genero"));
                    usuario.setSenha(rs.getString("ds_senha"));
                    usuario.setDataCriacaoConta(rs.getDate("dt_criacao_conta").toLocalDate());
                    usuario.setRg(rs.getString("nr_rg"));
                    usuario.setIdContato(rs.getLong("id_contato"));
                    usuario.setIdEndereco(rs.getLong("id_usuario"));
                    usuarios.add(usuario);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql!" + e.getMessage());
        }finally {
            closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findById(Long id){
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select * from T_SECURECAR_USUARIO where ID_USUARIO = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNomeUsuario(rs.getString("nm_usuario"));
                usuario.setGenero(rs.getString("ds_genero"));
                usuario.setRg(rs.getString("nr_rg"));
                usuario.setSenha(rs.getString("ds_senha"));
                usuario.setDataCriacaoConta(rs.getDate("dt_criacao_conta").toLocalDate());
                usuario.setCpf(rs.getString("nr_cpf"));
                usuario.setIdEndereco(rs.getLong("id_endereco"));
                usuario.setIdContato(rs.getLong("id_contato"));

            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuario;
    }


    public UsuarioTO save(UsuarioTO usuarioTO){
        String sql = "insert into T_SECURECAR_USUARIO (NM_USUARIO, NR_CPF, DS_SENHA, DS_GENERO, NR_RG, ID_CONTATO, " +
                "ID_ENDERECO, DT_CRIACAO_CONTA) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, usuarioTO.getNomeUsuario());
            ps.setString(2, usuarioTO.getCpf());
            ps.setString(3, usuarioTO.getSenha());
            ps.setString(4, usuarioTO.getGenero());
            ps.setString(5, usuarioTO.getRg());
            ps.setLong(6, usuarioTO.getIdContato());
            ps.setLong(7, usuarioTO.getIdEndereco());
            ps.setDate(8, Date.valueOf(LocalDate.now()));
            if (ps.executeUpdate() > 0){
                return usuarioTO;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_USUARIO where ID_USUARIO = ?";
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

    public UsuarioTO update(UsuarioTO usuario){
        String sql = "update T_SECURECAR_USUARIO set DS_GENERO = ?, DS_SENHA = ?, NM_USUARIO = " +
                "?" +
                " where " +
                "ID_usuario = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, usuario.getGenero());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNomeUsuario());
            ps.setLong(4, usuario.getIdUsuario());

            if (ps.executeUpdate() > 0){
                return usuario;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }



}
