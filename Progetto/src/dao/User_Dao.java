package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utente.User;

public class User_Dao {
    private Connection conn;

    public User_Dao(Connection conn) {
        this.conn = conn;
    }

    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO user (ID_USER,CF,NOME,COGNOME,DATA_NASCITA,CELL,EMAIL,ID_CITTA,ID_PROV,ID_NAZ,ID_TIPO,USERNAME,PASSWORD) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
       	 	stmt.setInt(1, user.getId_User());
            stmt.setString(2, user.getCf());
            stmt.setString(3, user.getNome());
            stmt.setString(4, user.getCognome());
            stmt.setDate(5, user.getDataDiNascita());
            stmt.setInt(6, user.getEta());
            stmt.setString(7, user.getNumTelefono());
            stmt.setString(8, user.getEmail());
            stmt.setInt(9, user.getId_Citta());
            stmt.setInt(10, user.getId_Prov());
            stmt.setInt(11, user.getId_Nazione());
            stmt.setInt(12, user.getId_tipo());
            stmt.setString(13, user.getUsername());
            stmt.setString(14, user.getPassword());
  
            stmt.executeUpdate();
        }
    }

    public User readUser(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                return new User(username, email, password, null, password, password, password, password);
            } else {
                return null;
            }
        }
    }

    public List<User> readAllUsers() throws SQLException {
        String sql = "SELECT * FROM users";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<User> users = new ArrayList<>();

            while (rs.next()) {
                String CF = rs.getString("CF");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String password = rs.getString("password");
                users.add(new User(CF, nome, email, null, password, password, password, password));
            }

            return users;
        }
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getCf());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    //other methods
    
}