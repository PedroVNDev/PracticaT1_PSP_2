package modelo;

import vista.Formulario;

import java.sql.*;

public class HiloPaso1 extends Thread {

    public void run() {

        Formulario f = new Formulario();
        String url = "jdbc:mysql://localhost:3306/bbdd_psp_1";
        String usuario = "DAM2020_PSP";
        String password = "DAM2020_PSP";
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

                System.out.print("EMAIL: ");
                System.out.println(resultSet.getString("EMAIL"));

                System.out.print("INGRESOS: ");
                System.out.println(resultSet.getInt("INGRESOS"));

                //Tomamos los ingresos 1 a 1 y los añadimos a la variale ingresos_totales
                ingresos_totales += resultSet.getInt("INGRESOS");

                System.out.println();

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            f.menu();
        }
    }

}
