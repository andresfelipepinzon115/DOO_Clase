package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.PaisEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public final class PaisAzureSqlDAO extends SqlConnection implements PaisDAO {
    public PaisAzureSqlDAO(final Connection connection) {
        super(connection);
    }


    @Override
    public void actualizar(final PaisEntity entidad) {
        //cambiar nombre de pais con codigo 1 a 'Venezuela'
        final var sentencia = new StringBuilder();
        sentencia.append("UPDATE PAIS SET Nombre = 'Venezuela' WHERE ID = 1");

    }

    @Override
    public List<PaisEntity> consultar(final PaisEntity entidad) {
        //Consultar pais con codigo 1
        final var sentencia = new StringBuilder();
        sentencia.append("SELECT id, nombre FROM PAIS");
        sentencia.append("ORDER BY id ASC");
        return null;


    }

    @Override
    public void crear(final PaisEntity entidad) {
        final var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO PAIS (Nombre) ");
        sentenciaSQL.append("VALUES (?)");

        try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var menajeUsuaario = "No ha sido posible llevar a cabo el registro de la informacion del nuevo Pais, intente de  nuevo y en caso de persistir el problema comuniquese con el administrador de la aplicacion de la tienda chepito";//Este no va en base, va en externo
            var menajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023,entidad.getNombre());//Este no va en base, va en externo
            throw new DataTiendaChepitoException(menajeTecnico, menajeUsuaario, exception);
        }catch (Exception exception) {
            var menajeUsuaario = "No ha sido posible llevar a cabo el registro de la informacion del nuevo Pais, intente de  nuevo y en caso de persistir el problema comuniquese con el administrador de la aplicacion de la tienda chepito";//Este no va en base, va en externo
            var menajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024,entidad.getNombre());//Este no va en base, va en externo
            throw new DataTiendaChepitoException(menajeTecnico, menajeUsuaario, exception);
        }
        
    }

    @Override
    public void eliminar(final int id) {
        //Eliminar pais con codigo 1
        final var sentencia = new StringBuilder();
        sentencia.append("DELETE FROM PAIS WHERE ID = 1");

    }
}
