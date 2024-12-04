package models;

public class ModelGimnasio {
    private String id;
    private String telefono;
    private String email;
    private  ModelSede sede;


    public ModelGimnasio(String telefono, String email, ModelSede sede) {
        this.telefono = telefono;
        this.email = email;
        this.sede = sede;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ModelSede getSede() {
        return sede;
    }

    public void setSede(ModelSede sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "ModelGimnasio{" +
                "id='" + id + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", sede=" + sede +
                '}';
    }
}
