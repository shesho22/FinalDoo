package co.edu.uco.gestorgimnasio.service.dto.support;

import co.edu.uco.gestorgimnasio.crosscutting.util.UtilTexto;

public class CorreoElectronicoClienteDTO {
		private String correoElectronico;
		private boolean correoElectronicoConfirmado;
		
		
		public CorreoElectronicoClienteDTO() {
			setCorreoElectronico(UtilTexto.VACIO);
			setCorreoElectronicoConfirmado(false);
		}
		
		public CorreoElectronicoClienteDTO(final String correoElectronico,final boolean correoElectronicoConfirmado) {
			setCorreoElectronico(correoElectronico);
			setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		}

		public static final CorreoElectronicoClienteDTO crear (final String correoElectronico,final boolean correoElectronicoConfirmado) {
			return new CorreoElectronicoClienteDTO(correoElectronico, correoElectronicoConfirmado);
		}


		private final void setCorreoElectronico(final String correoElectronico) {
			this.correoElectronico = correoElectronico;
		}



		private final void setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
			this.correoElectronicoConfirmado = correoElectronicoConfirmado;
		}



		public final String getCorreoElectronico() {
			return correoElectronico;
		}
		public final boolean isCorreoElectronicoConfirmado() {
			return correoElectronicoConfirmado;
		}
		
}
