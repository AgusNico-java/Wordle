package logica.modelo;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logica.Constants;
import logica.ServicioDeArchivos;

public class Juego {
	
	public String palabraSecreta;
	private String tiempoDeJuego;
	
	private EstadoDeJuego estadoDeJuego;
	
	private int intentos;
	private int numeroDeLetras;
	
	private long horaDeInicio;
	private long horaDeVictoria;
	
	private List<LetraArriesgada[]> palabrasUsadas;
	
	public Juego(String dificultad) {
		this.horaDeInicio = Instant.now().toEpochMilli();
		this.intentos = 6;
		this.palabraSecreta = this.elegirPalabra(Constants.LETRAS_POR_NIVEL.get(dificultad));
		this.numeroDeLetras = Constants.LETRAS_POR_NIVEL.get(dificultad);
		this.estadoDeJuego = EstadoDeJuego.EN_CURSO;
		this.palabrasUsadas = new ArrayList<>();
	}
	
	private String elegirPalabra(int numeroDeLetras) {
		String archivoALeer = String.format("palabras_de_%d_letras.txt", numeroDeLetras);
		return ServicioDeArchivos.elegirPalabra(archivoALeer);
	}
	
	public void verificarPalabra(String palabraArriesgada) {
		this.intentos--;
		if(palabraArriesgada.equalsIgnoreCase(this.palabraSecreta)) {
			this.horaDeVictoria = Instant.now().toEpochMilli();
			this.estadoDeJuego = EstadoDeJuego.VICTORIA;
			this.calcularTiempoJuego();
			this.palabrasUsadas.add(this.formarArregloDeLetrasEnVictoria(palabraArriesgada));
		}
		if(intentos == 0) {
			this.estadoDeJuego = EstadoDeJuego.DERROTA;
		}
		this.palabrasUsadas.add(this.formarArregloDeLetrasArriesgadas(palabraArriesgada));		
	}
	
	public List<LetraArriesgada[]> getPalabrasUsadas() {
		return palabrasUsadas;
	}

	private void calcularTiempoJuego() {
		long tiempoEnMilis = this.horaDeVictoria - this.horaDeInicio;

		Duration d = Duration.ofMillis(tiempoEnMilis);
		String tiempo = String.format("%02d:%02d", d.toMinutes(), d.toSecondsPart());
		this.tiempoDeJuego = tiempo;
		
	}

	public String getTiempoDeJuego() {
		return tiempoDeJuego;
	}

	private LetraArriesgada[] formarArregloDeLetrasEnVictoria(String palabraArriesgada) {
		LetraArriesgada[] letrasEnPalabra = new LetraArriesgada[this.numeroDeLetras];
		for (int i = 0; i < this.numeroDeLetras; i++) {
			letrasEnPalabra[i] = new LetraArriesgada(palabraArriesgada.charAt(i), Constants.COLOR_LETRA_CORRECTA_EN_POSICION_CORRECTA);
		}
		return letrasEnPalabra;
	}
	
	private LetraArriesgada[] formarArregloDeLetrasArriesgadas(String palabraArriesgada) {
	    int longitud = palabraSecreta.length();
	    LetraArriesgada[] resultado = new LetraArriesgada[longitud];
	    char[] secretaArr = palabraSecreta.toCharArray();
	    char[] usuarioArr = palabraArriesgada.toCharArray();

	    Map<Character, Integer> disponibles = new HashMap<>();
	    for (char c : secretaArr) {
	        disponibles.merge(c, 1, Integer::sum);
	    }

	    for (int i = 0; i < longitud; i++) {
	        if (usuarioArr[i] == secretaArr[i]) {
	            resultado[i] = new LetraArriesgada(usuarioArr[i], Constants.COLOR_LETRA_CORRECTA_EN_POSICION_CORRECTA);
	            disponibles.merge(usuarioArr[i], -1, Integer::sum);
	        }
	    }

	    for (int i = 0; i < longitud; i++) {
	        if (resultado[i] != null) continue;

	        char c = usuarioArr[i];
	        int restantes = disponibles.getOrDefault(c, 0);

	        if (restantes > 0) {
	            resultado[i] = new LetraArriesgada(c, Constants.COLOR_LETRA_CORRECTA_EN_POSICION_INCORRECTA);
	            disponibles.merge(c, -1, Integer::sum);
	        } else {
	            resultado[i] = new LetraArriesgada(c, Constants.COLOR_LETRA_INCORRECTA);
	        }
	    }

	    return resultado;
	}

	public int getNumeroDeLetras() {
		return numeroDeLetras;
	}

	public int getIntentos() {
		return intentos;
	}

	public EstadoDeJuego getEstadoDeJuego() {
		return estadoDeJuego;
	}
	
	
	
	
	
	

}
