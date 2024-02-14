package com.java_sql.model;
import com.java_sql.model.Env;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.java_sql.model.Env.*;

public class DbConnexion {
    //Attribut paramètre BDD
    //Connexion à la BDD
    private static Connection connexion;
    static {
        try {
            connexion = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnexion(){
        return connexion;
    }
}
