package Modelo;

public class VentasDTO {
	
	private int codigo_venta;
	private String cedulausuario;
	private String cedulacliente;
	private double valorventa;
	private double totalventa;
	private double iva;
	public VentasDTO(int codigo_venta,  String cedulausuario, String cedulacliente, double iva, double totalventa,double valorventa) {
		super();	
		this.codigo_venta = codigo_venta;
		this.cedulausuario = cedulausuario;
		this.cedulacliente = cedulacliente;
		this.valorventa = valorventa;
		this.totalventa = totalventa;
		this.iva = iva;
	}
	
	public int getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public String getCedulausuario() {
		return cedulausuario;
	}
	public void setCedulausuario(String cedulausuario) {
		this.cedulausuario = cedulausuario;
	}
	public String getCedulacliente() {
		return cedulacliente;
	}
	public void setCedulacliente(String cedulacliente) {
		this.cedulacliente = cedulacliente;
	}
	public double getValorventa() {
		return valorventa;
	}
	public void setValorventa(double valorventa) {
		this.valorventa = valorventa;
	}
	public double getTotalventa() {
		return totalventa;
	}
	public void setTotalventa(double totalventa) {
		this.totalventa = totalventa;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}

	


}
