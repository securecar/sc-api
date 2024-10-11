package com.securecar.dao;

import com.securecar.to.UsuarioTO;

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
                    usuario.setDataCriacaoConta(rs.getDate("dd_criacao_conta").toLocalDate());
                    usuario.setIdDados(rs.getLong("id_dados_gerais"));
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

}
