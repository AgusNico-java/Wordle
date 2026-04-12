package logica.modelo;

public enum Dificultad {
    FACIL("Facil", 5),
    MEDIO("Medio", 6),
    DIFICIL("Dificil", 7);

    private final String nombre;
    private final int letras;

    Dificultad(String nombre, int letras) {
        this.nombre = nombre;
        this.letras = letras;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLetras() {
        return letras;
    }

    public static Dificultad fromNombre(String nombre) {
        for (Dificultad nivel : values()) {
            if (nivel.nombre.equalsIgnoreCase(nombre)) {
                return nivel;
            }
        }
        throw new IllegalArgumentException("Nivel no encontrado: " + nombre);
    }
}
