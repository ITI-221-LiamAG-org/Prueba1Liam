import java.util.ArrayList;
import java.util.Scanner;

//====================== PERSONA ======================

class Persona{

    protected int cedula;
    protected String nombre;
    protected String email;
    protected String direccion;
    protected int telefono;
    protected byte edad;

    public Persona(int cedula,String nombre,String email,
                   String direccion,int telefono,byte edad){

        this.cedula=cedula;
        this.nombre=nombre;
        this.email=email;
        this.direccion=direccion;
        this.telefono=telefono;
        this.edad=edad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCedula(){
        return cedula;
    }

    public String mostrarDatos(){

        return "Cedula: "+cedula+
                "\nNombre: "+nombre+
                "\nEdad: "+edad+
                "\nTelefono: "+telefono+
                "\nEmail: "+email+
                "\nDireccion: "+direccion;
    }

}

//====================== EXPEDIENTE ======================

class Expediente{

    private int codigo;
    private String historial;
    private String alergias;

    public Expediente(int codigo,String historial,String alergias){

        this.codigo=codigo;
        this.historial=historial;
        this.alergias=alergias;
    }

    @Override
    public String toString(){

        return "Codigo: "+codigo+
                "\nHistorial: "+historial+
                "\nAlergias: "+alergias;
    }

}

//====================== PACIENTE ======================

class Paciente extends Persona{

    private boolean asegurado;
    private Expediente expediente;

    public Paciente(int cedula,String nombre,String email,
                    String direccion,int telefono,byte edad,
                    boolean asegurado,
                    Expediente expediente){

        super(cedula,nombre,email,direccion,telefono,edad);

        this.asegurado=asegurado;
        this.expediente=expediente;
    }

    public boolean isAsegurado(){

        return asegurado;

    }

    @Override
    public String mostrarDatos(){

        return super.mostrarDatos()+
                "\nAsegurado: "+asegurado+
                "\n"+expediente;
    }

}

//====================== MEDICO ======================

class Medico extends Persona{

    private String especialidad;
    private double salario;

    public Medico(int cedula,String nombre,String email,
                  String direccion,int telefono,byte edad,
                  String especialidad,double salario){

        super(cedula,nombre,email,direccion,telefono,edad);

        this.especialidad=especialidad;
        this.salario=salario;
    }

    public String getEspecialidad(){

        return especialidad;

    }

    public double getSalario(){

        return salario;

    }

    @Override
    public String mostrarDatos(){

        return super.mostrarDatos()+
                "\nEspecialidad: "+especialidad+
                "\nSalario: ₡"+salario;
    }

}

//====================== DESPACHO ======================

class Despacho{

    private int numero;
    private boolean disponible;

    public Despacho(int numero,boolean disponible){

        this.numero=numero;
        this.disponible=disponible;

    }

    @Override
    public String toString(){

        return "Despacho #"+numero+
                " Disponible: "+disponible;
    }

}

//====================== FACTURA ======================

class Factura{

    private int numero;
    private double monto;

    public Factura(int numero,double monto){

        this.numero=numero;
        this.monto=monto;

    }

    @Override
    public String toString(){

        return "Factura #"+numero+
                "  Monto: ₡"+monto;
    }

}

//====================== CITA ======================

class Cita{

    private int codigo;
    private String fecha;
    private char estado;

    private Paciente paciente;
    private Medico medico;

    public Cita(int codigo,String fecha,
                Paciente paciente,
                Medico medico){

        this.codigo=codigo;
        this.fecha=fecha;
        this.paciente=paciente;
        this.medico=medico;

        estado='P';
    }

    public void cambiarEstado(char nuevo){

        estado=Character.toUpperCase(nuevo);

    }

    public char getEstado(){

        return estado;

    }

    public Paciente getPaciente(){

        return paciente;

    }

    public Medico getMedico(){

        return medico;

    }

    public String mostrarCita(){

        return "\nCodigo: "+codigo+
                "\nFecha: "+fecha+
                "\nPaciente: "+paciente.getNombre()+
                "\nMedico: "+medico.getNombre()+
                "\nEstado: "+estado;
    }

}
//====================== CLINICA ======================

class Clinica{

    private String nombre;
    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Cita> citas;

    public Clinica(String nombre){

        this.nombre=nombre;

        medicos=new ArrayList<>();
        pacientes=new ArrayList<>();
        citas=new ArrayList<>();

    }

    public void agregarMedico(Medico m){

        medicos.add(m);

    }

    public void agregarPaciente(Paciente p){

        pacientes.add(p);

    }

    public void agregarCita(Cita c){

        citas.add(c);

    }

