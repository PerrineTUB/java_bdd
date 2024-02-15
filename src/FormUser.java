import com.java_sql.model.User;
import com.java_sql.model.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormUser extends JDialog{
    private JTextField tfNom;
    private JTextField tfPrenom;
    private JTextField tfMail;
    private JPasswordField tfPassword;
    private JPanel JPMain;
    private JLabel jlNom;
    private JLabel jlPrenom;
    private JLabel jlMail;
    private JLabel jlPsw;
    private JButton btAdd;

    public FormUser(JDialog parent){
        super(parent);
        setTitle("Test");
        setContentPane(JPMain);
        setMinimumSize(new Dimension(300,350));
        setModal(false);
        setVisible(true);
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User newUser = new User();
                Boolean isOk = false;

                //Vérifier si les champs sont vides
                if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty()
                        || tfMail.getText().isEmpty() || String.valueOf(tfPassword.getPassword()).isEmpty()) {
                    System.out.println("Champs manquants");
                    JOptionPane.showMessageDialog(parent,
                            "Veuillez remplir tous les champs du formulaire",
                            "Essaie encore",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                } else {

                    String textMail = tfMail.getText();

                    Pattern patternMail = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
                    Matcher matcherMail = patternMail.matcher(textMail);
                    //Vérifier si le mail est valide
                    if (matcherMail.find()) {
                        System.out.println("Mail valide");

                        //Si le mot de passe est valide
                        String textPassword = String.valueOf(tfPassword.getPassword());
                        Pattern patternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{10,20}$");
                        Matcher matcherPaswword = patternPassword.matcher(textPassword);

                        //Vérifier si le mot de passe est valide
                        if (matcherPaswword.find()){
                            System.out.println("Password valide");
                            isOk = true;
                        } else {
                            System.out.println("Password invalide");
                            JOptionPane.showMessageDialog(parent,
                                    "Le format du mot de passe n'est pas valide. Le mot de passe doit contenir : \n" +
                                            "- 12 caratères minimum, \n" +
                                            "- Des chiffres, \n" +
                                            "- Des lettres minuscules et majuscule.",
                                    "Mot de passe invalide",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                    } else {
                        System.out.println("Email invalide");
                        JOptionPane.showMessageDialog(parent,
                                "Le format de l'email n'est pas valide.",
                                "Email invalide",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                //Construction de l'objet User
                if (isOk == true){
                    newUser.setNom(tfNom.getText());
                    newUser.setPrenom(tfPrenom.getText());
                    newUser.setEmail(tfMail.getText());
                    newUser.setPassword(String.valueOf(tfPassword.getPassword()));

                    UserManager.addUser(newUser);

                    JOptionPane.showMessageDialog(parent,
                            "L'utilisateur à bien été ajouté en Bdd'",
                            "Ajout nouvel utilisateur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });
    }
}




