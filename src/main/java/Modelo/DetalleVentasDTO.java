package Modelo;

public class DetalleVentasDTO {
	
	private int codigo_detalle_venta;
	private int cantidad_producto;
	private double codigo_venta;
	private double valor_total;
	private double valor_venta;
	private double valoriva;
	private String codigo_producto;
	public DetalleVentasDTO(int cantidad_producto, double codigo_venta, String codigo_producto,double valoriva,double valor_total,double valor_venta) {
		super();
		this.cantidad_producto = cantidad_producto;
		this.valoriva = valoriva;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.codigo_venta = codigo_venta;
		this.codigo_producto = codigo_producto;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public int getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(int codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	public int getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public double getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(double codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public double getValoriva() {
		return valoriva;
	}
	public void setValoriva(double valoriva) {
		this.valoriva = valoriva;
	}
	public String getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	
	


}
