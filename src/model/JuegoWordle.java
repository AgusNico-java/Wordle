package model;

public class JuegoWordle {

    private String palabraSecreta;
    private int intentoActual;
    private final int MAX_INTENTOS = 6;
    private EstadoJuego estadoActual;

    public JuegoWordle(Dificultad dificultad) {
        this.palabraSecreta = seleccionarPalabra(dificultad);
        this.intentoActual = 1;
        this.estadoActual = EstadoJuego.EN_CURSO;
    }

    private static String seleccionarPalabra(Dificultad dificultad) {
        String[] palabras;
        switch (dificultad) {
            case FACIL:
                palabras = new String[]{"gato", "luna", "mesa", "pato"};
                break;
            case NORMAL:
                palabras = new String[]{"perro", "coche", "playa", "fuego"};
                break;
            case DIFICIL:
                palabras = new String[]{"dragón", "colcha", "brújula", "través"};
                break;
            default:
                palabras = new String[]{"perro", "coche", "playa", "fuego"};
        }
        return palabras[(int) (Math.random() * palabras.length)];
    }

    public EstadoLetra[] arriesgarPalabra(String intento) {
        if (estadoActual != EstadoJuego.EN_CURSO) {
            throw new IllegalStateException("El juego no está en curso.");
        }
        if (intento.length() != palabraSecreta.length()) {
            throw new IllegalArgumentException("La longitud del intento no coincide con la de la palabra secreta.");
        }

        int longitud = palabraSecreta.length();
        EstadoLetra[] resultado = new EstadoLetra[longitud];
        StringBuilder copia = new StringBuilder(palabraSecreta);

        // letras en posición correcta
        for (int i = 0; i < longitud; i++) {
            if (comparePosition(intento.charAt(i), palabraSecreta.charAt(i))) {
                resultado[i] = EstadoLetra.CORRECTA;
                copia.setCharAt(i, '*');
            }
        }

        // letras en posición incorrecta o inexistentes
        for (int i = 0; i < longitud; i++) {
            if (resultado[i] == EstadoLetra.CORRECTA) continue;

            if (findLetter(intento.charAt(i), copia.toString())) {
                resultado[i] = EstadoLetra.POSICION_INCORRECTA;
                copia.setCharAt(copia.indexOf(String.valueOf(intento.charAt(i))), '*');
            } else {
                resultado[i] = EstadoLetra.INEXISTENTE;
            }
        }

        intentoActual++;

        // Actualización de estado
        boolean victoria = true;
        for (EstadoLetra e : resultado) {
            if (e != EstadoLetra.CORRECTA) {
                victoria = false;
                break;
            }
        }

        if (victoria) {
            estadoActual = EstadoJuego.VICTORIA;
        } else if (intentoActual >= MAX_INTENTOS) {
            estadoActual = EstadoJuego.DERROTA;
        }

        return resultado;
    }

    private boolean comparePosition(char letraIntento, char letraSecreta) {
        return letraIntento == letraSecreta;
    }

    private boolean findLetter(char letra, String palabraRestante) {
        return palabraRestante.indexOf(letra) != -1;
    }

    public EstadoJuego getEstadoActual() {
        return estadoActual;
    }

    public int getIntentoActual() {
        return intentoActual;
    }

    public int getMaxIntentos() {
        return MAX_INTENTOS;
    }
}
