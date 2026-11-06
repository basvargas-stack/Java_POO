package cl.duoc.rutaactiva.repository;

import cl.duoc.rutaactiva.dao.BicicletaDAO;
import cl.duoc.rutaactiva.dao.ScooterDAO;
import cl.duoc.rutaactiva.model.Bicicleta;
import cl.duoc.rutaactiva.model.Scooter;
import cl.duoc.rutaactiva.model.Vehiculo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoRepository {

    private final BicicletaDAO  bicicletaDAO = new  BicicletaDAO();

    private final ScooterDAO scooterDAO = new  ScooterDAO();

    private List<Bicicleta> bicicletas = new ArrayList<>();

    private List<Scooter> scooters = new ArrayList<>();


    public void cargar() throws IOException {
        bicicletas = bicicletaDAO.leer();
        scooters = scooterDAO.leer();

    }

    public List<Vehiculo> listar() throws IOException {
        List<Vehiculo> todos = new ArrayList<>(bicicletas);
        todos.addAll(scooters);
        return todos;


    }

    public void registrar(Vehiculo vehiculo) throws IOException {
        if (vehiculo instanceof Bicicleta bicicleta) {
            if (bicicletas.stream().anyMatch(x -> x.getCodigo().equalsIgnoreCase(bicicleta.getCodigo()))){
                throw new IllegalArgumentException("El codigo de esta bicicleta ya existe");
            }

            bicicletas.add(bicicleta);

            try {
                bicicletaDAO.guardar(bicicletas);
            } catch (IOException e) {
                bicicletas.remove(bicicleta);
                throw e;
            }


        } else if (vehiculo instanceof Scooter scooter) {
            if (scooters.stream().anyMatch(x -> x.getCodigo().equalsIgnoreCase(scooter.getCodigo()))){
                throw new IllegalArgumentException("El codigo de esta bicicleta ya existe");
            }

            scooters.add(scooter);

            try {
                scooterDAO.guardar(scooters);
            } catch (IOException e) {
                scooters.remove(scooter);
                throw e;
            }


        }
    }

    public void eliminar(Vehiculo vehiculo) throws IOException {
        if (vehiculo instanceof Bicicleta bicicleta) {
            if (!bicicletas.remove(bicicleta)) return;

            try {
                bicicletaDAO.guardar(bicicletas);
            } catch (IOException e) {
                bicicletas.add(bicicleta);
            }


        } else  if (vehiculo instanceof Scooter scooter) {
            if (!scooters.remove(scooter)) return;
            try {
                scooterDAO.guardar(scooters);
            } catch (IOException e) {
                scooters.add(scooter);
            }
        }

    }




}
