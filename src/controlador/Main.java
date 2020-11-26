package controlador;

import modelo.HiloPaso2;
import modelo.HiloPaso1;
import vista.Formulario;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Formulario f = new Formulario();
        Scanner teclado = new Scanner(System.in);

        int inicio = 0;
        int opcion = 0;
        int totalEmpleados = 0;
        boolean mismatch = false;

        f.menu();
        int empleados = 0;
        totalEmpleados = contarEmpleados(empleados);

        do {

            try {

                mismatch = false;

                if (opcion < 0 || opcion > 2 || mismatch == true) {
                    f.menu();
                }

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1:
                        new HiloPaso1().start();
                        break;

                    case 2:
                            new HiloPaso2(totalEmpleados).start();
                        break;

                    case 3:
                        for (int y = 1; y <= 4; y++) {
                            if (y == 1){
                                System.out.println("\nEmpleados a hacer:" + totalEmpleados / 5 + " Inicio hilo: " + inicio);
                            }
                            System.out.println("\nEmpleados a hacer:" + totalEmpleados / 5 + " Inicio hilo: " + (totalEmpleados / 5) * y);
                        }
                        System.out.println();
                        break;

                    case 0:
                        System.out.println("\nSaliendo de la aplicacion...");
                        break;

                    default:
                        System.out.println("Introduce una opción valida\n");
                        break;
                }

            } catch (InputMismatchException ex) {
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
            ex.printStackTrace();

        } finally {
            return empleados;
        }
    }
}

