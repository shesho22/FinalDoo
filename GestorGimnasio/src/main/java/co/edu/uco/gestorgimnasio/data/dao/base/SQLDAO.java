package co.edu.uco.gestorgimnasio.data.dao.base;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLDAO {

    private Connection conexion;

    protected SQLDAO(final Connection conexion) {
        setConexion(conexion);
    }

    private final void setConexion(final Connection conexion) {
        this.conexion = conexion;
    }

    protected final Connection getConexion() {
        return conexion;
    }

    protected void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
