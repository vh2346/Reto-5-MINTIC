package model.vo;

public class PromedioSalarios {
    
   
    private String Ciudad_Residencia;
    private Integer Promedio;
   
    public PromedioSalarios() {
    }
    

    public PromedioSalarios(String ciudad_Residencia, Integer promedio) {
		super();
		Ciudad_Residencia = ciudad_Residencia;
		Promedio = promedio;
	}


	

	public String getCiudad_Residencia() {
		return Ciudad_Residencia;
	}

	public void setCiudad_Residencia(String ciudad_Residencia) {
		Ciudad_Residencia = ciudad_Residencia;
	}


	public Integer getPromedio() {
		return Promedio;
	}


	public void setPromedio(Integer promedio) {
		Promedio = promedio;
	}

	
}
    