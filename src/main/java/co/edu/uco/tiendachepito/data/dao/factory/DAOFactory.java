package co.edu.uco.tiendachepito.data.dao.factory;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.CrosscuttingTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.factory.enums.Factory;
import co.edu.uco.tiendachepito.data.dao.factory.sql.azuresql.AzureSqlDAOFactory;

public  abstract class DAOFactory {
    public static final DAOFactory getFactory(final Factory factory) {
        switch (factory) {
            case AZURE_SQL:
                return new AzureSqlDAOFactory();
            case SQL_SERVER:{
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe configuerada una factoria de datos para una base SQL_SERVER";
                throw new CrosscuttingTiendaChepitoException(mensajeUsuario, mensajeTecnico);}

            case MYSQL:{
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe configuerada una factoria de datos para una base MYSQL";
                throw new CrosscuttingTiendaChepitoException(mensajeUsuario, mensajeTecnico);}

            case ORACLE:{
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe configuerada una factoria de datos para una base deseada ORACLE";
                throw new CrosscuttingTiendaChepitoException(mensajeUsuario, mensajeTecnico);}
            default:
                return new AzureSqlDAOFactory();
        }}

    protected abstract void obtenerConeccion();
    public abstract void iniciarTransaccion();
    public abstract void confirmarTransaccion();
    public abstract void cancelarTransaccion();
    public abstract void cerrarConeccion();

    public abstract PaisDAO getPaisDAO();
    public  abstract DepartamentoDAO getDepartamentoDAO();
    public abstract CiudadDAO getCiudadDAO();

}
