package com.microserv.turnos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
// esta clase de paciente tambien puede llamarse pacienteDTO

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Long idPaciente;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private  String telefono;
}
