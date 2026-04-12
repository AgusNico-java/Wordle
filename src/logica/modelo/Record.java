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
}