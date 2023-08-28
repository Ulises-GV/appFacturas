package org.ulisesgv.appfacturas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFacturas[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 10;
    private static int ultimoFolio;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFacturas[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFacturas[] getItems() {
        return items;
    }

    //nuevamente cosntruimos un metodo add para agregar un arreglo de facturas
    public void addItemFacturas(ItemFacturas item){
        if(indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    //Calculamos el total de la factura
    public float calcularTotal(){
        float total = 0.0f;
        for (ItemFacturas item : this.items) {
            if (item == null){
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle(){
        StringBuilder sb = new StringBuilder("Factura N° :");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n").append("\n#\tNombre\t$\tCant.\tTotal\n");

        SimpleDateFormat df  = new SimpleDateFormat("dd 'de' MMMM, yyyy");

        sb.append("Fecha emision: ")
                .append(df.format(this.fecha))
                .append("\n");

        for (ItemFacturas item: this.items){
            if(item == null ){
                continue;
            }
            sb.append(item.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");
        }
        sb.append("\nGran Total: ").append(calcularTotal());

        return sb.toString();

    }

}
