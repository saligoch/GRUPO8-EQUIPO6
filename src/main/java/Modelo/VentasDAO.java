package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;
import Modelo.VentasDTO;
import Modelo.DetalleVentasDTO;

public class VentasDAO {

	static Conexion cnn=new Conexion();
	static Connection con=cnn.Conecta();
	static PreparedStatement ps=null;
	ResultSet res=null;
	
	public int Codigo_Venta() {
		try {			
		String sql="select max(codigo_venta)+1 as id from ventas";
		ps=con.prepareStatement(sql);
		res = ps.executeQuery();
		
		while(res.next()) {
			  return res.getInt(1);
			  
		  }
		
		return 1;
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null,"Error al registrar el consecutivo"+ex);
	}
		return 1;
	}
		
	
	public boolean insertarventa(VentasDTO ven) {
		
		boolean result= false;
		
		try {			
			String sql="insert into ventas values (?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,ven.getCodigo_venta());
			ps.setString(2,ven.getCedulacliente());
			ps.setString(3,ven.getCedulausuario());
			ps.setDouble(4,ven.getValorventa());	
			ps.setDouble(5,ven.getTotalventa());
			ps.setDouble(6,ven.getIva());
			result=ps.executeUpdate()>0;
					
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"No se registro el producto " +ex);
			}
			
		return result;
	}
public boolean insertardetalleventa(DetalleVentasDTO det) {
		
		boolean result= false;
		
		try {			
			String sql="insert into detalle_ventas "
					+ "(cantidad_producto,codigo_venta,valor_total,valor_venta,valoriva,codigo_producto)"
					+ " values (?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,det.getCantidad_producto());
			ps.setDouble(2,det.getCodigo_venta());
			ps.setDouble(3,det.getValor_total());
			ps.setDouble(4,det. getValor_venta());	
			ps.setDouble(5,det.getValoriva());
			ps.setString(6,det.getCodigo_producto());
			result=ps.executeUpdate()>0;
					
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null,"No se registro el producto " +ex);
			}
			
		return result;
	}
	
}
