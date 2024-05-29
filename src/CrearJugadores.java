import javax.swing.*;
import java.awt.event.*;

public class CrearJugadores extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField nomrbeText;
    private JTextField apellidoText;
    private JComboBox BotasBox;
    private JButton crearButton;
    private JTextField posiText;
    private JLabel Idbota;

    public static boolean crea;
    CrearJugadores(boolean crea){
        this.crea = crea;
        this.setTitle("Crear");
        this.add(panel1);
        this.setSize(500,500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        rellenarBox();
        crearButton.addActionListener(this);

    }

    private void rellenarBox() {
        BotasBox.addItem(1);
        BotasBox.addItem(2);
        BotasBox.addItem(3);
        BotasBox.addItem(4);
        BotasBox.addItem(5);
        BotasBox.addItem(6);
        BotasBox.addItem(7);
        BotasBox.addItem(8);






        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                JFrame frame = Main.buscaVentana("MostrarJugadores");
                frame.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearButton){

        }
    }
}
