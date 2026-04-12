package logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD

=======
>>>>>>> master
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
<<<<<<< HEAD
=======

>>>>>>> master
import logica.modelo.Record;

public class ServicioDeArchivos {

	private static final Random random = new Random();
<<<<<<< HEAD
	
=======

>>>>>>> master
	public static String elegirPalabra(String archivo) {
		try {
			List<String> lineas = Files.readAllLines(Paths.get(archivo));
			List<String> palabras = lineas.stream()
					.map(String::trim)
					.filter(line -> ! (line.isEmpty() || line.isBlank()))
					.toList();
<<<<<<< HEAD
			
=======

>>>>>>> master
			if(palabras.isEmpty()) {
				throw new Exception("El archivo no contiene ninguna palabra");
			}
			return palabras.get(random.nextInt(palabras.size()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
<<<<<<< HEAD
		
	}
	
=======

	}

>>>>>>> master
    public List<Record> readRecordList(){
        Path path = Path.of(Constants.RECORD_FILE_PATH);

        if (!Files.exists(path)) {
            return List.of();
        }

        try {
            List<String> lines = Files.readAllLines(path);
            Record[] records = new Record[lines.size()];

            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(Constants.DELIMITER);
                String name = parts[0];
                Long time = Long.parseLong(parts[1]);
                records[i] = new Record(name, time);
            }
            return List.of(records);

        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }

    }

    public void writeRecordList(Record[] records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.RECORD_FILE_PATH))) {
            for (Record record : records) {
                writer.write(record.getName() + Constants.DELIMITER + record.getTime());
                writer.newLine();
            }
        } catch (IOException e) {
<<<<<<< HEAD
            e.printStackTrace();;
=======
            e.printStackTrace();
>>>>>>> master
        }

    }

}
