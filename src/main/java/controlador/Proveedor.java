package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;

/**
 * Servlet implementation class Proveedor
*/
@WebServlet("/Proveedor")

public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProveedorDAO proDao=new ProveedorDAO();
		
		if(request.getParameter("insertar")!=null) {
			
			int nit;
			String ciudad,direccion,nombre,telefono;
			nit=Integer.parseInt(request.getParameter("nit"));
			ciudad=request.getParameter("ciudad");
			direccion=request.getParameter("direccion");
			nombre=request.getParameter("nombre");
			telefono=request.getParameter("telefono");
			ProveedorDTO pro=new ProveedorDTO(nit,ciudad, direccion, nombre,telefono);
			if(proDao.Inserta_Proveedor(pro)) {
				JOptionPane.showMessageDialog(null,"Registro de proveedor exitoso");
				response.sendRedirect("Proveedores.jsp");
			}else {
				JOptionPane.showMessageDialog(null," No se proveedor el proveedor");
				response.sendRedirect("Proveedores.jsp");
			}
		}
		if(request.getParameter("consultar")!=null) {
			int identificacion;
			String ciudad,direccion,nombre,telefono;
			identificacion= Integer.parseInt(request.getParameter("identificacion"));
			ProveedorDTO pro=proDao.Buscar_Proveedor(identificacion);
			if(pro!=null) {
		    identificacion=pro.getNit();
			ciudad=pro.getCiudad();
			direccion=pro.getDireccion();
			nombre=pro.getNombre();
			telefono=pro.getTelefono();
			response.sendRedirect("Proveedores.jsp?identificacion="+identificacion+"&&ciudad="+ciudad+"&&direccion="+direccion+"&&nombre="+nombre+"&&telefono="+telefono);
			}else {
			response.sendRedirect("Proveedores.jsp?men=El proveedor no se encontro.");
		    }
   
        }
		if(request.getParameter("actualizar")!=null) {
			int nit=0;
			String ciudad,direccion,nombre,telefono;
			nit= Integer.parseInt(request.getParameter("nit"));
			ciudad=request.getParameter("ciudad");
			direccion= request.getParameter("direccion");
			nombre=request.getParameter("nombre");
			telefono=request.getParameter("telefono");
			ProveedorDTO proDto_Act= new ProveedorDTO(nit,ciudad,direccion,nombre,telefono);
			if(proDao.Actualizar_Proveedor(proDto_Act)) {
				response.sendRedirect("Proveedores.jsp?men= Proveedor actualizado exitosamente.");
				
			}else {
				response.sendRedirect("Proveedores.jsp?men=El proveedor no se modifico.");
			}
   }	
		if(request.getParameter("eliminar")!=null) {         
		    int nit; 
		    nit = Integer.parseInt(request.getParameter("nit"));
		    int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el proveedor con Nit : "+nit); 
		    if(op==0) {
		    	if(ProveedorDAO.Eliminar_proveedor(nit)) { 
		                response.sendRedirect("Proveedores.jsp?men=Proveedor eliminado"); 
		            }else { 
		                response.sendRedirect("Proveedores.jsp?men=El proveedor no se eliminó"); 
		            } 
		            }else if (op==1){ 
		                response.sendRedirect("Proveedores.jsp?men=El proveedor no se eliminó");

		                } else {
		                	response.sendRedirect("Proveedores.jsp");             
		                	}         
		    }
   }			
		
}
