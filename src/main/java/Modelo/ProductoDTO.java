package Modelo;

public class ProductoDTO {

	private int Codpro;
	private int Nit_proveedor;
	private float Iva;
	private String Nombre;
    private float Precioc;
    private float Preciov;
	
		
	public ProductoDTO(int codpro,  float iva, int nit_proveedor,String nombre,float precioc, float preciov) {
		Codpro=codpro;
		Iva=iva;
		Nit_proveedor=nit_proveedor;
		Nombre=nombre;
		Precioc=precioc;
		Preciov=preciov;
						
	}


	public int getCodpro() {
		return Codpro;
	}


	public void setCodpro(int codpro) {
		Codpro = codpro;
	}


	public int getNit_proveedor() {
		return Nit_proveedor;
	}


	public void setNit_proveedor(int nit_proveedor) {
		Nit_proveedor = nit_proveedor;
	}


	public float getIva() {
		return Iva;
	}


	public void setIva(float iva) {
		Iva = iva;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public float getPrecioc() {
		return Precioc;
	}


	public void setPrecioc(float precioc) {
		Precioc = precioc;
	}


	public float getPreciov() {
		return Preciov;
	}


	public void setPreciov(float preciov) {
		Preciov = preciov;
	}
}

	
