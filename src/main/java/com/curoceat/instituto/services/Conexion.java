package curoceat.instituto.services;


import java.sql.*;
public class Conexion {
    private Connection con;
    private  String url;
    private  String user;
    private String pass;
    public Connection conectar(){
        // estos valores no cambian, por lo cual podrian ser final (Constantes en los atributos de la clase)
        // insertar en url utf-8 para que reconozca los caracteres especiales.
        url="jdbc:mysql://localhost:3306/instituto?useUnicode=true&characterEncoding=utf-8";
        user="root";
        pass="Qzec7139.";
        try {
            //Existe documentacion donde indica que no necesitas invocar el Driver.Class , pero si lo necesitas!!!
            // Busca el conector de la BBDD para poder realizar luego la conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            /******/
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión realizada con exito");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
