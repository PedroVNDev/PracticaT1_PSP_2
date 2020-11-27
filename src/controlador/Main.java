package controlador;

import modelo.HiloPaso2;
import modelo.HiloPaso1;
import vista.Formulario;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Formulario f = new Formulario();

        Scanner teclado = new Scanner(System.in);

        int maximo = 0;
        int minimo = 1;
        int opcion = 0;
        int maximoEmpleados = 0;
        int sumas = 0;
        boolean mismatch = false;

        f.menu();
        int empleados = 0;
        maximoEmpleados = contarEmpleados(empleados);

        do {

            try {

                mismatch = false;

                if (opcion < 0 || opcion > 2 || mismatch == true) {
                    f.menu();
                }

                opcion = teclado.nextInt();
                teclado.nextLine();
                maximo = (maximoEmpleados / 5)+1;

                ArrayList<HiloPaso2> hilosArray = new ArrayList<HiloPaso2>();

                switch (opcion) {

                    case 1:
                        new HiloPaso1().start();
                        break;

                    case 2:
                        for (int x = 1; x <= 5; x++) {
                            hilosArray.add(new HiloPaso2(minimo, maximo));
                            minimo = minimo += maximoEmpleados / 5;
                            maximo += maximoEmpleados / 5;
                        }

                        long tiempo = System.currentTimeMillis();
                        hilosArray.forEach(HiloPaso2::start);

                        for (HiloPaso2 hilo : hilosArray) {
                            hilo.join();
                            sumas += hilo.getSuma();
                        }
                        System.out.println("\nsuma total es: " + sumas);
                        System.out.println("\nLa tarea tardo: " + (System.currentTimeMillis() - tiempo) + " milisegundos\n");
                        f.menu();
                        break;

                    case 0:
                        System.out.println("\nSaliendo de la aplicacion...");
                        break;

                    default:
                        System.out.println("Introduce una opción valida\n");
                        break;
                }

            } catch (InputMismatchException | InterruptedException ex) {
                System.out.println("Introduce numeros\n");
                teclado.nextLine();
            }

        } while (mismatch == true || opcion != 0);

    }

    public static int contarEmpleados(int empleados) {

        String url = "jdbc:mysql://localhost:3306/bbdd_psp_1";
        String usuario = "DAM2020_PSP";
        String password = "DAM2020_PSP";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            Statement statement = connection.createStatement();
            String query = "select count(*) from empleados;";
            ResultSet resultSet = statement.executeQuery(query);

            //Recorremos la base de datos y la mostramos
            while (resultSet.next()) {

                int count = resultSet.getInt(1);
                empleados = count;

            }

        } catch (SQLException ex) {
            System.out.println("\nLa base de datos no esta en linea");

        } finally {
            return empleados;
        }
    }
}

