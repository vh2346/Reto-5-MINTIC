package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos

import model.vo.ListaMaterial;

public class ListaMaterialDao {
    //Obtener los proyectos por Tipo en la ciudad de 
    public ArrayList<ListaMaterial>rankingListaMaterial() throws SQLException {

        ArrayList<ListaMaterial> respuesta = new ArrayList<ListaMaterial>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT p.ID_Proyecto, mc.Nombre_Material FROM Proyecto p JOIN Compra c ON (p.ID_Proyecto=c.ID_Proyecto) JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion=mc.ID_MaterialConstruccion) WHERE p.ID_Proyecto between 40 and 55 ORDER BY p.ID_Proyecto ASC;";

           
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
                ListaMaterial listaMaterial = new ListaMaterial();
                listaMaterial.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                listaMaterial.setNombreMaterial(resultSet.getString("Nombre_Material"));
          //      asesorPorCiudad.setPrimerApellido(resultSet.getString("Primer_Apellido"));
            //    asesorPorCiudad.setCiudadResidencia(resultSet.getString("Ciudad_Residencia"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(listaMaterial);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos de tipo Apartaestudio en Quibdo: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de vo's
        return respuesta;
    }     
}