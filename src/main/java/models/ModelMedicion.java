package models;

import java.util.ArrayList;

public class ModelMedicion {
    private String id;
    private String fecha;
    private double peso;
    private double grasa;
    private double musculo;
    private double edadMetabolica;
    private double grasaVisceral;


    private ModelCliente cliente;

    public ModelMedicion(String fecha, double peso, double grasa, double musculo, double edadMetabolica, double grasaVisceral, ModelCliente cliente) {
        this.fecha = fecha;
        this.peso = peso;
        this.grasa = grasa;
        this.musculo = musculo;
        this.edadMetabolica = edadMetabolica;
        this.grasaVisceral = grasaVisceral;
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getGrasa() {
        return grasa;
    }

    public void setGrasa(double grasa) {
        this.grasa = grasa;
    }

    public double getMusculo() {
        return musculo;
    }

    public void setMusculo(double musculo) {
        this.musculo = musculo;
    }

    public double getEdadMetabolica() {
        return edadMetabolica;
    }

    public void setEdadMetabolica(double edadMetabolica) {
        this.edadMetabolica = edadMetabolica;
    }

    public double getGrasaVisceral() {
        return grasaVisceral;
    }

    public void setGrasaVisceral(double grasaVisceral) {
        this.grasaVisceral = grasaVisceral;
    }

    public ModelCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModelCliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ModelMedicion{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", peso=" + peso +
                ", grasa=" + grasa +
                ", musculo=" + musculo +
                ", edadMetabolica=" + edadMetabolica +
                ", grasaVisceral=" + grasaVisceral +
                ", cliente=" + cliente +
                '}';
    }
}
