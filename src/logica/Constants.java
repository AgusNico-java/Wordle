package logica;

import java.util.Map;

public class Constants {

	public static final Map<String, Integer> LETRAS_POR_NIVEL = Map.of(
			"Facil", 5,
			"Medio", 6,
			"Dificil", 7
			);
	public static final String COLOR_LETRA_CORRECTA_EN_POSICION_CORRECTA = "#00ff00";
	public static final String COLOR_LETRA_CORRECTA_EN_POSICION_INCORRECTA = "#fffaa0";
	public static final String COLOR_LETRA_INCORRECTA = "#bbbbbb";
	public static final String RECORD_FILE_PATH = "records.txt";
	public static final String DELIMITER = ",";



}
