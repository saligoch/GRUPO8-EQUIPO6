package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ClienteDAO {
	
	Conexion cnn=new Conexion();
	Connection con=cnn.Conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_Cliente(ClienteDTO cli) {
		
		boolean result=false;
		try {			
		String sql="insert into clientes values (?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setInt(1,cli.getCedula());
		ps.setString(2,cli.getDireccion());
		ps.setString(3,cli.getEmail());	
		ps.setString(4,cli.getNombre());
		ps.setString(5,cli.getTelefono());
		result=ps.executeUpdate()>0;
				
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"No se registro el cliente " +ex);
		}
		
		return result;
	}
	
	public ClienteDTO Buscar_Cliente(int cedula) {
		
		ClienteDTO cli=null;
		try {
		  String sql="select * from clientes where cedula_cliente=?";
		  ps=con.prepareStatement(sql);
		  ps.setInt(1, cedula);
		  res=ps.executeQuery();
		  while(res.next()) {
			  cli= new ClienteDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			  
		  }
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar el Cliente"+ex);
		}
		return cli;
	}
 
}