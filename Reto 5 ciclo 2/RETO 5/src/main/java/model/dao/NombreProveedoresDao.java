package model.dao;

//Estructura de datos
import java.util.ArrayList;

import model.vo.NombreProveedores;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos


public class NombreProveedoresDao {
   
    public ArrayList<NombreProveedores> rankingNombreProveedores() throws SQLException {
        
        ArrayList<NombreProveedores> respuesta = new ArrayList<NombreProveedores>();
        Connection conexion = JDBCUtilities.getConnection();
        try{

            String consulta =   "select p.ID_Proyecto , c.Proveedor from Proyecto p join Compra c on(p.ID_Proyecto = c.ID_Proyecto) where p.Ciudad = 'Neiva' order by p.ID_Proyecto ASC";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
            	NombreProveedores nombreProveedores = new NombreProveedores();
            	nombreProveedores.setID_Proyecto(resultSet.getString("ID_Proyecto"));
            	nombreProveedores.setProveedor(resultSet.getString("Proveedor"));
                

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(nombreProveedores);
            }
                
            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos: " + e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
        
}