package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class UsuarioDAO {
	
	static Conexion cnn=new Conexion();
	static Connection con=cnn.Conecta();
	static PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_Usuario(UsuarioDTO usu) {
		
		boolean result=false;
		try {			
		String sql="insert into usuarios values (?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setInt(1,usu.getCedula());
		ps.setString(2,usu.getEmail());
		ps.setString(3,usu.getPasword());	
		ps.setString(4,usu.getUsuario());
		ps.setString(5,usu.getNombre());
		result=ps.executeUpdate()>0;
				
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"No se registro el " +ex);
		}
		
		return result;
	}
public UsuarioDTO Buscar_Usuario(int cedula) {
		
		UsuarioDTO usu=null;
		try {
		  String sql="select * from usuarios where cedula_usuario=?";
		  ps=con.prepareStatement(sql);
		  ps.setInt(1, cedula);
		  res=ps.executeQuery();
		  while(res.next()) {
			  usu= new UsuarioDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			  
		  }
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar el Usuario"+ex);
		}
		return usu;
	}
public boolean Actualizar_Usuario(UsuarioDTO usu) {
	boolean result=false;try {	
String sql="update usuarios set email_usuarios=?,nombre_usuario=?, pasword=?, usuario=? where cedula_usuario=? ";
ps=con.prepareStatement(sql);

ps.setString(1,usu.getEmail());	
ps.setString(2,usu.getNombre());	
ps.setString(3,usu.getPasword());
ps.setString(4,usu.getUsuario());
ps.setInt(5,usu.getCedula());
result=ps.executeUpdate()>0;

}catch(SQLException ex) {
	JOptionPane.showMessageDialog(null,"error al actualizar " +ex);	
}
return result;

}
public static boolean Eliminar_usuario(int cedula) {
	boolean resul=false;
	try {
		String sql="delete from usuarios where cedula_usuario=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, cedula);
		resul=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al eliminar: "+ex);
			}
	return resul;
	}

}
