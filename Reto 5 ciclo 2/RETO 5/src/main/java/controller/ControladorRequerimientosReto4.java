package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)


import model.dao.ListaMaterialDao;
import model.dao.NombreProveedoresDao;
import model.dao.PromedioSalariosDao;



import model.vo.ListaMaterial;
import model.vo.NombreProveedores;
import model.vo.PromedioSalarios;



//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {       
    
    private final PromedioSalariosDao promedioSalariosDao;
    private final NombreProveedoresDao nombreProveedoresDao;
    private final ListaMaterialDao listaMaterialDao;
    
    public ControladorRequerimientosReto4(){
        this.promedioSalariosDao = new PromedioSalariosDao();
        this.listaMaterialDao = new ListaMaterialDao();
        this.nombreProveedoresDao = new NombreProveedoresDao();

    }

    public ArrayList<ListaMaterial> consultarListaMaterial() throws SQLException {
        return this.listaMaterialDao.rankingListaMaterial();
    }
    
    public ArrayList<PromedioSalarios> consultarPromedioSalarios() throws SQLException {
        return this.promedioSalariosDao.rankingPromedioSalarios();
    }

    public ArrayList<NombreProveedores> consultarNombreProveedores() throws SQLException {
        return this.nombreProveedoresDao.rankingNombreProveedores();
    }

}