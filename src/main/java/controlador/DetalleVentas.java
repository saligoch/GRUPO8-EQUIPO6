package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.VentasDAO;
import Modelo.VentasDTO;
import Modelo.DetalleVentasDTO;

/**
 * Servlet implementation class DetalleVentas
 * 
 */
@WebServlet("/DetalleVentas")
public class DetalleVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleVentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("consultarCliente")!=null) {
			ClienteDAO cliDao=new ClienteDAO();
			int cedulacli=Integer.parseInt(request.getParameter("Cedula"));
			ClienteDTO cli=cliDao.Buscar_Cliente(cedulacli);
			response.sendRedirect("DatosVen.jsp?nombre="+cli.getNombre()+"&cedula="+cedulacli);
			
			
		}
		if(request.getParameter("consultarUsuario")!=null) {
			UsuarioDAO UsuDao=new UsuarioDAO();
			int cedulausu=Integer.parseInt(request.getParameter("Cedula_usuario"));
			UsuarioDTO usu=UsuDao.Buscar_Usuario(cedulausu);
			response.sendRedirect("DatosVen.jsp?nombreusu="+usu.getNombre()+"&cedulausu="+cedulausu);
			
			
		}
		if(request.getParameter("consultarProducto1")!=null) {
			
		int codProd=Integer.parseInt(request.getParameter("CodProducto1"));
		int cant=Integer.parseInt(request.getParameter("Cantidad"));
			ProductoDAO ProDao= new ProductoDAO();
			ProductoDTO prod = ProDao.Buscar_Producto(codProd);
			if(prod!=null) {
				String producto=prod.getNombre();
				
				response.sendRedirect("DatosVen.jsp?producto="+producto+"&codProd="+codProd+"&cant1="+cant+"&preciou="+prod.getPreciov()+"&iva="+prod.getIva());
			}else {
				response.sendRedirect("DatosVen.jsp?men=El producto no se encontro");
			}
		}

			if(request.getParameter("consultarProducto2")!=null) {
				
				int codProd2=Integer.parseInt(request.getParameter("CodProducto2"));
				int cant2=Integer.parseInt(request.getParameter("Cantidad2"));
				ProductoDAO ProDao2= new ProductoDAO();
				ProductoDTO prod2 = ProDao2.Buscar_Producto(codProd2);
				if(prod2!=null) {
					String producto=prod2.getNombre();
					
					response.sendRedirect("DatosVen.jsp?producto2="+producto+"&codProd2="+codProd2+"&cant2="+cant2+"&preciou2="+prod2.getPreciov()+"&iva2="+prod2.getIva());
				}else {
					response.sendRedirect("DatosVen.jsp?men=El producto no se encontro");
				}
			}
			
			  if(request.getParameter("confirmar")!=null) {
				double preciop1=Double.parseDouble(request.getParameter("VlrTotal"));  
				double iva1=Double.parseDouble(request.getParameter("iva")); 
				int cant=Integer.parseInt(request.getParameter("Cantidad"));
				String codigo_producto1=request.getParameter("CodProducto1");
				String codigo_producto2=request.getParameter("CodProducto2");
				String codigo_producto3=request.getParameter("CodProducto3");
				float preciop2=Float.parseFloat(request.getParameter("VlrTotal2"));  
				float iva2=Float.parseFloat(request.getParameter("iva2")); 
				int cant2=Integer.parseInt(request.getParameter("Cantidad2"));
				float preciop3=Float.parseFloat(request.getParameter("VlrTotal3"));  
				float iva3=Float.parseFloat(request.getParameter("iva3")); 
				int cant3=Integer.parseInt(request.getParameter("Cantidad3"));
				String cedulausu=request.getParameter("Cedula_usuario");
				String cedulacli=request.getParameter("Cedula");
				if(cant<=0||cant2<=0||cant3<=0) {
					response.sendRedirect("DatosVen.jsp?men=Cantidad errada");
				}else {
					VentasDAO venDao=new VentasDAO();
					
					int codigo = venDao.Codigo_Venta();
		
					double tot,tot2,tot3,totalp,totiva,totalven;
					tot=(preciop1*cant);
					tot2=(preciop2*cant2);	
					tot3=(preciop3*cant3);
					totalp=(tot+tot2+tot3);
					totiva=(tot*iva1)+(tot2*iva2)+(tot3*iva3);	
					totalven=totalp+totiva;
					VentasDTO ven= new VentasDTO(codigo, cedulausu, cedulacli,totiva,totalven, totalp);	
					venDao.insertarventa(ven);
					DetalleVentasDTO det1= new DetalleVentasDTO(cant, codigo,codigo_producto1,iva1,tot,tot*iva1);
					DetalleVentasDTO det2= new DetalleVentasDTO(cant2, codigo,codigo_producto2,iva2,tot2,tot2*iva2);
					DetalleVentasDTO det3= new DetalleVentasDTO(cant3, codigo,codigo_producto3,iva3,tot3,tot3*iva3);
					venDao.insertardetalleventa(det1);
					venDao.insertardetalleventa(det2);
					venDao.insertardetalleventa(det3);
					response.sendRedirect("DatosVen.jsp?codigoventa="+codigo+"&totalp="+totalp+"&totiva="+totiva+"&totalven="+totalven+"&tot="+tot+"&tot2="+tot2+"&tot3="+tot3);		
				}
				  
			  }

				if(request.getParameter("consultarProducto3")!=null) {
					
					int codProd3=Integer.parseInt(request.getParameter("CodProducto3"));
					int cant3=Integer.parseInt(request.getParameter("Cantidad3"));
					ProductoDAO ProDao3= new ProductoDAO();
					ProductoDTO prod3 = ProDao3.Buscar_Producto(codProd3);
					if(prod3!=null) {
						String producto=prod3.getNombre();
						
						response.sendRedirect("DatosVen.jsp?producto3="+producto+"&codProd3="+codProd3+"&cant3="+cant3+"&preciou3="+prod3.getPreciov()+"&iva3="+prod3.getIva());
					}else {
						response.sendRedirect("DatosVen.jsp?men=El producto no se encontro");
					}
				}
	
	
	}

}
