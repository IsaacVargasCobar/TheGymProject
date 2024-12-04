package models;

public class ModelSede {
    private String id;
    private String provincia;
    private String canton;
    private String email;
    private String telefono;
    private ModelEmpleado empleado;
    private int empleado_id;

    public ModelSede(String provincia, String canton, String email, String telefono) {
        this.provincia = provincia;
        this.canton = canton;
        this.email = email;
        this.telefono = telefono;
        this.empleado = empleado;
        this.empleado_id = empleado_id;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ModelEmpleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(ModelEmpleado empleado) {
        this.empleado = empleado;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    @Override
    public String toString() {
        return "ModelSede{" +
                "id='" + id + '\'' +
                ", provincia='" + provincia + '\'' +
                ", canton='" + canton + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
