package model.vo;

public class ListaMaterial {
    
    private Integer IdProyecto;
    private String nombreMaterial;
    
    
    public ListaMaterial() {
		// TODO Auto-generated constructor stub
	} {
    }

    public ListaMaterial(Integer idProyecto, String nombreMaterial) {
    	
        IdProyecto = idProyecto;
        this.nombreMaterial = nombreMaterial;
        
    }

	public Integer getIdProyecto() {
		return IdProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		IdProyecto = idProyecto;
	}

	public String getNombreMaterial() {
		return nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}
    
    


    
}