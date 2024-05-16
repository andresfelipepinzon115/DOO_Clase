package co.edu.uco.tiendachepito.data.dao.sql;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.crosscutting.helpers.SQLhelper;

import java.sql.Connection;

public class SqlConnection {
    private Connection connection;
    protected SqlConnection(final Connection connection) {
        setConnection(connection);
    }
    private final void setConnection(final Connection connection) {
        if(!SQLhelper.isOpen(connection)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "No es posible crear el DAO deseado, dado que la conexion esta cerrada";
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
        }
        this.connection = connection;
    }
    protected final Connection getConnection() {
        return connection;
    }
}

