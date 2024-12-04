package models;

public class ModelGerente extends ModelEmpleado {

    public ModelGerente(String nombre, String estado, String apellido, String fechaNacimiento, String salario, String puesto) {
        super(nombre, estado, apellido, fechaNacimiento, salario, puesto);
    }

    @Override
    public String toString() {
        return "ModelGerente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", salario='" + salario + '\'' +
                ", puesto='" + puesto + '\'' +
                "} " + super.toString();
    }
}
