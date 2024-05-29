import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentantaMostrarJug extends JFrame {
    private JPanel panel1;
    private JTable table1;

    DefaultTableModel modelo = new DefaultTableModel();
    VentantaMostrarJug(){
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem crear = new JMenuItem("Crear");
        JMenuItem borrar = new JMenuItem("borrar");
        JMenuItem eliminar = new JMenuItem("Eliminar");
        menu.add(crear);
        menu.add(borrar);
        menu.add(eliminar);

        bar.add(menu);
        this.setJMenuBar(bar);



        this.setTitle("MostrarJugadores");
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Posicion");
        modelo.addColumn("ID_bota");
        table1.setModel(modelo);
        this.add(panel1);

        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        AñadeJugadores();
        AñadeBotas();

        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = Main.buscaVentana("Crear");
                if ( frame  == null){
                    CrearJugadores c = new CrearJugadores(true);
                    Main.AñadeVentanas(c);
                    c.setVisible(true);
                    setVisible(false);

                }else{
                    CrearJugadores.crea  =true;
                    frame.setVisible(true);
                    setVisible(false);
                }
            }
        });
    }

    private void AñadeBotas() {
        try {
            ResultSet rs = Concentar.ejecutarSelect("SELECT * FROM BOTA");
            while (rs.next()){
                Botas b = new Botas(rs.getInt(1),rs.getString(2),rs.getString(3));
                Main.AñadeBotas(b);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void AñadeJugadores() {
        try {
            ResultSet rs = Concentar.ejecutarSelect("Select * from jugadores");
            while (rs.next()){
                Jugador j = new Jugador(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                modelo.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)} ); //Para rellenar la tabla sin necesidad de otro metodo
                Main.AñadeJugadores(j);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
