package uam.bd.restaurante.model;

public class LineaPedido {

	private int idPedido;
	private float valorUnit;
	private Producto producto;
	private int cantidad;
	
	public LineaPedido(int idPedido, float valorUnit, Producto producto, int cantidad) {
		this.idPedido = idPedido;
		this.valorUnit = valorUnit;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public LineaPedido(int int1, float float1, String string, int int2) {
		// TODO Auto-generated constructor stub
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getSubTotal() {
		
		return this.producto.getValor()*cantidad;
		
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public float getValorUnit() {
		return valorUnit;
	}
	public void setValorUnit(float valorUnit) {
		this.valorUnit = valorUnit;
	}
	
	public String getIdProducto() {
		return producto.getCodigo();
	}
	@Override
    public String toString() {
        return "productos_pedido{" + "id_pedido=" + getIdPedido() + ", id_producto='" + producto.getCodigo() + ", cantidad='" +
            getCantidad() + ", valor_un='" + producto.getValor() + "'}";
    }
    
    @Override
    public boolean equals(final Object that) {
        boolean isEqual = false;
        if (this == that) {
            isEqual = true;
        } else if (that != null && getClass() == that.getClass()) {
            final LineaPedido customer = (LineaPedido) that;
            if (getIdPedido() == customer.getIdPedido()) {
                isEqual = true;
            }
        }
        return isEqual;
    }
}
