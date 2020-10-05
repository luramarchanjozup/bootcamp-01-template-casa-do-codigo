package com.guiferrini.CasaCodigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//postgresqltutorial.com

public class App{

    private final String url = "jdbc:postgresql://localhost/";
    private final String user = "postgres";
    private final String password = "laika123";

    //Conectando ao POstgresql - retorna se conectou
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.connect();
    }
}
