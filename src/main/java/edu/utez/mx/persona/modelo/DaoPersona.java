package edu.utez.mx.persona.modelo;
import edu.utez.mx.persona.utils.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPersona {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanPersona> findAll() {
        List<BeanPersona> personas = new ArrayList<>();
        BeanPersona persona = null;

        try {
            conn = new mysql().getConnection();
            String query = "SELECT * FROM persona";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                persona = new BeanPersona();
                persona.setId(rs.getLong("id"));
                persona.setName(rs.getString("name"));
                persona.setSurname(rs.getString("surname"));
                persona.setCurp(rs.getString("curp"));
                persona.setBirthday(rs.getString("birthday"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return personas;
    }

    public boolean save(BeanPersona persona) {
        try {
            conn = new mysql().getConnection();
            String query = "INSERT INTO `persona`( `name`, `surname`, `curp`, `birthday`) " +
                    "VALUES (?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, persona.getName());
            pstm.setString(2,persona.getSurname());
            pstm.setString(3,persona.getCurp());
            pstm.setString(4,persona.getBirthday());
            System.out.println(query);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean update(BeanPersona persona) {
        try {
            conn = new mysql().getConnection();
            String query = "UPDATE `persona` SET `name`=?,`surname`=?,`curp`=?,`birthday`=? WHERE id=?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, persona.getName());
            pstm.setString(2,persona.getSurname());
            pstm.setString(3,persona.getCurp());
            pstm.setString(4,persona.getBirthday());
            pstm.setLong(5,persona.getId());

            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean delete(Long id) {
        try {
            conn = new mysql().getConnection();
            String query = "DELETE FROM `persona` WHERE persona.id= ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public BeanPersona findOne(Long id) {
        try {
            conn = new mysql().getConnection();
            String query = "SELECT * FROM `persona` WHERE persona.id= ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                BeanPersona persona = new BeanPersona();
                persona.setId(rs.getLong("id"));
                persona.setName(rs.getString("name"));
                persona.setSurname(rs.getString("surname"));
                persona.setCurp(rs.getString("curp"));
                persona.setBirthday(rs.getString("birthday"));
                return persona;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPersona.class.getName())
                    .log(Level.SEVERE, "Error save", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public void closeConnections() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (cstm != null) {
                cstm.close();
            }
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {

        }
    }

}

