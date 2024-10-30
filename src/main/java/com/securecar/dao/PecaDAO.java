package com.securecar.dao;

import com.securecar.to.PecaTO;
import com.securecar.to.PecaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO extends Repository{
    public ArrayList<PecaTO> findAll(){
        ArrayList<PecaTO> resultado = new ArrayList<>();
        String sql = "SELECT * FROM t_securecar_peca";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs!=null){
                while(rs.next()){
                    PecaTO peca = new PecaTO();
                    peca.setIdPeca(rs.getLong(1));
                    peca.setValorPeca(rs.getDouble("vl_peca"));
                    peca.setQuantidadePeca(rs.getInt("qt_peca"));
                    peca.setDescricaoPeca(rs.getString("ds_peca"));
                    resultado.add(peca);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return resultado;
    }

    public PecaTO findById(Long id){
        String sql = "SELECT * FROM t_securecar_peca where id_peca = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                PecaTO peca = new PecaTO();
                peca.setIdPeca(rs.getLong("id_peca"));
                peca.setDescricaoPeca(rs.getString("ds_peca"));
                peca.setQuantidadePeca(rs.getInt("qt_peca"));
                peca.setValorPeca(rs.getDouble("vl_peca"));
                return peca;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ArrayList<PecaTO> findAllByIdConserto(Long idConserto){
        ArrayList<PecaTO> resultado = new ArrayList<>();
        String sql = "select b.ID_PECA, b.vl_peca,b.ds_peca from t_securecar_peca_conserto a inner " +
                "join " +
                "t_securecar_peca b " +
                "on (a.id_peca = b.id_peca) where a.id_conserto = ? order by b.ID_PECA";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, idConserto);
            ResultSet rs = ps.executeQuery();
            if (rs!=null){
                while(rs.next()){
                    PecaTO peca = new PecaTO();
                    peca.setIdPeca(rs.getLong(1));
                    peca.setValorPeca(rs.getDouble("vl_peca"));
                    peca.setDescricaoPeca(rs.getString("ds_peca"));
                    resultado.add(peca);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return resultado;
    }

    public PecaTO save(PecaTO pecaTO){
        String sql = "INSERT INTO t_securecar_peca(VL_PECA, DS_PECA, QT_PECA) values (?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDouble(1, pecaTO.getValorPeca());
            ps.setString(2, pecaTO.getDescricaoPeca());
            ps.setInt(3, pecaTO.getQuantidadePeca());
            if (ps.executeUpdate() > 0){
                return pecaTO;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_PECA where ID_PECA = ?";
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

    public PecaTO update(PecaTO peca){
        String sql = "update T_SECURECAR_peca set DS_PECA = ?, QT_PECA = ?, VL_PECA = ? where ID_PECA = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(4, peca.getIdPeca());
            ps.setString(1, peca.getDescricaoPeca());
            ps.setInt(2, peca.getQuantidadePeca());
            ps.setDouble(3, peca.getValorPeca());
            if (ps.executeUpdate() > 0){
                return peca;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
