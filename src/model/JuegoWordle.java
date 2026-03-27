package model;

public class JuegoWordle {

    private String palabraSecreta;
    private int intentoActual;
    private final int MAX_INTENTOS = 6;
    private EstadoJuego estadoActual;

    public JuegoWordle(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.intentoActual = 1;
        this.estadoActual = EstadoJuego.EN_CURSO;
    }

    public EstadoLetra[] arriesgarPalabra(String intento) {
        throw new UnsupportedOperationException("A implementar en próximas tareas");
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
