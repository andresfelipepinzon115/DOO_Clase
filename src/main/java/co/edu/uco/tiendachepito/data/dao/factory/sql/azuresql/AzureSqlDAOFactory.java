package co.edu.uco.tiendachepito.data.dao.factory.sql.azuresql;

import co.edu.uco.tiendachepito.crosscutting.helpers.SQLhelper;
import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.dao.sql.azuresql.CiudadAzureSqlDAO;
import co.edu.uco.tiendachepito.data.dao.sql.azuresql.DepartamentoAzureSqlDAO;
import co.edu.uco.tiendachepito.data.dao.sql.azuresql.PaisAzureSqlDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AzureSqlDAOFactory  extends DAOFactory{
    private Connection connection;

    public AzureSqlDAOFactory(){
        obtenerConeccion();
    }

    @Override
    protected void obtenerConeccion() {
        final String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";
        try {
            connection = DriverManager.getConnection(connectionUrl);
        }catch (final SQLException exception){
            //TODO: Manejo de excepciones

        }catch (final Exception exception){
        //TODO: Manejo de excepciones


    }

    @Override
    public void iniciarTransaccion() {
        SQLhelper.initTransaction(connection);

    }

    @Override
    public void confirmarTransaccion() {

        SQLhelper.commit(connection);

    }

    @Override
    public void cancelarTransaccion() {

        SQLhelper.rollback(connection);

    }

    @Override
    public void cerrarConeccion() {

        SQLhelper.close(connection);

    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisAzureSqlDAO(connection);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoAzureSqlDAO(connection);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadAzureSqlDAO(connection);
    }
}


