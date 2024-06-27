/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;
import java.util.Scanner;

public class EjecutorDos {

    public static void main(String[] args) {

        Scanner tecla = new Scanner(System.in);
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();

        System.out.print("Ingrese el nombre del centro comercial: ");
        String nombreCentroComer = tecla.nextLine();

        System.out.println("Cuantos locales de arriendo de comida desea ingresar?");
        int arrComida = tecla.nextInt();
        System.out.println("Cuantos locales de arriendo comercial desea ingresar?");
        int arrComercial = tecla.nextInt();
        System.out.println("Cuantos locales de arriendo de sesiones desea ingresar?");
        int arrSesiones = tecla.nextInt();
        tecla.nextLine();

        System.out.println("----o");
        for (int i = 0; i < arrComida; i++) {
            System.out.println("\tArriendo Local de Comida (" + (i+1) + ")" );
            System.out.print("Ingrese el nombre del propietario: ");
            String nombreComi = tecla.nextLine();
            System.out.print("Ingrese la cuota base: $");
            double cuotaBase = tecla.nextDouble();
            System.out.println("-----------------------");
            System.out.print("Ingrese el valor del agua: $");
            double valorAgua = tecla.nextDouble();
            System.out.print("Ingrese el valor de la luz: $");
            double valorLuz = tecla.nextDouble();
            System.out.print("Ingres el iva: ");
            double iva = tecla.nextDouble();
            System.out.println("");
            tecla.nextLine();

            ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                    nombreComi, cuotaBase);
            arriendoComida.establecerIva(iva);
            arriendoComida.establecerValorAgua(valorAgua);
            arriendoComida.establecerValorLuz(valorLuz);
            listaArriendos.add(arriendoComida);
        }

        System.out.println("----o");
        for (int i = 0; i < arrComercial; i++) {
            System.out.println("\tArriendo Local Comercial (" + (i+1) + ")" );
            System.out.print("Ingrese el nombre del propietario: ");
            String nombreComer = tecla.nextLine();
            System.out.print("Ingrese el valor de la cuota base: $");
            double cuotaBaseComer = tecla.nextDouble();
            System.out.println("----");
            System.out.print("Ingrese el valor adicional fijo: $");
            double valorAdicFijo = tecla.nextDouble();
            System.out.println("");
            tecla.nextLine();

            ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                    nombreComer, cuotaBaseComer);
            arriendoComercial.establecerValorAdicionalFijo(valorAdicFijo);
            listaArriendos.add(arriendoComercial);
        }

        System.out.println("----o");
        for (int i = 0; i < arrSesiones; i++) {
            System.out.println("\tArriendo Local de Sesiones (" + (i+1) + ")" );
            System.out.print("Ingrese el nombre del propietario: ");
            String nombreSes = tecla.nextLine();
            System.out.print("Ingrese el valor de la cuota base: $");
            double cuotaBaseSes = tecla.nextDouble();
            System.out.println("----");
            System.out.println("Ingrese el valor de las sillas: $");
            double valorSillas = tecla.nextDouble();
            System.out.print("Ingrese el valor de amplificacion: $");
            double valorAmplificacion = tecla.nextDouble();
            System.out.println("");
            tecla.nextLine();
            
            ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                    nombreSes, cuotaBaseSes);
            arriendoSesiones.establecerValorSillas(valorSillas);
            arriendoSesiones.establecerValorAmplificacion(valorAmplificacion);
            listaArriendos.add(arriendoSesiones);
        }

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial(nombreCentroComer,
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
