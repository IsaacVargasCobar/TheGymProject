package models;

public class ModelFactura {
  private String id;
  private ModelCliente cliente;
  private double monto;
  private final double IVA = 0*13;
  private String descripcion;
  private String emisor;


    public ModelFactura(ModelCliente cliente, double monto, String descripcion, String emisor) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.emisor = emisor;
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ModelCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModelCliente cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getIVA() {
        return IVA;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    @Override
    public String toString() {
        return "ModelFactura{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", monto=" + monto +
                ", IVA=" + IVA +
                ", descripcion='" + descripcion + '\'' +
                ", emisor='" + emisor + '\'' +
                '}';
    }
}
