package co.edu.uco.gestorgimnasio.service.domain.entrenador.support;


public class CorreoElectronicoDomain {
		private String correoElectronico;
		private boolean correoElectronicoConfirmado;



		public CorreoElectronicoDomain(final String correoElectronico,final boolean correoElectronicoConfirmado) {
			setCorreoElectronico(correoElectronico);
			setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		}

		public static final CorreoElectronicoDomain crear (final String correoElectronico,final boolean correoElectronicoConfirmado) {
			return new CorreoElectronicoDomain(correoElectronico, correoElectronicoConfirmado);
		}


		private final CorreoElectronicoDomain setCorreoElectronico(final String correoElectronico) {
			this.correoElectronico = correoElectronico;
			return this;
		}


		private final CorreoElectronicoDomain setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
			this.correoElectronicoConfirmado = correoElectronicoConfirmado;
			return this;
		}


		public final String getCorreoElectronico() {
			return correoElectronico;
		}
		public final boolean isCorreoElectronicoConfirmado() {
			return correoElectronicoConfirmado;
		}

}
