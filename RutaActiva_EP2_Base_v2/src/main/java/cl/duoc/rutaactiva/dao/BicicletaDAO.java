package cl.duoc.rutaactiva.dao;

import cl.duoc.rutaactiva.model.Bicicleta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BicicletaDAO {

    private final Path archivo = Path.of("Bicicletas.Json");

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Bicicleta> leer() throws IOException{

        if (Files.notExists(archivo)) {
            return new ArrayList<>();
        }

        String Json = Files.readString(archivo, StandardCharsets.UTF_8);

        List<Bicicleta> datos = gson.fromJson(Json, new TypeToken<List<Bicicleta>>(){}.getType());

        return datos == null ? new ArrayList<>() : datos;


    }

    public void guardar (List<Bicicleta> bicicletas ) throws IOException{
        Files.writeString(archivo, gson.toJson(bicicletas), StandardCharsets.UTF_8);
    }



}
