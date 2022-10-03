package ejercicio3;

import java.sql.*;

public class VideojuegoDAO {


    private static Connection conectar(){
        String url = "jdbc:sqlite:./src/main/java/ejercicio3/examen.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
           /* if (con.isValid(5)){
                System.out.println("Conexión establecida");
            }*/
            return con;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void create(Videojuego v){
        Connection con = conectar();

        String sql = "INSERT INTO videojuego VALUES (?, ?, ?, ?,?,?,?,?);";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,v.getId());
            pst.setString(2,v.getNombre());
            pst.setString(3,v.getPlataforma());
            pst.setString(4,v.getGenero());
            pst.setString(5, v.getFechaLanzamiento());
            pst.setDouble(6,v.getPrecio());
            pst.setBoolean(7,v.isStock());
            pst.setInt(8,v.getUnidades());
            int registrosInsertados = pst.executeUpdate();
            System.out.println("Se han insertado: " + registrosInsertados + " registros");

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public static Videojuego read(int id){
        Connection con = conectar();
        Videojuego a = null;
        String consulta = "SELECT * FROM videojuego WHERE id = ?;";

        try {
            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                a = new Videojuego(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6),rs.getBoolean(7), rs.getInt(8));

            }
            con.close();
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void update(Videojuego v){
        Connection con = conectar();
        String act = "UPDATE videojuego SET nombre = ?, plataforma = ?, genero = ?, fecha_lanzamiento = ?, precio = ?, stock = ?, unidades = ? WHERE id = ?;";
        try {
            PreparedStatement pst = con.prepareStatement(act);
            pst.setString(1,v.getNombre());
            pst.setString(2,v.getPlataforma());
            pst.setString(3,v.getGenero());
            pst.setString(4, v.getFechaLanzamiento());
            pst.setDouble(5,v.getPrecio());
            pst.setBoolean(6,v.isStock());
            pst.setInt(7,v.getUnidades());
            pst.setInt(8,v.getId());

            int actualizado = pst.executeUpdate();
            System.out.println("Se han actualizado: " + actualizado + " registros");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        Connection con = conectar();
        String borrar = "DELETE FROM videojuego WHERE id = ?;";
        try {
            PreparedStatement pst = con.prepareStatement(borrar);
            pst.setInt(1,id);
            int borrado = pst.executeUpdate();
            System.out.println("Se han borrado: " + borrado + " registros");

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int obtenerUltimoId(){
        Connection con = conectar();
        String sql = "SELECT MAX(id) FROM videojuego;";
        ResultSet rs = null;
        int ultimoID = 0;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            if (!rs.equals(null)){
                ultimoID = rs.getInt(1);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el último id " + e.getMessage());
            e.printStackTrace();
        }


        return ultimoID;
    }
}
