package models;

public class ModelEmpleado {

    protected String id;
    protected String nombre;
    protected String estado;
    protected String apellido;
    protected String fechaNacimiento;
    protected String salario;
    protected String puesto;

    public ModelEmpleado(String nombre, String estado, String apellido, String fechaNacimiento, String salario, String puesto) {
        this.nombre = nombre;
        this.estado = estado;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.puesto = puesto;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "ModelEmpleado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", salario='" + salario + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}
