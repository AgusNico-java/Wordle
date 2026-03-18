package service;

public interface GameService {
	
	/*
	 * Dado un nivel seleccionado por el usuario, 
	 * guarda una palabra del grupo correspondiente en
	 * la variable selectedWord
	 */
	public void selectDifficulty(int levelSlected);
	
	/*
	 * Verifica si la letra ingresada por el usuario
	 * está en la palabra seleccionada
	 */
	public boolean findLetter(char letter);
	
	/*
	 * comparamos si la palabra ingresada es igual a la seleccionada
	 */
	public boolean compareWord(String userWord);
	
	/*
	 * Verifica si la letra ingresada por el usuario se encuentra en la posición correcta
	 */
	public boolean comparePosition(char letter);
	
	/*
	 * Selecciona el color de acuerdo a los resultados de findLetter y compare position
	 */
	public int selectColor(boolean isLetterPresent, boolean isCorrectPosition);
	
	/*
	 * incrementa el contador de intentos
	 */
	public void incrementCounter();
	
	/*
	 * Envía un mensaje indicando que el jugador perdió o ganó.
	 * Debe ser llamada cuando el contador de intentos llegue a 6
	 * o el usuario adivine la palabra
	 */
	public boolean finishGame();

	
	/*
	 * En la pantalla de victoria se le pedirá el nombre al usuario y
	 * lo usará para guardar el record en el array correspondiente. Luego
	 * lo ordena para que quede en la posición correcta de acuerdo al tiempo.
	 * Implementar usando quickSort.
	 */
	public void addRecord(long time);
	
	/*
	 * Escribe el array de records en un archivo .csv
	 */
	public void writeRecordList();
	
	/*
	 * Toma del .csv la lista de records al iniciar el juego
	 */
	public void readRecordList();
	
	/*
	 * Toma el array de records de memoria y lo envía a la ventana de records 
	 * 
	 */
	public Record[] showRecords();
}
