package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.CiudadEntity;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public final class DepartamentoEntityDomainAssembler implements EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity>{
	
	private static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> instancia = new DepartamentoEntityDomainAssembler();
	private DepartamentoEntityDomainAssembler() {
		super();
	}
	
	public static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> obtenerInstancia(){
		return instancia;
	}

	private static final EntityDomainAssembler<PaisDomain, PaisEntity> paisAssembler = PaisEntityDomainAssembler.obtenerInstancia();
	@Override
	
	public final DepartamentoDomain ensamblarDominio(final DepartamentoEntity entidad) {
		var DepartamentoEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, DepartamentoEntity.build(0));
		var paisDominio = paisAssembler.ensamblarDominio(DepartamentoEntityTmp.getPais());
		return DepartamentoDomain.crear(DepartamentoEntityTmp.getId(),DepartamentoEntityTmp.getNombre(), paisDominio);
	}

	@Override
	public final DepartamentoEntity ensamblarEntidad(final DepartamentoDomain dominio) {
		var DepartamentoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, DepartamentoDomain.crear());
		var paisEntity = paisAssembler.ensamblarEntidad(DepartamentoDomainTmp.getPais());
		return DepartamentoEntity.build(DepartamentoDomainTmp.getId(), DepartamentoDomainTmp.getNombre(), paisEntity);
		
	}

}
