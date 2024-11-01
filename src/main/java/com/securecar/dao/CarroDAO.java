package com.securecar.dao;

import com.securecar.to.CarroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO extends Repository{
    public ArrayList<CarroTO> findAll(){
        ArrayList<CarroTO> carros = new ArrayList<>();
        String sql = "select * from t_securecar_carro";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while(rs.next()) {
                    CarroTO carro = new CarroTO();
                    carro.setIdCarro(rs.getLong("id_carro"));
                    carro.setModelo(rs.getString("nm_modelo"));
                    carro.setAno(rs.getInt("nr_ano"));
                    carro.setPlaca(rs.getString("nr_placa"));
                    carro.setChassi(rs.getString("ds_chassi"));
                    carro.setQuilometragem(rs.getDouble("km_carro"));
                    carro.setIdUsuario(rs.getLong("id_usuario"));
                    carros.add(carro);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return carros;
    }

    public ArrayList<CarroTO> findAllByIdUsuario(Long idUsuario) {
        ArrayList<CarroTO> carros = new ArrayList<>();
        String sql = "SELECT * FROM T_SECURECAR_CARRO WHERE id_usuario = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CarroTO carro = new CarroTO();
                    carro.setIdCarro(rs.getLong("id_carro"));
                    carro.setModelo(rs.getString("nm_modelo"));
                    carro.setAno(rs.getInt("nr_ano"));
                    carro.setPlaca(rs.getString("nr_placa"));
                    carro.setChassi(rs.getString("ds_chassi"));
                    carro.setQuilometragem(rs.getDouble("km_carro"));
                    carro.setIdUsuario(rs.getLong("id_usuario"));
                    carros.add(carro);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler os carros: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return carros;
    }

    public CarroTO findById(Long id){
        String sql = "select * from t_securecar_carro where id_carro = ?";
                try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
                    ps.setLong(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()){
                        CarroTO carro = new CarroTO();
                        carro.setIdCarro(rs.getLong("id_carro"));
                        carro.setModelo(rs.getString("nm_modelo"));
                        carro.setAno(rs.getInt("nr_ano"));
                        carro.setPlaca(rs.getString("nr_placa"));
                        carro.setChassi(rs.getString("ds_chassi"));
                        carro.setQuilometragem(rs.getDouble("km_carro"));
                        carro.setIdUsuario(rs.getLong("id_usuario"));
                        return carro;
                    }
                } catch (SQLException e) {
                    System.out.println("Erro de SQL! " + e.getMessage());
                } finally {
                    closeConnection();
                }
                return null;
    }

    public CarroTO save(CarroTO carro){
        String sql = "insert into t_securecar_carro (NM_MODELO, NR_ANO, NR_PLACA, DS_CHASSI, KM_CARRO, ID_USUARIO) " +
                "values (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, carro.getModelo());
            ps.setInt(2, carro.getAno());
            ps.setString(3, carro.getPlaca());
            ps.setString(4, carro.getChassi());
            ps.setDouble(5, carro.getQuilometragem());
            ps.setLong(6, carro.getIdUsuario());
            if(ps.executeUpdate() > 0) {
                return carro;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL!" + e.getMessage());
        }
        finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete T_SECURECAR_carro where ID_CARRO = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletear! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public CarroTO update(CarroTO carro) {
        String sql = "update T_SECURECAR_carro set NM_MODELO = ?, NR_ANO = ?, DS_CHASSI = ?, KM_CARRO  = ?, ID_SEGURO" +
                " = ? where " +
                "ID_CARRO = ? ";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(6, carro.getIdCarro());
            ps.setString(1, carro.getModelo());
            ps.setInt(2, carro.getAno());
            ps.setString(3, carro.getChassi());
            ps.setDouble(4, carro.getQuilometragem());
            if(ps.executeUpdate() > 0) {
                return carro;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar!" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
