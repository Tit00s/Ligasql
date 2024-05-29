import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConcetar extends JFrame  implements ActionListener {
    private JButton concetarBot;
    private JTextField ipText ;
    private JTextField puertoText;
    private JTextField bdText;
    private JTextField userText;
    private JTextField contraText;
    private JPanel Panel1;

    VentanaConcetar() {
        ipText.setText("localhost");
        puertoText.setText("5432");
        bdText.setText("Liga");
        userText.setText("postgres");
        contraText.setText("Perez2005");//contraseña de casa, en el insti es 1234

        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("Concetar a Base de Datos");
        this.add(Panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        concetarBot.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == concetarBot) {
            Concentar.ip = ipText.getText();
            Concentar.puerto = puertoText.getText();
            Concentar.bd = bdText.getText();
            Concentar.user = userText.getText();
            Concentar.pass = contraText.getText();
            if (Concentar.connectDatabase(true)){
                mostrarMensaje("Base de datos conectada Correctamente","INFO");
                VentantaMostrarJug ven = new VentantaMostrarJug();
                Main.AñadeVentanas(ven);
                ven.setVisible(true);
                this.dispose();
            }else {
                mostrarMensaje("Base de datos NO concetada, revise los campos","INFO");
            }
        }
    }

    protected void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo ,JOptionPane.INFORMATION_MESSAGE );

    }
}