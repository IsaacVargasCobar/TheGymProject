package models;


import java.sql.Connection;

public class ModelCliente {

    private String id;
    private String nombre;
    private String apellido;
    private String email;

    private String fechaNacimiento;
    private String estatura;
    private String sexo;
    private String altoRiesgo;
    private ModelRutina rutina;

    public ModelCliente(String nombre, String apellido, String email, String fechaNacimiento, String estatura, String sexo, String altoRiesgo, ModelRutina rutina) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.estatura = estatura;
        this.sexo = sexo;
        this.altoRiesgo = altoRiesgo;
        this.rutina = rutina;



    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getAltoRiesgo() {
        return altoRiesgo;
    }

    public void setAltoRiesgo(String altoRiesgo) {
        this.altoRiesgo = altoRiesgo;
    }

    public ModelRutina getRutina() {
        return rutina;
    }

    public void setRutina(ModelRutina rutina) {
        this.rutina = rutina;
    }

    @Override
    public String toString() {
        return "ModelCliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", estatura='" + estatura + '\'' +
                ", sexo='" + sexo + '\'' +
                ", altoRiesgo='" + altoRiesgo + '\'' +
                ", rutina=" + rutina +
                '}';
    }
}
