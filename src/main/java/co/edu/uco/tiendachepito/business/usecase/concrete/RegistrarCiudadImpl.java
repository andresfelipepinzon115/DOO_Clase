package co.edu.uco.tiendachepito.business.usecase.concrete;

import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.usecase.RegistrarCiudad;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;

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
		//3. Guardar la informacion de la nueva ciudad
	}

}
