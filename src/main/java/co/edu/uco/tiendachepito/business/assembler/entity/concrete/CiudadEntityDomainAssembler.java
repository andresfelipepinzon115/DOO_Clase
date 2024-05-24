package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.assembler.dto.concrete.CiudadDTODomainAssembler;
import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.CiudadDTO;
import co.edu.uco.tiendachepito.entity.CiudadEntity;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public class CiudadEntityDomainAssembler implements EntityDomainAssembler<CiudadDomain, CiudadEntity> {
	
	public static final EntityDomainAssembler<CiudadDomain, CiudadEntity> instancia = new CiudadEntityDomainAssembler();
	private CiudadEntityDomainAssembler() {
		super();
	}
	
	public static final EntityDomainAssembler<CiudadDomain, CiudadEntity> obtenerInstancia(){
		return instancia;
	}
	private static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> departamentoAssembler = DepartamentoEntityDomainAssembler.obtenerInstancia();
	@Override
	
	public final CiudadDomain ensamblarDominio(final CiudadEntity entidad) {
		var CiudadEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, CiudadEntity.build(0));
		var DepartamentoDominio = departamentoAssembler.ensamblarDominio(CiudadEntityTmp.getDepartamento());
		return CiudadDomain.crear(CiudadEntityTmp.getId(),CiudadEntityTmp.getNombre(), DepartamentoDominio);
	}

	@Override
	public final CiudadEntity ensamblarEntidad(final CiudadDomain dominio) {
		var CiudadDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CiudadDomain.crear());
		var DepartamentoEntity = departamentoAssembler.ensamblarEntidad(CiudadDomainTmp.getDepartamento());
		return CiudadEntity.build(CiudadDomainTmp.getId(), CiudadDomainTmp.getNombre(), DepartamentoEntity);
	}
	
	

}
