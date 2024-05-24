package co.edu.uco.tiendachepito.business.usecase.concrete;

import java.util.List;

import co.edu.uco.tiendachepito.business.assembler.entity.concrete.CiudadEntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.usecase.RegistrarCiudad;
import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.BusinessTiendaChepitoException;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.entity.CiudadEntity;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

public final class RegistrarCiudadImpl implements RegistrarCiudad {
	
	private final DAOFactory factory;
	
	public RegistrarCiudadImpl(final DAOFactory factory) {
		this.factory = factory;
		
	}

	@Override
	public final void ejecutar(final CiudadDomain ciudad) {
		//1. Validar que los datos sean validos a nivel de tipo de dato, longitud, obligatoriedad
		// formato, rango
		//2. No debe exisitir una ciudad con el mismo nombre para el mismo departamento
		validarNoExistenciaCiudad(ciudad.getNombre(), ciudad.getDepartamento().getId());
		//3. Guardar la informacion de la nueva ciudad
		var ciudadEntity = CiudadEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(ciudad);
		factory.getCiudadDAO().crear(ciudadEntity);
	}
	
	private void validarNoExistenciaCiudad(String nombreCiudad, int idDepartamento) {
		var departamentoEntity = DepartamentoEntity.build(idDepartamento);
		var ciudadEntity = CiudadEntity.build(0, nombreCiudad, departamentoEntity);
		
		final List<CiudadEntity> resultados = factory.getCiudadDAO().consultar(ciudadEntity);
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe una ciudad con el nombre \"{1}\" asociada al departamento";
			throw new BusinessTiendaChepitoException(mensajeUsuario);
		}
		
		
	}

}
