package Modelo;

public class ProveedorDTO {
	private int Nit;
	private String Ciudad;
	private String Direccion;
	private String Nombre;
	private String Telefono;
	
	public ProveedorDTO(int nit,String ciudad, String direccion, String nombre,String telefono) {
		Nit = nit;
		Ciudad=ciudad;
		Direccion=direccion;
		Nombre=nombre;
		Telefono=telefono;
						
	}

	public int getNit() {
		return Nit;
	}

	public void setNit(int nit) {
		Nit = nit;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
}
	
