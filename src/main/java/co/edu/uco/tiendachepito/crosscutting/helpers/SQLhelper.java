package co.edu.uco.tiendachepito.crosscutting.helpers;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.CrosscuttingTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;

import java.sql.Connection;
import java.sql.SQLException;

public  final class SQLhelper {

    private SQLhelper() {
        super();
    }
    public  static  final boolean IsNull(final Connection connection) {
        return ObjectHelper.getObjectHelper().isNull(connection);

    }
    public  static  final boolean isOpen(final  Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00009);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            connection.close();
        } catch (final CrosscuttingTiendaChepitoException exception) {
            throw exception;
        } catch (final SQLException exception) {
            var menajeUsuaario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var menajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000010);

            throw new CrosscuttingTiendaChepitoException(menajeTecnico, menajeUsuaario, exception);
        } catch (final Exception exception) {
            var menajeUsuaario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var menajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000011);

            throw new CrosscuttingTiendaChepitoException(menajeTecnico, menajeUsuaario, exception);
        }}




    public static final void commit(final  Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000012);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            if (connection.getAutoCommit()){
                var menajeUsuaario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var menajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000013);
                throw new CrosscuttingTiendaChepitoException(menajeTecnico, menajeUsuaario);
            }connection.commit();}
        catch (final CrosscuttingTiendaChepitoException exception) {
            throw exception;
        }
        catch (final SQLException exception) {
            var menajeUsuaario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var menajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000014);
            throw new CrosscuttingTiendaChepitoException(menajeTecnico, menajeUsuaario, exception);
        }
        catch (final Exception exception) {
            var menajeUsuaario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var menajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000015);
            throw new CrosscuttingTiendaChepitoException(menajeTecnico, menajeUsuaario, exception);
        }
    }
    public static final void close(final  Connection connection) {
        
    }
    public static final void rollback(final  Connection connection) {



    }
    public static final void initTransaction(final  Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000016);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            Connection.setAutoCommit(false);
        } catch (final CrosscuttingTiendaChepitoException exception) {
            throw exception;

        }


        }
}
