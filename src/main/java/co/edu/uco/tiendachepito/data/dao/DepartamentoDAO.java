package co.edu.uco.tiendachepito.data.dao;

import co.edu.uco.tiendachepito.data.dao.general.ActualizarDAO;
import co.edu.uco.tiendachepito.data.dao.general.ConsultarDAO;
import co.edu.uco.tiendachepito.data.dao.general.CrearDAO;
import co.edu.uco.tiendachepito.data.dao.general.EliminarDAO;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public interface DepartamentoDAO extends CrearDAO<DepartamentoEntity>, ConsultarDAO<DepartamentoEntity>, ActualizarDAO<DepartamentoEntity>, EliminarDAO {

    }
