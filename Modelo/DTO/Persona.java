package modelo.dto;
import java.util.Date;

/**
* @author: OBJ
*
*/ 

public class Persona{
	
	private String nombre;
	private String telefono;
	private String domicilio;
	private int id;
	
	public Persona(String nombre, String telefono, String domicilio, int id){
	
		this.nombre = nombre;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.id = id;
		
	}
	
	public void setPersonaNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setPersonaTelefono(String telefono){
		this.telefono = telefono;
	}
	
	public void setPersonaDomicilio(String domicilio){
		this.domicilio = domicilio;
	}
	
	public void setPersonaID(int id){
		this.id = id;
	}
		
	public String getPersonaNombre(){
		return nombre;
	}
	
	public String getPersonaTelefono(){
		return telefono;
	}

	public String getPersonaDomicilio(){
		return domicilio;
	}
	
	public int getPersonaID(){
		return id;
	}
	
	

}