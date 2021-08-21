package model.dao;

//Estructura de datos
import java.util.ArrayList;

import model.vo.PromedioSalarios;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos


public class PromedioSalariosDao {
    
    public ArrayList<PromedioSalarios> rankingPromedioSalarios() throws SQLException {
        
        ArrayList<PromedioSalarios> respuesta = new ArrayList<PromedioSalarios>();
        Connection conexion = JDBCUtilities.getConnection();
        try{

            String consulta = "select Ciudad_Residencia , AVG(Salario) as Promedio from Lider group by Ciudad_Residencia HAVING AVG(Salario)  <  400000 ORDER by Promedio DESC ";


            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultSet.next()){
            	PromedioSalarios promedioSalarios = new PromedioSalarios();
            	promedioSalarios.setCiudad_Residencia(resultSet.getString("Ciudad_Residencia"));
            	promedioSalarios.setPromedio(resultSet.getInt("Promedio"));
            	

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(promedioSalarios);
            }
            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando las compras por proveedor: " + e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
    
}