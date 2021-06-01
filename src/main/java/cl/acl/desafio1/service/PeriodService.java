package cl.acl.desafio1.service;

import cl.acl.desafio1.model.PeriodModel;
import cl.acl.desafio1.service.impl.ImplPeriodService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeriodService implements ImplPeriodService {


    public List<LocalDate> periodosFaltantes(LocalDate fechaCreacion, LocalDate fechaFin, List<LocalDate> periodos) {
        List<LocalDate> periodosFaltantes = new ArrayList<LocalDate>();
        while(!fechaCreacion.isAfter(fechaFin)) {
            if (!periodos.contains(fechaCreacion)) {
                periodosFaltantes.add(fechaCreacion);
            }
            fechaCreacion = fechaCreacion.plusMonths(1L);
        }
        return periodosFaltantes;
    }

    @Override
    public PeriodModel findDates(PeriodModel input) {
        PeriodModel entrada = input;
        List<LocalDate> periodosFaltantes = new ArrayList<LocalDate>();
        while(!input.getFechaCreacion().isAfter(input.getFechaFin())) {
            if (!input.getFechas().contains(input.getFechaCreacion())) {
                periodosFaltantes.add(input.getFechaCreacion());
            }
            input.setFechaCreacion(input.getFechaCreacion().plusMonths(1L));
            //put.setFechaCreacion() = input.getFechaCreacion().plusMonths(1L);
        }
        input.setFechasFaltantes(periodosFaltantes);
        FolderJson(entrada, input);
        return input;
    }

    private void FolderJson(PeriodModel request, PeriodModel response) {
        Path storage;
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        try {
            Path file = Paths.get("JsonData").toAbsolutePath().normalize();
            Files.createDirectories(file);


            Path targetRequest = file.resolve("request.json");
            FileOutputStream streamRequest = new FileOutputStream(targetRequest.toString());
            streamRequest.write(gson.toJson(request).getBytes());
            streamRequest.close();

            Path targetResponse = file.resolve("response.json");
            FileOutputStream streamResponse = new FileOutputStream(targetResponse.toString());
            streamResponse.write(gson.toJson(response).getBytes());
            streamResponse.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}