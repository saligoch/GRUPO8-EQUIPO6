package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProductoDAO {

	static Conexion cnn=new Conexion();
	static Connection con=cnn.Conecta();
	static PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_Producto(ProductoDTO prod) {
		
		boolean result=false;
		try {			
		String sql="insert into productos values (?,?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setInt(1,prod.getCodpro());
		ps.setFloat(2,prod.getIva());
		ps.setInt(3,prod.getNit_proveedor());
		ps.setString(4,prod.getNombre());	
		ps.setFloat(5,prod.getPrecioc());
		ps.setFloat(6,prod.getPreciov());
		result=ps.executeUpdate()>0;
				
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"No se registro el producto " +ex);
		}
		
		return result;
	}
	
	public ProductoDTO Buscar_Producto(int codpro) {
		
		ProductoDTO prod=null;
		try {
		  String sql="select * from productos where codigo_producto=?";
		  ps=con.prepareStatement(sql);
		  ps.setInt(1, codpro);
		  res=ps.executeQuery();
		  while(res.next()) {
			  prod= new ProductoDTO(res.getInt(1),res.getFloat(2),res.getInt(3),res.getString(4),res.getFloat(5),res.getFloat(6));
			  
		  }
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar el Producto"+ex);
		}
		return prod;
	}
	public boolean Actualizar_Producto(ProductoDTO prod) {
		boolean result=false;
		try {	
		String sql="update productos set ivacompra=?, nitproveedor=?, nombre_producto=?, precio_compra=? , precio_venta=? where codigo_producto =?";
		ps=con.prepareStatement(sql);
	
		ps.setFloat(1,prod.getIva());
		ps.setInt(2,prod.getNit_proveedor());	
		ps.setString(3,prod.getNombre());
		ps.setFloat(4,prod.getPrecioc());
		ps.setFloat(5,prod.getPreciov());
		ps.setInt(6,prod.getCodpro());
		result=ps.executeUpdate()>0 ? true:false;
		return result;
		
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al actualizar " +ex);	
			return false;
		}	
	}
	
	public boolean Cargar_Productos(String URL) {
		boolean resul=false;
		try {
			
		String sql="load data infile'"+URL+"'into table productos fields terminated by';'lines terminated by'\r\n'";
		ps=con.prepareStatement(sql);
		resul=ps.executeUpdate()>0;
		
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al ingresar los productos" +ex);
		}
		return resul;
	}
	
public static boolean Eliminar_producto(int codpro) {
	boolean resul=false;
	try {
		String sql="delete from productos where codigo_producto=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, codpro);
		resul=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al eliminar: "+ex);
			}
	return resul;
	}
}