    public void listarMedicos(){

        for(Medico m:medicos){

            System.out.println("\n----------------");
            System.out.println(m.mostrarDatos());

        }

    }

    public void listarPacientes(){

        for(Paciente p:pacientes){

            System.out.println("\n----------------");
            System.out.println(p.mostrarDatos());

        }

    }

    public void listarCitas(){

        for(int i=0;i<citas.size();i++){

            System.out.println("\nIndice: "+i);
            System.out.println(citas.get(i).mostrarCita());

        }

    }

    public void buscarPaciente(String nombre){

        boolean encontrado=false;

        for(Paciente p:pacientes){

            if(p.getNombre().equalsIgnoreCase(nombre)){

                System.out.println(p.mostrarDatos());
                encontrado=true;

            }

        }

        if(!encontrado){

            System.out.println("Paciente no encontrado.");

        }

    }

    public void cambiarEstado(int indice,char estado){

        if(indice>=0 && indice<citas.size()){

            Cita c=citas.get(indice);

            c.cambiarEstado(estado);

            switch(estado){

                case 'P':
                    System.out.println("Cita Programada");
                    break;

                case 'R':
                    System.out.println("Cita Reprogramada");
                    break;

                case 'C':
                    System.out.println("Cita Cancelada");
                    break;

                case 'T':
                    System.out.println("Cita Terminada");
                    break;

                case 'F':
                    System.out.println("Cita Facturada");
                    break;

                default:
                    System.out.println("Estado incorrecto");

            }

            if(c.getPaciente().isAsegurado()){

                System.out.println("Paciente ASEGURADO.");

            }else{

                System.out.println("Paciente NO asegurado.");

            }

        }else{

            System.out.println("Indice incorrecto.");

        }

    }

    public void boletaPago(){

        for(Medico m:medicos){

            System.out.println("---------------------");
            System.out.println("Medico: "+m.getNombre());
            System.out.println("Especialidad: "+m.getEspecialidad());
            System.out.println("Pago: ₡"+m.getSalario());

        }

    }

}


//====================== PRINCIPAL ======================

 class ExamenLenen{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        Clinica clinica=new Clinica("Clinica Puntarenas");


        Expediente e1=new Expediente(1,"Gripe","Ninguna");
        Expediente e2=new Expediente(2,"Dolor Dental","Penicilina");


        Paciente p1=new Paciente(
                111,
                "Ana",
                "ana@gmail.com",
                "Barranca",
                88881111,
                (byte)25,
                true,
                e1);

        Paciente p2=new Paciente(
                222,
                "Luis",
                "luis@gmail.com",
                "Chacarita",
                88882222,
                (byte)35,
                false,
                e2);


        Medico m1=new Medico(
                100,
                "Dr Perez",
                "perez@gmail.com",
                "Hospital",
                88883333,
                (byte)45,
                "Oftalmologia",
                1500);

        Medico m2=new Medico(
                200,
                "Dra Gomez",
                "gomez@gmail.com",
                "Hospital",
                88884444,
                (byte)40,
                "Odontologia",
                1700);


        clinica.agregarPaciente(p1);
        clinica.agregarPaciente(p2);

        clinica.agregarMedico(m1);
        clinica.agregarMedico(m2);


        clinica.agregarCita(new Cita(1,"20/06/2026 8:00",p1,m1));
        clinica.agregarCita(new Cita(2,"20/06/2026 10:00",p2,m2));


        int opcion;

        do{

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Mostrar medicos");
            System.out.println("2. Mostrar pacientes");
            System.out.println("3. Mostrar citas");
            System.out.println("4. Buscar paciente");
            System.out.println("5. Cambiar estado cita");
            System.out.println("6. Boleta de pago");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion=sc.nextInt();
            sc.nextLine();

            switch(opcion){

                case 1:

                    clinica.listarMedicos();
                    break;

                case 2:

                    clinica.listarPacientes();
                    break;

                case 3:

                    clinica.listarCitas();
                    break;

                case 4:

                    System.out.print("Nombre del paciente: ");
                    String nombre=sc.nextLine();

                    clinica.buscarPaciente(nombre);

                    break;

                case 5:

                    clinica.listarCitas();

                    System.out.print("Indice: ");
                    int indice=sc.nextInt();

                    System.out.print("Estado (P,R,C,T,F): ");
                    char estado=sc.next().toUpperCase().charAt(0);

                    clinica.cambiarEstado(indice,estado);

                    break;

                case 6:

                    clinica.boletaPago();

                    break;

                case 0:

                    System.out.println("Programa finalizado.");
                    break;

                default:

                    System.out.println("Opcion invalida.");

            }

        }while(opcion!=0);

    }

}