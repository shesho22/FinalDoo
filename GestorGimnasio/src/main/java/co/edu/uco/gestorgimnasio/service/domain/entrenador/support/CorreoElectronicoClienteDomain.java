package co.edu.uco.gestorgimnasio.service.domain.entrenador.support;


public class CorreoElectronicoClienteDomain {
		private String correoElectronico;
		private boolean correoElectronicoConfirmado;
		
		
		
		public CorreoElectronicoClienteDomain(final String correoElectronico,final boolean correoElectronicoConfirmado) {
			setCorreoElectronico(correoElectronico);
			setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		}

		public static final CorreoElectronicoClienteDomain crear (final String correoElectronico,final boolean correoElectronicoConfirmado) {
			return new CorreoElectronicoClienteDomain(correoElectronico, correoElectronicoConfirmado);
		}


		private final CorreoElectronicoClienteDomain setCorreoElectronico(final String correoElectronico) {
			this.correoElectronico = correoElectronico;
			return this;
		}


		private final CorreoElectronicoClienteDomain setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
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
