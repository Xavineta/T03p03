package ad;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class Informe {

    public void generarInforme(String rutaDirectorio) throws IOException {

        //Convertir el parámetro a Path
        Path ruta = Paths.get(rutaDirectorio);

        //Comprobamos que es un directorio y
        if (Files.isDirectory(ruta)) {
            Files.list(ruta).forEach(rutaRecorrida -> {
                //Compruebo que tenga dentro un archivo pom. De lo contrario, no
                //se tomarán en cuenta estos directorios.
                Path pom = rutaRecorrida;
                if (pom.getFileName().equals("pom.xml")) {
                    //
                }
            });
        } else {
            System.out.println("Error, debe dar una ruta con directorios");
        }
    }
}

