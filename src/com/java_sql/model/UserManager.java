package com.java_sql.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserManager {
    private static Connection connexion = DbConnexion.getConnexion();

    public static User addUser(User user) {
        //instancier un Objet User null
        User userAdd = new User();
        try {
            //connexion
            Statement smt = connexion.createStatement();
            //Requête
            String req = "INSERT INTO users(nom, prenom, email, password) VALUE (?,?,?,?)";
            //Préparer la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(req);
            //Bind des paramètres
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            //Execution de la requête
            int addedRows = preparedStatement.executeUpdate();
            //Tester si la requête est passée
            if (addedRows > 0){
                //injecter les valeurs dans l'objet de sortie
                userAdd.setNom(user.getNom());
                userAdd.setPrenom(user.getPrenom());
                userAdd.setEmail(user.getEmail());
                userAdd.setPassword(user.getPassword());
            }
            //Fermeture de la connexion à la BDD
            smt.close();
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("L'utilisateur " + userAdd.nom + " " + userAdd.prenom + " à bien été ajouté.");
        return userAdd;
    }

    public static User getUserByMail (User user){
        User userSelect = null;
        try {
            Statement smt = connexion.createStatement();
            String req = "SELECT id, nom, prenom, email, password FROM users WHERE email = ? ";
            PreparedStatement preparedStatement = connexion.prepareStatement(req);
            preparedStatement.setString(1, user.getEmail());

            ResultSet rs = preparedStatement.executeQuery();
            //Parcours du résultat
            while(rs.next()){
                //Si la réponse est différente de null
                if (rs.getString(1)!= null){
                    userSelect = new User();
                    userSelect.setId(Integer.parseInt(rs.getString("id")));
                    userSelect.setNom(rs.getString("nom"));
                    userSelect.setPrenom(rs.getString("prenom"));
                    userSelect.setEmail(rs.getString("email"));
                    userSelect.setPassword(rs.getString("password"));
                }
            }

            smt.close();
            connexion.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return userSelect;
    }

    public static User udpateUser (User user){
        User userUpdate = getUserByMail(user);

        try {
            connexion = DbConnexion.getConnexion();

            String req = "UPDATE users SET nom=?, prenom=?, email=?, password=? WHERE id=?";
            PreparedStatement preparedStatement = connexion.prepareStatement(req);

            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId());

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows > 0) {
                userUpdate = user;
            }

            preparedStatement.close();
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("L'utilisateur " + userUpdate.nom + " " + userUpdate.prenom + " à bien été modifié");
        return userUpdate;
    }

    public static User deleteUserByMail(User user){
        User userDelete = null;

        try {
            connexion = DbConnexion.getConnexion();

            String req = "DELETE FROM users WHERE email=?";
            PreparedStatement preparedStatement = connexion.prepareStatement(req);

            preparedStatement.setString(1, user.getEmail());

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows > 0) {
                userDelete = user;
            }

            preparedStatement.close();
            connexion.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("L'utilisateur " + userDelete.nom + " " + userDelete.prenom + " à bien été supprimé.");
        return userDelete;
    }


}

