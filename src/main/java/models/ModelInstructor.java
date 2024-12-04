package models;

public class ModelInstructor extends ModelEmpleado{

private String certificado;
private ModelCliente cliente;
private  ModelRutina rutina;

    public ModelInstructor(String nombre, String estado, String apellido, String fechaNacimiento, String salario, String puesto, String certificado, ModelCliente cliente, ModelRutina rutina) {
        super(nombre, estado, apellido, fechaNacimiento, salario, puesto);
        this.certificado = certificado;
        this.rutina = rutina;
        this.cliente = cliente;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public ModelCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModelCliente cliente) {
        this.cliente = cliente;
    }

    public ModelRutina getRutina() {
        return rutina;
    }

    public void setRutina(ModelRutina rutina) {
        this.rutina = rutina;
    }

    @Override
    public String toString() {
        return "ModelInstructor{" +
                "certificado='" + certificado + '\'' +
                ", cliente=" + cliente +
                ", rutina=" + rutina +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", salario='" + salario + '\'' +
                ", puesto='" + puesto + '\'' +
                "} " + super.toString();
    }
}

