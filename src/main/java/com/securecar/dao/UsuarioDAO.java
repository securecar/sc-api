package com.securecar.dao;

import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    usuario.setCpf(rs.getLong("nr_cpf"));
                    usuario.setGenero(rs.getString("ds_genero"));
                    usuario.setSenha(rs.getString("ds_senha"));
                    usuario.setDataCriacaoConta(rs.getDate("dt_criacao_conta").toLocalDate());
                    usuario.setRg(rs.getInt("nr_rg"));
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
                usuario.setRg(rs.getInt("nr_cpf"));
                usuario.setSenha(rs.getString("ds_senha"));
                usuario.setDataCriacaoConta(rs.getDate("dt_criacao_conta").toLocalDate());
                usuario.setIdUsuario(rs.getLong("id_usuario"));
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return usuario;
    }


    public UsuarioTO save(UsuarioTO usuarioTO){
        String sql = "insert into T_SECURECAR_USUARIO (NM_USUARIO, DT_CRIACAO_CONTA, NR_CPF, DS_SENHA, DS_GENERO, " +
                "NR_RG, ID_CONTATO, ID_ENDERECO) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, usuarioTO.getNomeUsuario());
            ps.setDate(2, Date.valueOf(usuarioTO.getDataCriacaoConta()));
            ps.setLong(3, usuarioTO.getCpf());
            ps.setString(4, usuarioTO.getSenha());
            ps.setString(5, usuarioTO.getGenero());
            ps.setInt(6, usuarioTO.getRg());
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



}
