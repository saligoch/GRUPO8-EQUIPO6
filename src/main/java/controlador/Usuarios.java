package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuarios() {
    	 super();
         // TODO Auto-generated constructor stub
     }
 	/**
 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 	 */
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		    	UsuarioDAO usuDao=new UsuarioDAO();
 				
 				if(request.getParameter("insertar")!=null) {
 					
 					int cedula;
 					String email,pasword,usuario,nombre;
 					cedula=Integer.parseInt(request.getParameter("cedula"));
 					email=request.getParameter("email");
 					pasword=request.getParameter("pasword");
 					usuario=request.getParameter("usuario");
 					nombre=request.getParameter("nombre");
 					UsuarioDTO usu=new UsuarioDTO(cedula,email,pasword,usuario,nombre);
 					if(usuDao.Inserta_Usuario(usu)) {
 						JOptionPane.showMessageDialog(null,"Registro de usuario exitoso");
 						response.sendRedirect("Usuario.jsp");
 					}else {
 						JOptionPane.showMessageDialog(null," No se registro el usuario");
 						response.sendRedirect("Usuario.jsp");
 					}
 				}
 				
 				if(request.getParameter("consultar")!=null) {
					int identificacion;
					String email,pasword,usuario,nombre;
					identificacion= Integer.parseInt(request.getParameter("identificacion"));
					UsuarioDTO usu=usuDao.Buscar_Usuario(identificacion);
					if(usu!=null) {
				    identificacion=usu.getCedula();
				    email=usu.getEmail();
				    pasword=usu.getPasword();
				    usuario=usu.getUsuario();				    
					nombre=usu.getNombre();
					response.sendRedirect("Usuario.jsp?identificacion="+identificacion+"&&email="+email+"&&pasword="+pasword+"&&usuario="+usuario+"&&nombre="+nombre);
					}else {
					response.sendRedirect("Usuario.jsp?men=El Usuario no se encontro.");
				    }
	       
	            }
 				if(request.getParameter("actualizar")!=null) {
					int cedula=0;
					String email,nombre,password,usuario;
					cedula= Integer.parseInt(request.getParameter("cedula"));
					email=request.getParameter("email");
					nombre=request.getParameter("nombre");
					password=request.getParameter("pasword");
					usuario=request.getParameter("usuario");
					UsuarioDTO usuDto_Act= new UsuarioDTO(cedula,email,nombre,password,usuario);
					if(usuDao.Actualizar_Usuario(usuDto_Act)) {
						response.sendRedirect("Usuario.jsp?men= Usuario actualizado exitosamente.");
						
					}else {
						response.sendRedirect("Cliente.jsp?men=El usiuario no se modifico.");
					}
                }

 				if(request.getParameter("eliminar")!=null) {         
 				    int cedula; 
 				   cedula = Integer.parseInt(request.getParameter("cedula"));
 				    int op=JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario con cedula : "+cedula); 
 				    if(op==0) {
 				    	if(UsuarioDAO.Eliminar_usuario(cedula)) { 
 				                response.sendRedirect("Usuario.jsp?men=Usuario eliminado"); 
 				            }else { 
 				                response.sendRedirect("Usuario.jsp?men=El usuario no se eliminó"); 
 				            } 
 				            }else if (op==1){ 
 				                response.sendRedirect("Usuario.jsp?men=El usuario no se eliminó");

 				                } else {
 				                	response.sendRedirect("Usuario.jsp");             
 				                	}         
 				    }

           }			
				
     }

		    			
	  
	



 
