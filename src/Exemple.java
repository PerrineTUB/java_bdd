import javax.swing.*;
import java.awt.*;

public class Exemple extends JDialog{
    private JTextField tfNom;
    private JTextField tfPrenom;
    private JTextField tfMail;
    private JTextField tfPassword;
    private JPanel JPMain;
    private JLabel jlNom;
    private JLabel jlPrenom;
    private JLabel jlMail;
    private JLabel jlPsw;
    private JButton Valider;

    public Exemple(JDialog parent){
        super(parent);
        setTitle("Test");
        setContentPane(JPMain);
        setMinimumSize(new Dimension(300,350));
        setModal(false);
        setVisible(true);
    }
}
