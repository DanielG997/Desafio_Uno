package cl.acl.desafio1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@JsonPropertyOrder({ "id", "fechaCreacion", "fechaFin" ,"fechas","fechasFaltantes"})
public class PeriodModel {

    @JsonProperty("id")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("fechaCreacion")
    private LocalDate fechaCreacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("fechaFin")
    private LocalDate fechaFin;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("fechas")
    private List<LocalDate> fechas;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("fechasFaltantes")
    private List<LocalDate> fechasFaltantes;


    public Long getId() {
        return id;
    }

    public PeriodModel(Long id, LocalDate fechaCreacion, LocalDate fechaFin, List<LocalDate> fechas, List<LocalDate> fechasFaltantes) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.fechas = fechas;
        this.fechasFaltantes = fechasFaltantes;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }


    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public LocalDate getFechaFin() {
        return fechaFin;
    }


    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }


    public List<LocalDate> getFechas() {
        return fechas;
    }


    public void setFechas(List<LocalDate> fechas) {
        this.fechas = fechas;
    }

    public List<LocalDate> getFechasFaltantes() {
        return fechasFaltantes;
    }


    public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }


}