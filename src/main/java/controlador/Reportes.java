package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ClienteDAO;
import Modelo.ReportesDAO;

/**
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		;
		if(request.getParameter("Listadousuarios")!=null) {         
			  
			    ReportesDAO repDao=new ReportesDAO();
			    String [][] usuarios= repDao.reporte_usuarios();
			    
			    
			    if(usuarios.length>0) {
			    	request.setAttribute("usuarios",usuarios);
			    	request.getRequestDispatcher("Reportes.jsp?usuarios=").forward(request, response);
			                //response.sendRedirect("Reportes.jsp?usuarios="); 
			    }   else {
			    	JOptionPane.showMessageDialog(null," No hay usuarios creados");
					response.sendRedirect("Reportes.jsp");
			    }
			   }
		if(request.getParameter("Ventasclientes")!=null) {         
			  
		    ReportesDAO repDao=new ReportesDAO();
		    String [][] ventasclientes= repDao.reporte_ventascliente();
		    
		    
		    if(ventasclientes.length>0) {
		    	request.setAttribute("ventasclientes",ventasclientes);
		    	request.getRequestDispatcher("Reportes.jsp?ventasclientes=").forward(request, response);
		                //response.sendRedirect("Reportes.jsp?usuarios="); 
		    }   else {
		    	JOptionPane.showMessageDialog(null," No hay ventas del cliente");
				response.sendRedirect("Reportes.jsp");
		    }
		   }
		if(request.getParameter("Listadoclientes")!=null) {         
			  
		    ReportesDAO repDao=new ReportesDAO();
		    String [][] clientes= repDao.reporte_clientes();
		    
		    
		    if(clientes.length>0) {
		    	request.setAttribute("clientes",clientes);
		    	request.getRequestDispatcher("Reportes.jsp?clientes=").forward(request, response);
		           
		    }   else {
		    	JOptionPane.showMessageDialog(null," No hay clientes creados");
				response.sendRedirect("Reportes.jsp");
		    }
		   }
	}

}
