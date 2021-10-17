package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ReportesDAO {
	static Conexion cnn=new Conexion();
	static Connection con=cnn.Conecta();
	static PreparedStatement ps=null;
	ResultSet res=null;
	
	public String[][] reporte_usuarios() {
	
		try {
			  String sql="select * from usuarios";
			  ps=con.prepareStatement(sql);
			  res=ps.executeQuery();
			  String[][] usuarios = new String[10][10];
			  int i=0;
			  while(res.next()) {
				  usuarios[i]=new String[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)};
				  i++;
			  }
			  return usuarios;
			}catch(SQLException ex) {
				String[][] usuarios = new String[1][1];
				JOptionPane.showMessageDialog(null,"Error al consultar el Usuario"+ex);
				return usuarios;
			}
	}
	
	public String[][] reporte_ventascliente() {
		
		try {
			  String sql="SELECT cli.cedula_cliente, cli.nombre_cliente,"
			  		+ "if( (select sum(total_venta) from ventas v where v.cedula_cliente = cli.cedula_cliente) is null,0,(select sum(total_venta) from ventas v where v.cedula_cliente = cli.cedula_cliente)) ventas "
			  		+ "FROM "
			  		+ " clientes cli ;";
			  ps=con.prepareStatement(sql);
			  res=ps.executeQuery();
			  String[][] ventascliente = new String[20][3];
			  int i=0;
			  while(res.next()) {
				  ventascliente[i]=new String[] {res.getString(1),res.getString(2),res.getString(3)};
				  i++;
			  }
			  return ventascliente;
			}catch(SQLException ex) {
				String[][] ventascliente = new String[1][1];
				JOptionPane.showMessageDialog(null,"Error al consultar el Usuario"+ex);
				return ventascliente;
			}
	}
	public String[][] reporte_clientes() {
		
		try {
			  String sql="select * from clientes";
			  ps=con.prepareStatement(sql);
			  res=ps.executeQuery();
			  String[][] clientes = new String[22][10];
			  int i=0;
			  while(res.next()) {
				  clientes[i]=new String[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)};
				  i++;
			  }
			  return clientes;
			}catch(SQLException ex) {
				String[][] clientes = new String[1][1];
				JOptionPane.showMessageDialog(null,"Error al consultar el Cliente"+ex);
				return clientes;
			}
}
	}


