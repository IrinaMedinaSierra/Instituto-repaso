package curoceat.instituto.services;
/*
La clase AlumnosDAO  es una convensión donde se realizan una serie de métodos que van ser utilizados
para acceder a la BBDD (listar,buscar,borrar,insertar...etc)
Como necesita acceder a la BBDD hereda de Conexión
**/



import curoceat.instituto.modell.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;



public class AlumnoDAO <T> extends Conexion {

        String sql;

        /*
        * El metodo create inserta un nuevo alumno a la BBDD
        * */
        public  void create(Alumno a) {
            /* crear la  llamada a la conexion*/
            Connection con = conectar();
            sql = "INSERT INTO alumnos (nombre,curso,media,fnac) VALUES (?,?,?,?);";
            /* tenemos que capturar un posible error al generar la consulta por medio de un try-catch*/
            try {
                escribir(a,con,sql,"create");
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            //Mostrar un alumno segun su id
            public  Alumno read(int id) {
                Alumno a=null;
                sql="SELECT * FROM alumnos WHERE id=?;";

                try {
                    Connection con = conectar();
                    PreparedStatement pt = con.prepareStatement(sql);
                    pt.setInt(1,id);
                    ResultSet rs= pt.executeQuery();
                if(rs.next()){
                    String nombre=rs.getString("nombre");
                    float media=rs.getFloat("media");
                    String curso=rs.getString("curso");
                    String fnac=rs.getString("fnac");
                    a=new Alumno(id,nombre,curso,media,fnac); //se envia al constructor con el id

                }
                    con.close();
                }catch (SQLException e){
                   e.printStackTrace();
                }
                catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                return a;
            }

    /**
     *
     *Este metodo escribir reemplaza el codigo es duplicado entre crear y actuliazar
     *
     */
    public void escribir(Alumno a,Connection con,String sql, String opcion) throws SQLException{
                PreparedStatement pt = con.prepareStatement(sql);
                //asigno al la secuencia del SQL los valores que son pasados en el objeto Alumno a
                pt.setString(1, a.getNombre());
                pt.setString(2, a.getCurso());
                pt.setFloat(3, a.getMedia());
                /* La fecha de nacimiento la recibimos como tido java.util.date  la debemos castear java.sql.date*/
                String paso=  String.valueOf(a.getfNacimiento());
            //    java.sql.Date sqlDate = new java.sql.Date(a.getfNacimiento().getTime());

                pt.setString(4,paso);
                if (opcion.equals("update")){
                    pt.setInt(5,a.getId());
                }
                pt.executeUpdate();
            }

           public void update(Alumno a){
                if (a!=null){
                    sql="UPDATE alumnos SET nombre=?,curso=?,media=?,fnac=? WHERE id=?;";
                    try{
                        Connection con=conectar();
                        escribir(a,con,sql,"update");
                        con.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }

            }
    public  void delete (int id){
        sql="DELETE FROM alumnos WHERE id=?;";
        try{
            Connection con =conectar();
            PreparedStatement pt=con.prepareStatement(sql);
            pt.setInt(1, id);
            pt.executeUpdate();
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /* crear una lista de todos los datos de la tabla*/
    public List<Alumno> readAll() throws ParseException{
        List<Alumno> lista=new ArrayList<>();
        sql="SELECT * FROM alumnos;";
        try{
            Connection con=conectar();
            PreparedStatement pt=con.prepareStatement(sql);
            ResultSet rs=pt.executeQuery();
            //recorremos los resultados, creamos un objeto alumno por interaccion y lo agregamos a lista
            while (rs.next()){
                String nombre=rs.getString("nombre");
                int id= rs.getInt("id");
                String curso=rs.getString("curso");
                float media=rs.getFloat("media");
                String fnac=rs.getString("fnac");
                Alumno a=new Alumno(id,nombre,curso,media,fnac);
                lista.add(a);
            }
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    return lista;
    }

//buscar por curso
public  ArrayList<Alumno> buscar(T valor,String opcionBusqueda) throws SQLException {
    ArrayList<Alumno> lista=new ArrayList<>();
    Alumno a;
    String valorC= (String) valor;
    PreparedStatement pt;
    ResultSet rs;
    try (Connection con = conectar()) {
        sql = "SELECT * FROM alumnos WHERE " + opcionBusqueda + "=?;";
        pt = con.prepareStatement(sql);
        if (opcionBusqueda.equals("id")) {
            int valorId = Integer.parseInt(valorC);
            pt.setInt(1, valorId);
            rs = pt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                float media = rs.getFloat("media");
                String curso = rs.getString("curso");
                String fnac = rs.getString("fnac");
                a = new Alumno(valorId, nombre, curso, media, fnac); //se envia al constructor con el id
                lista.add(a);
            }
        } else {
            if (opcionBusqueda.equals("nombre") || opcionBusqueda.equals("curso")) {
                pt.setString(1, valorC);
            } else if (opcionBusqueda.equals("media")) {
                float valorFloat = Float.parseFloat(valorC);
                pt.setFloat(1, valorFloat);
            }
            rs = pt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                float media = rs.getFloat("media");
                String curso = rs.getString("curso");
                String fnac = rs.getString("fnac");
                a = new Alumno(id, nombre, curso, media, fnac);
                System.out.println(a);
                lista.add(a);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    return lista;
}



}