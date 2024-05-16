package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.PaisEntity;

import java.sql.Connection;
import java.util.List;

public  final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {
    public CiudadAzureSqlDAO(final Connection connection) {
        super(connection);
    }
    @Override
    public void actualizar(final PaisEntity entidad) {

    }

    @Override
    public List<PaisEntity> consultar(final PaisEntity entidad) {
        return List.of();
    }

    @Override
    public void crear(final PaisEntity entidad) {

    }

    @Override
    public void eliminar(final int id) {

    }
}
