package models;

public class ModelRutina {

    private String id;
    private String ejercicio;
    private String zonaMuscular;
    private String sets;
    private String repeticiones;

    public ModelRutina(String ejercicio, String zonaMuscular, String sets, String repeticiones) {
        this.ejercicio = ejercicio;
        this.zonaMuscular = zonaMuscular;
        this.sets = sets;
        this.repeticiones = repeticiones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getZonaMuscular() {
        return zonaMuscular;
    }

    public void setZonaMuscular(String zonaMuscular) {
        this.zonaMuscular = zonaMuscular;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public String toString() {
        return "ModelRutina{" +
                "id='" + id + '\'' +
                ", ejercicio='" + ejercicio + '\'' +
                ", zonaMuscular='" + zonaMuscular + '\'' +
                ", sets='" + sets + '\'' +
                ", repeticiones='" + repeticiones + '\'' +
                '}';
    }
}
