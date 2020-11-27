package modelo;

import vista.Formulario;

import java.sql.*;

public class HiloPaso1 extends Thread {

    public void run() {

        Formulario f = new Formulario();
        String usuario = "DAM2020_PSP", password = "DAM2020_PSP", url = "jdbc:mysql://localhost:3306/bbdd_psp_1";
        int ingresos_totales = 0;
        long tiempo = System.currentTimeMillis();

        try {
            Connection connection = DriverManager.getConnection(url, usuario, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM empleados";
            ResultSet resultSet = statement.executeQuery(query);

            //Recorremos la base de datos y la mostramos
            while (resultSet.next()) {

                System.out.print("ID: ");
                System.out.println(resultSet.getInt("ID"));

                System.out.print("Email: ");
                System.out.println(resultSet.getString("EMAIL"));

                System.out.print("Ingresos: ");
                System.out.println(resultSet.getInt("INGRESOS"));

                //Tomamos los ingresos 1 a 1 y los añadimos a la variale ingresos_totales
                ingresos_totales += resultSet.getInt("INGRESOS");

                System.out.println();

            }

        } catch (SQLException ex) {
            System.out.println("\nLa base de datos no esta en linea");

        } finally {
            System.out.println("La tarea tardo: " + (System.currentTimeMillis() - tiempo) + " milisegundos");
            System.out.println("Los ingresos totales son: " + ingresos_totales + "\n");
            f.menu();
        }
    }

}
