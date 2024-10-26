package com.securecar.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensagemDAO extends Repository {
    public ArrayList<MensagemTO> findAll(){
        ArrayList<MensagemTO> mensagens = new ArrayList<>();
        String sql = "select * from t_securecar_mensagem";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while(rs.next()) {
                    MensagemTO mensagem = new MensagemTO();
                    mensagem.setIdConversa(rs.getLong("id_conversa"));
                    mensagem.setIdMensagem(rs.getLong("id_mensagem"));
                    mensagem.setTipoMensagem(rs.getInt("tp_mensagem"));
                    mensagem.setTextoMensagem(rs.getString("tx_mensagem"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e.getMessage());
        } finally {
            closeConnection();
        }
        return mensagens;
    }

    public MensagemTO findById(Long id){
        String sql = "select * from t_securecar_mensagem where id_mensagem = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                MensagemTO mensagem = new MensagemTO();
                mensagem.setIdConversa(rs.getLong("id_conversa"));
                mensagem.setIdMensagem(rs.getLong("id_mensagem"));
                mensagem.setTipoMensagem(rs.getInt("tp_mensagem"));
                mensagem.setTextoMensagem(rs.getString("tx_mensagem"));
                return mensagem;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public MensagemTO save(MensagemTO mensagem){
        String sql = "insert into t_securecar_mensagem (ID_MENSAGEM, TP_MENSAGEM, TX_MENSAGEM) values (?, ? ,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, mensagem.getIdConversa());
            ps.setInt(2, mensagem.getTipoMensagem());
            ps.setString(3, mensagem.getTextoMensagem());
            if (ps.executeUpdate() > 0) {
                return mensagem;
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql" + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo) {
        String sql = "delete T_SECURECAR_MENSAGEM where ID_MENSAGEM = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao Deletar! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public MensagemTO edit(Long id, MensagemTO mensagem){
        String sql = "update T_SECURECAR_MENSAGEM set TP_MENSAGEM = ?, TX_MENSAGEM = ? where ID_MENSAGEM = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.setInt(2, mensagem.getTipoMensagem());
            ps.setString(3, mensagem.getTextoMensagem());
        } catch (SQLException e) {
            System.out.println("Erro ao editar! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
