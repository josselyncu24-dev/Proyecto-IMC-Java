import java.time.LocalDate;

public class Persona {

    private String nombreC;
    private LocalDate fechaN;
    private double peso;
    private double altura;
    private String direccion;
    private String telefono;
    private String correo;

    public Persona() {

    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public LocalDate getFechaN() {
        return fechaN;
    }

    public void setFechaN(LocalDate fechaN) {
        this.fechaN = fechaN;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int calcularEdad() {

        LocalDate fechaActual = LocalDate.now();

        int edad = fechaActual.getYear() - fechaN.getYear();

        return edad;
    }

    public boolean esMayorEdad() {

        if (calcularEdad() >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public double calcularIMC() {

        double imc = peso / (altura * altura);

        return imc;
    }

    public String clasificarIMC() {

        double imc = calcularIMC();

        if (imc < 18.5) {
            return "Bajo peso";

        } else if (imc < 25) {
            return "Normal";

        } else if (imc < 30) {
            return "Sobrepeso";

        } else {
            return "Obesidad";
        }
    }

    public void mostrarDatos() {

        System.out.println("Nombre: " + nombreC);
        System.out.println("Fecha de nacimiento: " + fechaN);
        System.out.println("Edad: " + calcularEdad());

        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);

        System.out.println("Direccion: " + direccion);
        System.out.println("Telefono: " + telefono);
        System.out.println("Correo: " + correo);

        System.out.println("IMC: " + calcularIMC());
        System.out.println("Clasificacion: " + clasificarIMC());
    }
}