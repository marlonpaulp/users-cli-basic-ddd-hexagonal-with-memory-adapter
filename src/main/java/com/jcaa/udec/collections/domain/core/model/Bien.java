package com.jcaa.udec.collections.domain.core.model;

public class Bien {
    private String id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String unidadMedida;
    private double valorUnitario;
    private String estado;

    public Bien(String id,
                String codigo,
                String nombre,
                String descripcion,
                String tipo,
                String unidadMedida,
                double valorUnitario,
                String estado) {

        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
        this.valorUnitario = valorUnitario;
        this.estado = estado;
    }
    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public String getEstado() {
        return estado;
    }
}
