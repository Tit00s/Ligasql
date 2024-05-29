public class Jugador {

    int idJugador;
    String nombre;
    String apellido;
    String posicion;
    int id_bota;

    public Jugador(int idJugador, String nombre, String apellido, String posicion, int id_Bota) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.id_bota = id_Bota;
    }

    public String insert(){
        return "INSERT INTO JUGADORES VALUES("+idJugador+",'"+nombre+"','"+apellido+"','"+posicion+"',"+id_bota+")";
    }
    public String update(){
        return "UUPDATE JUGADORES VALUES("+idJugador+",'"+nombre+"','"+apellido+"','"+posicion+"',"+id_bota+")"+"WHERE"+idJugador+"="+idJugador;
    }


    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getId_bota() {
        return id_bota;
    }

    public void setId_bota(int id_bota) {
        this.id_bota = id_bota;
    }



}
