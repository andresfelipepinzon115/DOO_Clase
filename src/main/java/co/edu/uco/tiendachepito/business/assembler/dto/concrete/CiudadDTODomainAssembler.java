package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.CiudadDTO;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;
import co.edu.uco.tiendachepito.dto.PaisDTO;

public class CiudadDTODomainAssembler implements DTODomainAssembler <CiudadDomain, CiudadDTO>{
	
	public static final DTODomainAssembler<CiudadDomain, CiudadDTO> instancia = new CiudadDTODomainAssembler();
	
	private static final DTODomainAssembler<DepartamentoDomain, DepartamentoDTO> DepartamentoAssembler = DepartamentoDTODomainAssembler.obtenerInstancia();
	
	private CiudadDTODomainAssembler() {
		super();

}
	@Override
	public CiudadDomain ensamblarDominio(CiudadDTO dto) {
		var CiudadDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new CiudadDTO());
		var DepartamentoDomain = DepartamentoAssembler.ensamblarDominio(CiudadDtoTmp.getDepartamento());
		return CiudadDomain.crear(CiudadDtoTmp.getId(), CiudadDtoTmp.getNombre(), DepartamentoDomain);
	}
	
	@Override
	public CiudadDTO ensamblarDTO(CiudadDomain dominio) {
		var CiudadDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CiudadDomain.crear());
		var DepartamentoDTO = DepartamentoAssembler.ensamblarDTO(CiudadDomainTmp.getDepartamento());
		return CiudadDTO.build().setId(CiudadDomainTmp.getId()).setNombre(CiudadDomainTmp.getNombre()).setDepartamento(DepartamentoDTO);
		
	}
}
