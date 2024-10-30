package com.securecar.dao;

import com.securecar.to.EnderecoTO;
import com.securecar.to.EnderecoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoDAO extends Repository{
    public ArrayList<EnderecoTO> findAll(){
        ArrayList<EnderecoTO> enderecos = new ArrayList<>();
        String sql = "select * from t_securecar_endereco order by ID_ENDERECO";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    EnderecoTO endereco = new EnderecoTO();
                    endereco.setIdEndereco(rs.getLong("id_endereco"));
                    endereco.setCep(rs.getString("nr_cep"));
                    endereco.setNomeLogradouro(rs.getString("nm_logradouro"));
                    endereco.setNumeroLogradouro(rs.getInt("nr_logradouro"));
                    endereco.setComplemento(rs.getString("cp_logradouro"));
                    endereco.setBairro(rs.getString("nm_bairro"));
                    endereco.setCidade(rs.getString("nm_cidade"));
                    endereco.setUf(rs.getString("nm_uf"));
                    enderecos.add(endereco);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return enderecos;
    }

    public EnderecoTO findById(Long id){
        String sql = "select * from t_securecar_endereco where id_endereco = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                EnderecoTO endereco = new EnderecoTO();
                endereco.setCep(rs.getString("nr_cep"));
                endereco.setNomeLogradouro(rs.getString("nm_logradouro"));
                endereco.setNumeroLogradouro(rs.getInt("nr_logradouro"));
                endereco.setComplemento(rs.getString("cp_logradouro"));
                endereco.setBairro(rs.getString("nm_bairro"));
                endereco.setCidade(rs.getString("nm_cidade"));
                endereco.setIdEndereco(rs.getLong("id_endereco"));
                endereco.setUf("nm_uf");
                return endereco;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public EnderecoTO save(EnderecoTO endereco){
        String sql = "insert into t_securecar_endereco (NR_CEP, NM_LOGRADOURO, NR_LOGRADOURO, CP_LOGRADOURO, " +
                "NM_BAIRRO, NM_UF, NM_CIDADE) values (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql,new String[]{"ID_ENDERECO"})){
            ps.setString(1, endereco.getCep());
            ps.setString(2, endereco.getNomeLogradouro());
            ps.setInt(3, endereco.getNumeroLogradouro());
            ps.setString(4, endereco.getComplemento());
            ps.setString(5, endereco.getBairro());
            ps.setString(6, endereco.getUf());
            ps.setString(7, endereco.getCidade());


            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        endereco.setIdEndereco(rs.getLong(1));
                    }
                }
                return endereco;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_endereco where ID_endereco = ?";
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

    public EnderecoTO update(EnderecoTO endereco){
        String sql = "update T_SECURECAR_endereco set NM_LOGRADOURO=?, NR_LOGRADOURO=?, CP_LOGRADOURO=?, NM_BAIRRO=?," +
                "NM_CIDADE=?, nm_uf = ? where ID_endereco = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, endereco.getNomeLogradouro());
            ps.setInt(2, endereco.getNumeroLogradouro());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getUf());
            ps.setLong(7, endereco.getIdEndereco());
            if (ps.executeUpdate() > 0){
                return endereco;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
