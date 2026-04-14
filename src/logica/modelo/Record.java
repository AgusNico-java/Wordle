package logica.modelo;

public class Record implements Comparable<Record> {

    private String name;
    private long time;

    public Record(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(Record otro) {
        return Long.compare(this.time, otro.time); // menor tiempo = mejor
    }
    
    public static long textoAMilisegundos(String tiempoTexto) {
        
        // . Dividimos el tiempo en el array: partes[0] son minutos, partes[1] son segundos
        String[] partes = tiempoTexto.split(":");

        // 2. Parseamos cada parte a número
        long minutos = Long.parseLong(partes[0]);
        long segundos = Long.parseLong(partes[1]);

        // 3. Convertimos a milisegundos
        // Multiplicamos por 60 para ir a segundos, y por 1000 para llegar a milisegundos
        return ((minutos * 60) + segundos) * 1000;

    }
}
