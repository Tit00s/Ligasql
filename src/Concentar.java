import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  java.sql.*;

public class Concentar {

    public static String ip;
    public static String puerto;
    public static String bd;
    public static String user;
    public static String pass;

    public static Connection connection;


   public static boolean connectDatabase(boolean cerrar){



       String url;
       boolean valid = false;
       try {


           Class.forName("org.postgresql.Driver");  //El driver


           url = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;
           // Database connect
           // Conectamos con la base de datos
           connection = DriverManager.getConnection(
                   url,
                   user, pass);
           valid = connection.isValid(5);
           System.out.println(valid ? "TEST OK" : "TEST FAIL");


       } catch (java.sql.SQLException sqle) {
           System.out.println("Error al conectar con la base de datos de PostgreSQL (" + ip + "): " + sqle);
       } catch (ClassNotFoundException ex) {
           System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
       }finally {
           try {
               if(cerrar && valid) {
                   connection.close();
               }

           } catch (SQLException e) {
               // TODO Auto-generated catch block
               //e.printStackTrace();
           }

       }
       return valid;


   }
   public boolean ejecutarSQL(String sql){
        connectDatabase(false);
        boolean comp;
        Statement st = null;
        try {
            st = connection.createStatement();
            comp = st.execute(sql);
            st.close();
            return comp;

        } catch (SQLException e) {
            comp = true;
            try {
                st.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return comp;
            // throw new RuntimeException(e);
        }
   }
   public static ResultSet ejecutarSelect(String sql){
       connectDatabase(false);
       ResultSet rs;
       try {
           Statement st = connection.createStatement();
           rs = st.executeQuery(sql);

       } catch (SQLException e)
       {
           return null;

           //throw new RuntimeException(e);

       }
       return rs;
   }
}



