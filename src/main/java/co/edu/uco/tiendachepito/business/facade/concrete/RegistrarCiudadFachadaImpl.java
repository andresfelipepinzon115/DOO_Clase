package co.edu.uco.tiendachepito.business.facade.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.concrete.CiudadDTODomainAssembler;
import co.edu.uco.tiendachepito.business.facade.RegistrarCiudadFachada;
import co.edu.uco.tiendachepito.business.usecase.RegistrarCiudad;
import co.edu.uco.tiendachepito.business.usecase.concrete.RegistrarCiudadImpl;
import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.BusinessTiendaChepitoException;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.dao.factory.enums.Factory;
import co.edu.uco.tiendachepito.dto.CiudadDTO;

public class RegistrarCiudadFachadaImpl implements RegistrarCiudadFachada{
	
	private DAOFactory factory;
	
	public RegistrarCiudadFachadaImpl() {
		factory= DAOFactory.getFactory(Factory.AZURE_SQL);
	}
	
	

	@Override
	public final void ejecutar(final CiudadDTO ciudad) {
		try {
			factory .iniciarTransaccion();
			
			var ciudadDomain = CiudadDTODomainAssembler.obtenerInstancia().ensamblarDominio(ciudad);
			
			final RegistrarCiudad useCase = new RegistrarCiudadImpl(factory);
			useCase.ejecutar(ciudadDomain);
			
			factory.confirmarTransaccion();
		}catch (TiendaChepitoException excepcion) {
			factory.cancelarTransaccion();
			throw excepcion;
			
		}catch(final Exception excepcion) {
			factory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva informacion de la ciudad";
			var mensajeTecnico = "Se ha presentado un problema tratando de registar la informacion de la nueva ciudad en el metodo Ejecutar de la clase RegistrarCiudadFachadaImpl, porfavor siga la traza completa del problema...";
			
			throw new BusinessTiendaChepitoException(mensajeTecnico,mensajeUsuario);
		}finally {
			factory.cerrarConeccion();
		}
		
	}

}
