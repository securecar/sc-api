package com.securecar.dao;

import com.securecar.to.SeguroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeguroDAO extends Repository{
    public ArrayList<SeguroTO> findAll() {
        ArrayList<SeguroTO> seguros = new ArrayList<>();
        String sql = "select * from t_securecar_seguro order by id_seguro";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    SeguroTO seguro = new SeguroTO();
                    seguro.setIdSeguro(rs.getLong("id_seguro"));
                    seguro.setCnpj(rs.getString("nr_cnpj"));
                    seguro.setNomeSeguro(rs.getString("nm_seguro"));
                    seguro.setInscricaoEstadual(rs.getString("nr_insc_estadual")); // Corrigido para inscricaoEstadual
                    seguros.add(seguro);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler os seguros: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return seguros;
    }




    public SeguroTO findById(Long id){
        SeguroTO seguro = new SeguroTO();
        String sql = "select * from t_securecar_seguro where id_seguro = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                seguro.setIdSeguro(rs.getLong("id_seguro"));
                seguro.setCnpj(rs.getString("nr_cnpj"));
                seguro.setNomeSeguro(rs.getString("nm_seguro"));
                seguro.setInscricaoEstadual(rs.getString("nr_insc_estadual"));
            }


        } catch (SQLException e) {
            System.out.println("Erro ao ler o seguro: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return seguro;
    }

    public SeguroTO save(SeguroTO seguro){
        String sql = "insert into t_securecar_seguro (nr_cnpj,nm_seguro,nr_insc_estadual) values (?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1,seguro.getCnpj());
            ps.setString(2,seguro.getNomeSeguro());
            ps.setString(3,seguro.getInscricaoEstadual());
            if(ps.executeUpdate() > 0){
                return seguro;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar seguro: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id){
        String sql = "Delete t_securecar_seguro where id_seguro=?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
        return false;
    }

    public SeguroTO update(SeguroTO seguro){
       String sql = "update t_securecar_seguro set nr_cnpj=?,nm_seguro=?,nr_insc_estadual=? where id_seguro =?";
       try(PreparedStatement ps = getConnection().prepareStatement(sql)){
           ps.setString(1,seguro.getCnpj());
           ps.setString(2, seguro.getNomeSeguro());
           ps.setString(3,seguro.getInscricaoEstadual());
           ps.setLong(4, seguro.getIdSeguro());
           if (ps.executeUpdate() > 0){
               return seguro;
           }
       } catch (SQLException e) {
           System.out.println("Erro ao editar seguro: " + e.getMessage());
       }finally {
           closeConnection();
       }
       return null;
    }
}
