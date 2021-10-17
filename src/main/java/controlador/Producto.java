package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;


/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
@MultipartConfig
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
   
        }if(request.getParameter("actualizar")!=null) {
        	int codpro,nit_proveedor;
			float iva,precioc, preciov;
			String nombre;
			codpro=Integer.parseInt(request.getParameter("codpro"));
			iva=Float.parseFloat(request.getParameter("iva").replace(",","."));
			nit_proveedor=Integer.parseInt(request.getParameter("nit_proveedor"));
			nombre=request.getParameter("nombre");
			precioc=Float.parseFloat(request.getParameter("precioc").replace(",","."));
			preciov=Float.parseFloat(request.getParameter("preciov").replace(",","."));
			ProductoDTO prodDto_Act= new ProductoDTO(codpro,iva,nit_proveedor,nombre, precioc, preciov);
			if(prodDao.Actualizar_Producto(prodDto_Act)) {
				response.sendRedirect("Producto.jsp?men= Producto actualizado exitosamente.");
				
			}else {
				response.sendRedirect("producto.jsp?men=El producto no se modifico.");
			}
   }	
        
		
		if (request.getParameter("cargar")!=null) {
			
			Part archivo= request.getPart("archivo");
			
			String Url="D:/MINTIC PYTHON- SANDRA/PROGRAMACION/CICLO 3/Proyecto3/src/main/webapp/Documentos/";
			
			if(archivo.getContentType().equals("application/vnd.ms-excel")) {
			try {
			InputStream file=archivo.getInputStream();
			File copia=new File(Url+"producto.csv");
			FileOutputStream escribir= new FileOutputStream(copia);	
			int num = file.read();
			while(num !=-1) {
				escribir.write(num);
				num=file.read();
			}
			file.close();
			escribir.close();
			JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
			if(prodDao.Cargar_Productos(Url+"producto.csv")) {
			    response.sendRedirect("Producto.jsp?men=Se registro los productos correctamente");
			}else
			{
				response.sendRedirect("Producto.jsp?men= No se registro los productos correctamente");
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar el archivo: "+ e);
				response.sendRedirect("Producto.jsp?men=Error al cargar el archivo");
			}
			}else
			{
			    response.sendRedirect("Producto.jsp?men=Formato de archivo no permitido");
		}
   }
		if(request.getParameter("eliminar")!=null) {         
			    int codpro; 
			    codpro = Integer.parseInt(request.getParameter("codpro"));
			    int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el producto con codigo : "+codpro); 
			    if(op==0) {
			    	if(ProductoDAO.Eliminar_producto(codpro)) { 
			                response.sendRedirect("Producto.jsp?men=Producto eliminado"); 
			            }else { 
			                response.sendRedirect("Producto.jsp?men=El producto no se eliminó"); 
			            } 
			            }else if (op==1){ 
			                response.sendRedirect("Producto.jsp?men=El producto no se eliminó");

			                } else {
			                	response.sendRedirect("producto.jsp");             
			                	}         
			    }
   }			
 
}

