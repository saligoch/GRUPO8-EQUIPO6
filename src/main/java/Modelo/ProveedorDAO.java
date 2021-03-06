package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProveedorDAO {
	
	static Conexion cnn=new Conexion();
	static Connection con=cnn.Conecta();
	static PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_Proveedor(ProveedorDTO pro) {
		
		boolean result=false;
		try {			
		String sql="insert into proveedores values (?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setInt(1,pro.getNit());
		ps.setString(2,pro.getCiudad());
		ps.setString(3,pro.getDireccion());	
		ps.setString(4,pro.getNombre());
		ps.setString(5,pro.getTelefono());
		result=ps.executeUpdate()>0;
				
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"No se registro el proveedor" +ex);
		}
		
		return result;
	}
	
	public ProveedorDTO Buscar_Proveedor(int nit) {
		
		ProveedorDTO pro=null;
		try {
		  String sql="select * from proveedores where nitproveedor=?";
		  ps=con.prepareStatement(sql);
		  ps.setInt(1, nit);
		  res=ps.executeQuery();
		  while(res.next()) {
			  pro= new ProveedorDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			  
		  }
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar el Proveedor"+ex);
		}
		return pro;
	}
	public boolean Actualizar_Proveedor(ProveedorDTO pro) {
	boolean result=false;
	try {	
	String sql="update proveedores set ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor =?, telefono_proveedor=? where nitproveedor=?";
	ps=con.prepareStatement(sql);
	ps.setString(1,pro.getCiudad());
	ps.setString(2,pro.getDireccion());	
	ps.setString(3,pro.getNombre());
	ps.setString(4,pro.getTelefono());
	ps.setInt(5,pro.getNit());
	result=ps.executeUpdate()>0;
	
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null,"error al actualizar " +ex);	
	}	
	return result;
}
	public static boolean Eliminar_proveedor(int Nit) {
		boolean resul=false;
		try {
			String sql="delete from proveedores where nitproveedor=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Nit);
			resul=ps.executeUpdate()>0;
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"error al eliminar: "+ex);
				}
		return resul;
		}
}