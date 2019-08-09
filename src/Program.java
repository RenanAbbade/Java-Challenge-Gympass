import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Program {

	public static void main(String[] args) throws NumberFormatException, ParseException {

//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS", Locale.ENGLISH);
		long data = 0;
		
		int pos = 1;
//		
		SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS", Locale.ENGLISH);

		String path = "C:\\Users\\Dell\\Documents\\gymlog.txt"; // Chamando a String do caminho do arquivo

		Set<Piloto> pilotos = new HashSet<>();
		List<Piloto> Pilotos = new ArrayList<>();
		

		FileReader fr = null;

		BufferedReader br = null;

		try {
			fr = new FileReader(path);

			br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {

				String[] campos = line.trim().replaceAll("\\s+", ";").split(";");// Substituindo os espaços em branco
																					// pelo ;

				String codPiloto = campos[1];

				String nomePiloto = campos[3];

				int qtdeVoltas = Integer.parseInt(campos[4]);

				String tempoVolta = campos[5];

				Double vMedia = Double.parseDouble(campos[6].replace(",", "."));

				Piloto cand = new Piloto(codPiloto, nomePiloto, qtdeVoltas, tempoVolta, vMedia);

				if (pilotos.isEmpty()) {

					pilotos.add(cand);

				} else if (pilotos.contains(cand)) {// Somando o tempo de volta dos pilotos

					for (Piloto p : pilotos) {

						if (p.equals(cand)) {

							p.setQtdeVoltas(qtdeVoltas);

							p.setVoltas(tempoVolta);

						}
					}
				} else

					pilotos.add(cand);

				line = br.readLine();
			}

			for (Piloto p : pilotos) {

				if (p.getQuartaVolta() == null) {
					p.setQuartaVolta("0:00.000");
				}

				data = ((sdf2.parse(p.getPrimeiraVolta()).getTime() + sdf2.parse(p.getSegundaVolta()).getTime()
						+ sdf2.parse(p.getTerceiraVolta()).getTime() + sdf2.parse(p.getQuartaVolta()).getTime())
						/ 1000);
				p.setTempoTotal(data);
			}
			
			
			Object[] p = pilotos.toArray();	
			
			for(int i = 0; i < p.length; i++) {
				Pilotos.add((Piloto) p[i]);
			}
			
			 Collections.sort(Pilotos);
			 
		
			
		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());

		} finally {

			try {

				if (br != null) {

					br.close();
				}

				if (fr != null) {

					fr.close();
				}

			} catch (IOException e) { // para fechar as Streams

				e.printStackTrace();
			}

		}

		for (Piloto p : Pilotos) {

			System.out.println(pos+"° - "  + p);
			
			pos++;
		}
		
		
	}

}
