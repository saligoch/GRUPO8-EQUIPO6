package Modelo;

public class UsuarioDTO {
		
	private int Cedula;
	private String Email;
	private String Pasword;
	private String Usuario;
	private String Nombre;
	
	public UsuarioDTO(int cedula,String email, String pasword, String usuario,String nombre) {
		Cedula = cedula;
		Email=email;
		Pasword=pasword;		
		Usuario=usuario;
		Nombre=nombre;
						
	}

	public int getCedula() {
		return Cedula;
	}

	public void setCedula(int cedula) {
		Cedula = cedula;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPasword() {
		return Pasword;
	}

	public void setPasword(String pasword) {
		Pasword = pasword;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
}