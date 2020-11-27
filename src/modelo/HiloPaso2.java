package modelo;

import vista.Formulario;

import java.sql.*;

public class HiloPaso2 extends Thread {

    private int maximo;
    private int minimo;
    private int ingresosTotal;

    public int getSuma() {
        return ingresosTotal;
    }

    public void setSuma(int suma) {
        this.ingresosTotal = suma;
    }

    public HiloPaso2(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public void run() {

        Formulario f = new Formulario();
        String usuario = "DAM2020_PSP", password = "DAM2020_PSP", url = "jdbc:mysql://localhost:3306/bbdd_psp_1";
        int ingresos_totales = 0;
        long tiempo = System.currentTimeMillis();

        try {

            Connection connection = DriverManager.getConnection(url, usuario, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM empleados WHERE ID >=" + minimo + " AND ID < " + maximo;
            ResultSet resultSet = statement.executeQuery(query);

            //Recorremos la base de datos
            while (resultSet.next()) {

                //Tomamos los ingresos 1 a 1 y los añadimos a la variale ingresos_totales
                ingresos_totales += resultSet.getInt("INGRESOS");

            }

            //Agregamos a setSuma todos los ingresos de este hilo
            setSuma(ingresos_totales);
            System.out.println("la suma del hilo es: " + getSuma());

        } catch (SQLException ex) {
            System.out.println("\nLa base de datos no esta en linea");
        }
    }


}

