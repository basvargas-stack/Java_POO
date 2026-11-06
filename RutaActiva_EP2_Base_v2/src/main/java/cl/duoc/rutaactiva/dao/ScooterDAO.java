package cl.duoc.rutaactiva.dao;

import cl.duoc.rutaactiva.model.Bicicleta;
import cl.duoc.rutaactiva.model.Scooter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ScooterDAO {


    private final Path archivo = Path.of("Scooter.Json");

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Scooter> leer() throws IOException {

        if (Files.notExists(archivo)) {
            return new ArrayList<>();
        }

        String Json = Files.readString(archivo, StandardCharsets.UTF_8);

        List<Scooter> datos = gson.fromJson(Json, new TypeToken<List<Scooter>>(){}.getType());

        return datos == null ? new ArrayList<>() : datos;


    }

    public void guardar (List<Scooter> Scotters ) throws IOException{
        Files.writeString(archivo, gson.toJson(Scotters), StandardCharsets.UTF_8);
    }
}
