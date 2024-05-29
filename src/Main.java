import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private  static  ArrayList<Jugador> listaJug = new ArrayList<>();
    private  static ArrayList<JFrame> listaVen = new ArrayList<>();

    private static ArrayList<Botas> listaBot = new ArrayList<>();
    public static void main (String[] args){
        VentanaConcetar ven = new VentanaConcetar();
        ven.setVisible(true);

    }

    public static JFrame buscaVentana(String titulo){
        int i =0;
        while (i<listaVen.size()){
            if (listaVen.get(i).getTitle().equalsIgnoreCase(titulo)){
                return listaVen.get(i);
            }else{
                i++;
            }
        }
        return null;
    }

    public static void AñadeBotas(Botas b){
        listaBot.add(b);
    }


    public static void AñadeJugadores(Jugador j ){
        listaJug.add(j);
    }
    public static void AñadeVentanas(JFrame j){
        listaVen.add(j);
    }
}
