package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.PaisDTO;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public final class PaisEntityDomainAssembler implements EntityDomainAssembler<PaisDomain, PaisEntity>{

	@Override
	public final PaisDomain ensamblarDominio(final PaisEntity entidad) {
		var paisEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, PaisEntity.build(0));
		return PaisDomain.crear(paisEntityTmp.getId(),paisEntityTmp.getNombre());
	}

	@Override
	public final PaisEntity ensamblarEntidad(final PaisDomain dominio) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, PaisDomain.crear());
		return PaisEntity.build(paisDomainTmp.getId(), paisDomainTmp.getNombre());
	}

}
