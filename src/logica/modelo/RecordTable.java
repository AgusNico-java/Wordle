package logica.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator; // Importante
import java.util.List;

public class RecordTable {

    private List<Record> records;
    private static final String ARCHIVO = "records.txt";

    public RecordTable() {
        records = new ArrayList<>();
        leer();
    }

    public void agregarRecord(Record r) {
        records.add(r);
        
        // 1. ORDENAMOS EXPLICITAMENTE: Menor tiempo primero (Facundo con 5s arriba)
        records.sort(Comparator.comparingLong(Record::getTime));

        // 2. CORTAMOS EL TOP 5 (De forma segura para Java)
        if (records.size() > 5) {
            records = new ArrayList<>(records.subList(0, 5));
        }

        guardar();
    }

    public List<Record> obtenerRecords() {
        // Por las dudas, volvemos a ordenar antes de devolver la lista
        records.sort(Comparator.comparingLong(Record::getTime));
        return records;
    }

    private void guardar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Record r : records) {
                // Guardamos Nombre,Tiempo
                bw.write(r.getName() + "," + r.getTime());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void leer() {
        // Limpiamos la lista antes de leer para no duplicar datos
        records.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0];
                    long tiempo = Long.parseLong(partes[1]);
                    records.add(new Record(nombre, tiempo));
                }
            }
        } catch (IOException e) {
            // Si el archivo no existe, simplemente empezamos con lista vacía
        }
    }
}