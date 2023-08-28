package org.ulisesgv.appfacturas;
import org.ulisesgv.appfacturas.domain.Cliente;
import org.ulisesgv.appfacturas.domain.Factura;
import org.ulisesgv.appfacturas.domain.ItemFacturas;
import org.ulisesgv.appfacturas.domain.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente =  new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andres");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura: ");
        String desc =  s.nextLine();
        Factura factura =  new Factura(desc, cliente);


        Producto producto;
        String nombre;
        float precio;
        int cantidad;

        System.out.println();

        for(int i = 0; i<5; i++){
            producto = new Producto();
            System.out.println("Ingrese producto n° " + producto.getCodigo()+ "; ");
            nombre = s.nextLine();
            producto.setNombre(nombre);

            System.out.println("Ingrese el precio: ");
            precio = s.nextFloat();
            producto.setPrecio(precio);

            System.out.println("Ingrese la cantidad: ");
            cantidad = s.nextInt();

            ItemFacturas item = new ItemFacturas(cantidad, producto);
            factura.addItemFacturas(item);

            System.out.println();

            s.nextLine(); //hacemos uso de este nextLine para que mueva el cursor a otra linea al final de cada iteracion

        }

        System.out.println(factura.generarDetalle());

    }
}
