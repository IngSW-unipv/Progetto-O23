package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnessione {
    private String url = "jdbc:mysql://localhost:3306/hotel";
    private String user = "root";
    private String password = "yWosvkal$";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public Connection connessione(Connection con) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(DBConnessione.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(DBConnessione.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }

    public boolean verificaConnessione() {
        Connection con = null;
        con = connessione(con);

        try {
            return con.isValid(5);
        } catch (SQLException e) {
            Logger.getLogger(DBConnessione.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
