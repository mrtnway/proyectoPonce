package modelo.dto;

import modelo.dto.Persona;
import java.util.Date;

/**
* @author: OBJ
*
*/ 

public class Vendedor extends Persona{
    
    private float vend_comision;
	
	
	public Vendedor(String pers_nombre, String pers_telefono,String pers_domicilio, int id, float vend_comision) {
		super(pers_nombre, pers_telefono, pers_domicilio, id);
		setVendComision(vend_comision);
	}

	public void setVendedorComision(float vend_comision) {
		this.vend_comision = vend_comision;
	}

	public float getVendedorComision() {
		return vend_comision;
	}
}
