package co.edu.uco.gestorgimnasio.data.dao.base;

import java.sql.Connection;

public class SQLDAO {
	
	private Connection conexion;
	
	protected SQLDAO(final Connection conexion) {
		setConexion(conexion);
	}
	
	
	private final void setConexion(final Connection conexion) {
		//TODO:
		this.conexion = conexion;
	}

	protected final Connection getConexion() {
		return conexion;
	}
}
