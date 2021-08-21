package model.vo;

public class NombreProveedores {
    private String ID_Proyecto;
    private String Proveedor; 
    
    
    public NombreProveedores() {
    }


	public NombreProveedores(String iD_Proyecto, String proveedor) {
		super();
		ID_Proyecto = iD_Proyecto;
		Proveedor = proveedor;
	}


	public String getID_Proyecto() {
		return ID_Proyecto;
	}


	public void setID_Proyecto(String iD_Proyecto) {
		ID_Proyecto = iD_Proyecto;
	}


	public String getProveedor() {
		return Proveedor;
	}


	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}

    

    
}