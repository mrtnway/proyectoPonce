/**@author: .OBJ
@version: 1.0
Esta es la clase para usar la tabla de vendedor dentro de la base de datos
*/
package modelo.dao;

/**
* @author: OBJ
*
*/ 

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

import modelo.ConexionBD;
import modelo.dto.Vendedor;
import modelo.dto.Persona;

public class AlumnoDAO {
    private static PreparedStatement sentenciaPreparada1, sentenciaPreparada2;
    private static Statement sentencia;
	private static ResultSet rs, rs1, tuplas;
	private static Connection conexion;
       

	public static boolean insertar(Vendedor vendedor){
		
		int resultado1, resultado2;	
		boolean ok = true;
	
		try {

			conexion = ConexionBD.getConexion();
                      
			sentenciaPreparada1 = conexion.prepareStatement();
	
                        
                       
			sentenciaPreparada1.setString(1, vendedor.getPersonaNombre());
			sentenciaPreparada1.setString(2, vendedor.getPersonaTelefono());
			sentenciaPreparada1.setString(3, vendedor.getPersonaDomicilio());;
			sentenciaPreparada1.setString(4, vendedor.getPersonaID());

			resultado1 = sentenciaPreparada1.executeUpdate();
			
			sentenciaPreparada2 = conexion.prepareStatement();
			sentenciaPreparada2.setString(1, vendedor.getVendedorComision());

			resultado2 = sentenciaPreparada2.executeUpdate();
			
			if (resultado1 == 0 || resultado2 == 0) {
				conexion.rollback();
				ok = false;
			
			} else {

				conexion.commit();
				sentenciaPreparada1.close();
				sentenciaPreparada2.close();
				ConexionBD.cerrarConexion();
			}
                /**
                *@exception para el manejo de excepciones en la base de datos        
                */
		} catch (SQLException e){
                        e.printStackTrace();
			ok = false;
		} finally {
			ConexionBD.cerrarConexion();
		}
	
		return ok;		
	}
	/**
        *Metodo para modificar la base de datos
        *@param vendedor
        */
	public static boolean modificar(Vendedor vendedor){
		int resultado1, resultado2;	
		boolean ok = true;
	
		try {

			conexion = ConexionBD.getConexion();
			sentenciaPreparada1 = conexion.prepareStatement();
			//define valores de values				
			sentenciaPreparada1.setString(1, vendedor.getPersonaNombre());
			sentenciaPreparada1.setString(2, vendedor.getPersonaTelefono());
			sentenciaPreparada1.setString(3, vendedor.getPersonaDomicilio());
			sentenciaPreparada1.setString(4, vendedor.getPersonaID());
			
			resultado1 = sentenciaPreparada1.executeUpdate();
			
			sentenciaPreparada2 = conexion.prepareStatement();
			//define valores de values				
			sentenciaPreparada2.setString(1, vendedor.getVendedorComision());
			
			resultado2 = sentenciaPreparada2.executeUpdate();
			
			if (resultado1 == 0 || resultado2 == 0) {				
				conexion.rollback();
				ok = false;
			} else {

				conexion.commit();
				sentenciaPreparada1.close();
				sentenciaPreparada2.close();
				ConexionBD.cerrarConexion();
			}
                /**
                *@exception SQLException para el manejo de excepciones de mysql
                */
		} catch (SQLException e){
			ok = false;
                        e.printStackTrace();
		} finally {
			ConexionBD.cerrarConexion();
		}
		
		return ok;		
	}//fin del metodo modificar
	
        /**
        *Metodo para borrar un vendedor
        *@param id
        */
	public static boolean borrar(int id) {
			
		int resultado1, resultado2;	
		boolean ok = true;
                Vendedor vendedor = buscarVendedor(id);
	
		try {

			conexion = ConexionBD.getConexion();
			sentenciaPreparada1 = conexion.prepareStatement();

			//define valores de values
			sentenciaPreparada1.setInt(1, id);

			resultado1 = sentenciaPreparada1.executeUpdate();
			
			sentenciaPreparada2 = conexion.prepareStatement();

			//define valores de values
			sentenciaPreparada2.setInt(1, vendedor.getPersonaId());

			resultado2 = sentenciaPreparada2.executeUpdate();
			
			if (resultado1 == 0 || resultado2 == 0) {				
				conexion.rollback();
				ok = false;
			} else {

				conexion.commit();
				sentenciaPreparada1.close();
				sentenciaPreparada2.close();
				ConexionBD.cerrarConexion();
			}
                /**
                *@exception SQLException para el manejo de excepciones de mysql        
                */
		} catch (SQLException e){
			ok = false;
		} finally {
			ConexionBD.cerrarConexion();
		}

		return ok;		
	}//fin del metodo borrar
        
        /**
        *Metodo para buscar un vendedor
        *@param idAlum
        */
    public static Vendedor buscarVendedor(int id){
        
            Vendedor vendedor = null;
           
            
            try{
		conexion = ConexionBD.getConexion();
		sentenciaPreparada1 = conexion.prepareStatement();
		sentenciaPreparada1.setInt(1, id);
		rs = sentenciaPreparada1.executeQuery();
                        
               
                
        /**
            *@exception SQLException manejo de excepciones de mysql
                */		
            }catch(SQLException e){
                e.printStackTrace();
            }
            finally{
                    
                
                ConexionBD.cerrarConexion();
                
            }
            return vendedor;
            
        }	
		
}
