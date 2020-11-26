package modelo;

import vista.Formulario;

import java.sql.*;

public class HiloPaso2 extends Thread {

    private int totalEmpleados;

    public HiloPaso2(int totalEmpleados) {
        this.totalEmpleados = totalEmpleados;
    }

    public void run() {

        Formulario f = new Formulario();
        System.out.println("\n");
        String url = "jdbc:mysql://localhost:3306/bbdd_psp_1";
        String usuario = "DAM2020_PSP";
        String password = "DAM2020_PSP";
        int ingresos_totales = 0;
        long tiempo = System.currentTimeMillis();

        for (int x = 1; x <= 80; x++) {

            try {

                Connection connection = DriverManager.getConnection(url, usuario, password);
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM empleados where id ='" + x + "'";
                ResultSet resultSet = statement.executeQuery(query);

                //Recorremos la base de datos y la mostramos
                while (resultSet.next()) {

                    System.out.print("ID: ");
                    System.out.println(resultSet.getInt("ID"));

                    System.out.print("EMAIL: ");
                    System.out.println(resultSet.getString("EMAIL"));

                    System.out.print("INGRESOS: ");
                    System.out.println(resultSet.getInt("INGRESOS"));

                    //Tomamos los ingresos 1 a 1 y los añadimos a la variale ingresos_totales
                    ingresos_totales += resultSet.getInt("INGRESOS");

                    System.out.println("");

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                System.out.println("Los ingresos totales son: " + ingresos_totales);
            }
        }


    }
}
