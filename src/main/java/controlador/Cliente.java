package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

/**
 * Servlet implementation class Cliente
 
@WebServlet("/Cliente")
*/
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    	ClienteDAO cliDao=new ClienteDAO();
				
				if(request.getParameter("insertar")!=null) {
					
					int cedula;
					String direccion,email,nombre,telefono;
					cedula=Integer.parseInt(request.getParameter("cedula"));
					direccion=request.getParameter("direccion");
					email=request.getParameter("email");
					nombre=request.getParameter("nombre");
					telefono=request.getParameter("telefono");
					ClienteDTO cli=new ClienteDTO(cedula,direccion, email, nombre,telefono);
					if(cliDao.Inserta_Cliente(cli)) {
						JOptionPane.showMessageDialog(null,"Registro de cliente exitoso");
						response.sendRedirect("Cliente.jsp");
					}else {
						JOptionPane.showMessageDialog(null," No se registro el cliente");
						response.sendRedirect("Cliente.jsp");
					}
				}
				if(request.getParameter("consultar")!=null) {
					int identificacion;
					String direccion,email,nombre,telefono;
					identificacion= Integer.parseInt(request.getParameter("identificacion"));
					ClienteDTO cli=cliDao.Buscar_Cliente(identificacion);
					if(cli!=null) {
				    identificacion=cli.getCedula();
					direccion=cli.getDireccion();
					email=cli.getEmail();
					nombre=cli.getNombre();
					telefono=cli.getTelefono();
					response.sendRedirect("Cliente.jsp?identificacion="+identificacion+"&&direccion="+direccion+"&&email="+email+"&&nombre="+nombre+"&&telefono="+telefono);
					}else {
					response.sendRedirect("Cliente.jsp?men=El Cliente no se encontro.");
				    }
	       
	            }
				if(request.getParameter("actualizar")!=null) {
					int cedula=0;
					String direccion,email,nombre,telefono;
					cedula= Integer.parseInt(request.getParameter("cedula"));
					direccion= request.getParameter("direccion");
					email=request.getParameter("email");
					nombre=request.getParameter("nombre");
					telefono=request.getParameter("telefono");
					ClienteDTO cliDto_Act= new ClienteDTO(cedula,direccion,email,nombre,telefono);
					if(cliDao.Actualizar_Cliente(cliDto_Act)) {
						response.sendRedirect("Cliente.jsp?men=Cliente actualizado exitosamente.");
						
			
					}else {
						response.sendRedirect("Cliente.jsp?men=El cliente no se modifico.");
					}
				}
				if(request.getParameter("eliminar")!=null) {         
 				    int cedula; 
 				    cedula = Integer.parseInt(request.getParameter("cedula"));
 				    int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente con cedula : "+cedula); 
 				    if(op==0) {
 				    	if(ClienteDAO.Eliminar_cliente(cedula)) { 
 				                response.sendRedirect("Cliente.jsp?men=Cliente eliminado"); 
 				            }else { 
 				                response.sendRedirect("Cliente.jsp?men=El cliente no se eliminó"); 
 				            } 
 				            }else if (op==1){ 
 				                response.sendRedirect("Cliente.jsp?men=El cliente no se eliminó");

 				                } else {
 				                	response.sendRedirect("Cliente.jsp");             
 				                	}         
 				    }
           }			
           }			



		    			
	  
	


