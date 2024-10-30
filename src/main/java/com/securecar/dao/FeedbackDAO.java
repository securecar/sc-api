package com.securecar.dao;

import com.securecar.to.FeedbackTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackDAO extends Repository{
    public ArrayList<FeedbackTO> findAll(){
        ArrayList<FeedbackTO> feedbacks = new ArrayList<>();
        String sql = "select * from t_securecar_feedback";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    FeedbackTO feedback = new FeedbackTO();
                    feedback.setIdFeedback(rs.getLong("id_feedback"));
                    feedback.setComentarioFeedback(rs.getString("ds_feedback"));
                    feedback.setEstrelasFeedback(rs.getInt("vl_estrelas_feedback"));
                    feedback.setIdConserto(rs.getLong("id_conserto"));
                    feedbacks.add(feedback);
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return feedbacks;
    }

    public FeedbackTO findById(Long id){
        String sql = "select * from t_securecar_feedback where id_feedback = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                FeedbackTO feedback = new FeedbackTO();
                feedback.setIdFeedback(rs.getLong("id_feedback"));
                feedback.setComentarioFeedback(rs.getString("ds_feedback"));
                feedback.setEstrelasFeedback(rs.getInt("vl_estrelas_feedback"));
                feedback.setIdConserto(rs.getLong("id_conserto"));
                return feedback;
            }
        }
        catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ArrayList<FeedbackTO> findByIdUsuario(Long id) {
        ArrayList<FeedbackTO> feedbacks = new ArrayList<>();
        String sql = "SELECT f.* " +
                "FROM t_securecar_feedback f " +
                "JOIN t_securecar_conserto c ON f.id_conserto = c.id_conserto " +
                "JOIN t_securecar_usuario u ON c.id_usuario = u.id_usuario " +
                "WHERE u.id_usuario = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedbackTO feedback = new FeedbackTO();
                feedback.setIdFeedback(rs.getLong("id_feedback"));
                feedback.setComentarioFeedback(rs.getString("ds_feedback"));
                feedback.setEstrelasFeedback(rs.getInt("vl_estrelas_feedback"));
                feedback.setIdConserto(rs.getLong("id_conserto"));
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return feedbacks;
    }

    public FeedbackTO save(FeedbackTO feedback){
        String sql = "insert into t_securecar_feedback (DS_FEEDBACK, VL_ESTRELAS_FEEDBACK, ID_CONSERTO) values (?, ?, " +
                "?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, feedback.getComentarioFeedback());
            ps.setInt(2, feedback.getEstrelasFeedback());
            ps.setLong(3, feedback.getIdConserto());
            if (ps.executeUpdate() > 0){
                return feedback;
            }
        } catch (SQLException e){
            System.out.println("Erro de sql! " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete (Long codigo){
        String sql = "delete T_SECURECAR_feedback where ID_FEEDBACK = ?";
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

    public FeedbackTO edit(Long id, FeedbackTO feedback){
        String sql = "update T_SECURECAR_feedback set DS_FEEDBACK = ?, VL_ESTRELAS_FEEDBACK = ? where ID_FEEDBACK =" +
                " ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(3, id);
            ps.setString(1, feedback.getComentarioFeedback());
            ps.setInt(2, feedback.getEstrelasFeedback());
            feedback.setIdFeedback(id);
            if (ps.executeUpdate() > 0){
                return feedback;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
