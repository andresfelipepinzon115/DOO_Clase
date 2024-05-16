package co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.CrosscuttingTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {

	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
				"Se ha presentado un problema tratando de validar si la conexion SQL con la fuente de informacion deseada estaba cerrada"));
		mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
				"Se ha presentado un problema inesperado de validar si la conexion SQL con la fuente de informacion deseada estaba cerrada"));
		mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
				"Se ha intentado realizar el cierre de una conecion que ya estaba cerrada "));
		mensajes.put(CodigoMensaje.M000010.getIdentificador(), new Mensaje(CodigoMensaje.M000010,
				"se ha presentado un problema tratando de cerrar la conexion  "));
		mensajes.put(CodigoMensaje.M000011.getIdentificador(), new Mensaje(CodigoMensaje.M000011,
				"se ha intentad confirmar una transaccion con una conexion cerrada  "));
		mensajes.put(CodigoMensaje.M000012.getIdentificador(), new Mensaje(CodigoMensaje.M000012,
				"se ha tratado de confirmar una transaccion con una sql cerradda  "));
		mensajes.put(CodigoMensaje.M000013.getIdentificador(), new Mensaje(CodigoMensaje.M000013,
				"se ha intentado confirmar una transaccion cuando el autocomit de la transaccion con la base de datos estaba activado.. "));
		mensajes.put(CodigoMensaje.M000014.getIdentificador(), new Mensaje(CodigoMensaje.M000014,
				"se ha presentado un problema tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000015.getIdentificador(), new Mensaje(CodigoMensaje.M000015,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000016.getIdentificador(), new Mensaje(CodigoMensaje.M000016,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000017.getIdentificador(), new Mensaje(CodigoMensaje.M000017,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000018.getIdentificador(), new Mensaje(CodigoMensaje.M000018,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000019.getIdentificador(), new Mensaje(CodigoMensaje.M000019,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000020.getIdentificador(), new Mensaje(CodigoMensaje.M000020,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000021.getIdentificador(), new Mensaje(CodigoMensaje.M000021,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000022.getIdentificador(), new Mensaje(CodigoMensaje.M000022,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));
		mensajes.put(CodigoMensaje.M000026.getIdentificador(), new Mensaje(CodigoMensaje.M000026,
				"se ha presetnado un problema inesperaddo tratando de confirmar una transaccion sql con la fuente de informacion deseada  "));


	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {

		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004, codigo.getIdentificador());
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		// TODO: Tarea: asegure que si tiene parámetros, el contenido
		// del mensaje se retorne con los parámetros reemplazados
		// {1}, {2}, {3}

		return mensajes.get(codigo.getIdentificador());
	}

}
