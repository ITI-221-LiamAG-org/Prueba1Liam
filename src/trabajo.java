import java.time.LocalDate;
import java.time.LocalTime;

class Anfiteatro {
    private String nombre;
    private int capacidad;

    public Anfiteatro() {
        this.nombre = "Anfiteatro 1";
        this.capacidad = 6350;
    }

    public Anfiteatro(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }
}


class artista {
    private String nombre;
    private  String genero;

    public  artista(){
        nombre=null;
        genero= "desconocido";
    }
    public artista(String nombre, String genero){
        this.nombre= nombre;
        this.genero=genero;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setGenero(String genero){
        this.genero=genero;
    }

    public String getNombre(){
        return nombre;

    }
    public String getGenero(){

        return genero;
    }
    public void mostrar_artista(){
        System.out.println("artista:" + nombre);
        System.out.println("genero de musica: "+ genero);
    }

}







 class Boleto {
    private Evento evento;
    private Cliente cliente;
    private String sector;
    private int asiento;

    public Boleto() {
        this.evento = new Evento();
        this.cliente = new Cliente();
        this.sector = "500";
        this.asiento = 1;
    }

    public Boleto(Evento evento, Cliente cliente, String sector, int asiento) {
        this.evento = evento;
        this.cliente = cliente;
        this.sector = sector;
        this.asiento = asiento;
    }

    public Evento getEvento() {
        return evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getSector() {
        return sector;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
}









class Cliente {
    private String nombre;
    private String ced;
    private LocalDate fecha_naci;

    public Cliente() {
        nombre = "desconocido";
        ced = "11112222";
        fecha_naci = LocalDate.of(2026, 03, 20);
    }

    public Cliente(String nombre, String ced, LocalDate fecha_naci) {
        this.nombre = nombre;
        this.ced = ced;
        this.fecha_naci = fecha_naci;

    }
    public void setNombre(String nombre) {
        this.nombre=nombre;

    }
    public String getNombre(){
        return nombre;
    }
    public void setCed( String ced){
        this.ced=ced;
    }
    public void setFecha_naci(LocalDate fecha_naci){
        this.fecha_naci=fecha_naci;
    }
    public String getCed(){
        return ced;
    }
    public LocalDate getFecha_naci(){
        return fecha_naci;
    }
}





class Evento {
    private LocalDate Fecha;
    private LocalTime H_Inicio;
    private LocalTime H_Fin;
    private artista artista;
    private Empresa empresa;
    private Anfiteatro anfiteatro;


    public Evento() {
        this.artista = new artista();
        this.empresa = new Empresa();
        this.anfiteatro= new Anfiteatro();
        this.Fecha = LocalDate.of(2000, 10, 10);
        this.H_Inicio = LocalTime.of(12, 59);
        this.H_Fin = LocalTime.of(12, 59);


    }

    public Evento(artista artista, Empresa empresa, LocalDate Fecha, LocalTime H_Inicio, LocalTime H_Fin,  Anfiteatro anfiteatro) {
        this.artista = artista;
        this.empresa = empresa;
        this.Fecha = Fecha;
        this.H_Inicio = H_Inicio;
        this.H_Fin = H_Fin;
        this.anfiteatro=anfiteatro;
    }

    public void setArtista(artista artista) {
        this.artista = artista;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setAnfiteatro( Anfiteatro anfiteatro){ this.anfiteatro=anfiteatro;}
    public void setFecha(LocalDate fecha) {
        this.Fecha = fecha;
    }

    public void setH_Inicio(LocalTime h_Inicio) {
        this.H_Inicio = h_Inicio;
    }

    public void setH_Fin(LocalTime h_Fin) {
        this.H_Fin = h_Fin;
    }

    public artista getartista() {
        return artista;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public LocalTime getH_Fin() {
        return H_Fin;
    }

    public LocalTime getH_Inicio() {
        return H_Inicio;
    }

    public Anfiteatro getAnfiteatro() {
        return anfiteatro;
    }
}






class Empresa {

    private String nombre;
    private String telefono;
    private String correo;

    public Empresa() {
        nombre = "desconocido";
        telefono = "111-222-333";
        correo = "ejem@empresa.com";
    }

    public Empresa(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getcorreo() {
        return correo;
    }
}









class principal {

    public static void main(String[] args) {

        artista a = new artista("Queen", "Rock");

        Empresa e = new Empresa(
                "Live Nation",
                "2222-2222",
                "info@live.com");

        Anfiteatro an = new Anfiteatro(
                "Anfiteatro 1",
                6350);

        Evento evento = new Evento(
                a,
                e,
                LocalDate.of(2026, 8, 15),
                LocalTime.of(19, 0),
                LocalTime.of(22, 0),
                an);

        Cliente cliente = new Cliente(
                "Luis",
                "123456789",
                LocalDate.of(2000, 5, 10));

        Boleto boleto = new Boleto(
                evento,
                cliente,
                "Golden Circle",
                120);

        System.out.println("Artista: " +
                boleto.getEvento().getartista().getNombre());

        System.out.println("Cliente: " +
                boleto.getCliente().getNombre());

        System.out.println("Sector: " +
                boleto.getSector());

        System.out.println("Asiento: " +
                boleto.getAsiento());
    }


}

