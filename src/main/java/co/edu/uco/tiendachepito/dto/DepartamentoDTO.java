package co.edu.uco.tiendachepito.dto;

import co.edu.uco.tiendachepito.crosscutting.helpers.TextHelper;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;


public final class DepartamentoDTO {
	
	private int id;
	private String nombre;
	private PaisDTO pais;

	public DepartamentoDTO() {
		setNombre(TextHelper.EMPTY);

	}
	public static DepartamentoDTO build() {
		return new DepartamentoDTO();
	}
	public DepartamentoDTO(final int id, final String nombre, final PaisDTO pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}

	public final int getId() {
		return id;
	}
	public final DepartamentoDTO setId(int id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public DepartamentoDTO  setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	public final PaisDTO getPais() {
		return pais;
	}
	public DepartamentoDTO  setPais(PaisDTO pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefault(pais,PaisDTO.build());
		return this;}}


	

