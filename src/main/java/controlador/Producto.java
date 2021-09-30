package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import Modelo.ProductoDAO;
import Modelo.ProductoDTO;

/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDAO prodDao=new ProductoDAO();
		
		if(request.getParameter("insertar")!=null) {
			int codpro,nit_proveedor;
			float iva,precioc, preciov;
			String nombre;
			codpro=Integer.parseInt(request.getParameter("codpro"));
			iva=Float.parseFloat(request.getParameter("iva").replace(",","."));
			nit_proveedor=Integer.parseInt(request.getParameter("nit_proveedor"));
			nombre=request.getParameter("nombre");
			precioc=Float.parseFloat(request.getParameter("precioc").replace(",","."));
			preciov=Float.parseFloat(request.getParameter("preciov").replace(",","."));
			ProductoDTO prod=new ProductoDTO(codpro,iva,nit_proveedor,nombre, precioc, preciov);
			if(prodDao.Inserta_Producto(prod)) {
				JOptionPane.showMessageDialog(null,"Registro de producto exitoso");
				response.sendRedirect("Producto.jsp");
			}else {
				JOptionPane.showMessageDialog(null," No se registro el producto");
				response.sendRedirect("Producto.jsp");
			}
		}
		if(request.getParameter("consultar")!=null) {
			int identificacion,nit_proveedor;
			float iva,precioc, preciov;
			String nombre;
			identificacion= Integer.parseInt(request.getParameter("identificacion"));
			ProductoDTO prod=prodDao.Buscar_Producto(identificacion);
			if(prod!=null) {
		    identificacion=prod.getCodpro();
			iva=prod.getIva();
			nit_proveedor=prod.getNit_proveedor();
			nombre=prod.getNombre();
			precioc=prod.getPrecioc();
			preciov=prod.getPreciov();
			response.sendRedirect("Producto.jsp?identificacion="+identificacion+"&&iva="+iva+"&&nit_proveedor="+nit_proveedor+"&&nombre="+nombre+"&&precioc="+precioc+"&&preciov="+preciov);
			}else {
			response.sendRedirect("Producto.jsp?men=El producto no se encontro.");
		    }
   
        }
   }			
		
}
