import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Piloto implements Comparable<Piloto> {

	// A partir de um input de um arquivo de log do formato acima,
	// montar o resultado da corrida com as seguintes informações:
	// Posição Chegada, Código Piloto, Nome Piloto, Qtde Voltas Completadas e Tempo
	// Total de Prova.

	private static SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS", Locale.ENGLISH);

	private String codPiloto;
	private String nomePiloto;
	private Integer qtdeVoltas;
	private Double vMedia;
	String tempoVolta;
	String primeiraVolta;
	String segundaVolta;
	String terceiraVolta;
	String quartaVolta;
	long tempoTotal;
	int count = 1;

	public Piloto() {

	}

	public Piloto(String codPiloto, String nomePiloto, long millisTempoVolta, String tempoVolta, Double vMedia) {

		this.codPiloto = codPiloto;
		this.nomePiloto = nomePiloto;
		this.vMedia = vMedia;
		setVoltas(tempoVolta);
	}

	public void setVoltas(String tempoVolta) {

		if (count == 1) {
			this.primeiraVolta = tempoVolta;

		} else if (count == 2) {
			this.segundaVolta = tempoVolta;

		} else if (count == 3) {
			this.terceiraVolta = tempoVolta;

		} else if (count == 4) {
			this.quartaVolta = tempoVolta;

		}
		count++;

	}

	public String getCodPiloto() {
		return codPiloto;
	}

	public void setCodPiloto(String codPiloto) {
		this.codPiloto = codPiloto;
	}

	/**
	 * @return the primeiraVolta
	 */
	public String getPrimeiraVolta() {
		return primeiraVolta;
	}

	/**
	 * @param primeiraVolta the primeiraVolta to set
	 */
	public void setPrimeiraVolta(String primeiraVolta) {
		this.primeiraVolta = primeiraVolta;
	}

	/**
	 * @return the segundaVolta
	 */
	public String getSegundaVolta() {
		return segundaVolta;
	}

	/**
	 * @param segundaVolta the segundaVolta to set
	 */
	public void setSegundaVolta(String segundaVolta) {
		this.segundaVolta = segundaVolta;
	}

	/**
	 * @return the terceiraVolta
	 */
	public String getTerceiraVolta() {
		return terceiraVolta;
	}

	/**
	 * @param terceiraVolta the terceiraVolta to set
	 */
	public void setTerceiraVolta(String terceiraVolta) {
		this.terceiraVolta = terceiraVolta;
	}

	/**
	 * @return the quartaVolta
	 */
	public String getQuartaVolta() {
		return quartaVolta;
	}

	/**
	 * @param quartaVolta the quartaVolta to set
	 */
	public void setQuartaVolta(String quartaVolta) {
		this.quartaVolta = quartaVolta;
	}

	/**
	 * @return the tempoTotal
	 */
	public long getTempoTotal() {
		return tempoTotal;
	}

	/**
	 * @param tempoTotal the tempoTotal to set
	 */
	public void setTempoTotal(long tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	

	public void settandoPosPiloto(List<Piloto> p) {
	
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public Integer getQtdeVoltas() {
		return qtdeVoltas;
	}

	public void setQtdeVoltas(Integer qtdeVoltas) {
		this.qtdeVoltas = qtdeVoltas;
	}

	@Override
	public String toString() {
		return "codigo: " + codPiloto + ", Nome: " + nomePiloto
				+ "   -   Quantidade de voltas: " + qtdeVoltas + ", vMedia: " + vMedia + ", tempoTotal: " + tempoTotal ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codPiloto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piloto other = (Piloto) obj;
		return Objects.equals(codPiloto, other.codPiloto);
	}

	@Override
	public int compareTo(Piloto outroPiloto) {
		if (this.tempoTotal > outroPiloto.getTempoTotal())
			return 1;
		if (this.tempoTotal < outroPiloto.getTempoTotal())
			return -1;
		return 0;
	}

}
