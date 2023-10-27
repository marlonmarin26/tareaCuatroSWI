package edu.ucaldas.view;

import java.util.List;
import java.util.Scanner;

import edu.ucaldas.controllers.ControladorRegalo;
import edu.ucaldas.model.Producto;

public class Menu {
    static Scanner in;

    public Menu(){

    }

    public void startApp(){
        in = new Scanner(System.in);

        ControladorRegalo controlador = new ControladorRegalo();

        System.out.println("Ingrese la edad de quien recibirá el regalo: ");
        int edad = in.nextInt();
        System.out.println("Ingrese su presupuesto: ");
        double presupuesto = in.nextDouble();
        List<Producto> regalosRecomendados = controlador.buscarRegalos(edad, presupuesto);

        for (Producto regalo : regalosRecomendados) {
            System.out.println(regalo);
        }

        if(regalosRecomendados.size() == 0)
            System.out.println("No se tiene productos para esa edad o precio");
    }
}
