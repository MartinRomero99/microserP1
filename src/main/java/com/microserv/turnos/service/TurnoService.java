package com.microserv.turnos.service;

import com.microserv.turnos.model.Turno;
import com.microserv.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService{
    @Autowired
    private ITurnoRepository turnoRepo;


    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        //buscar el paciente en la api pacientes
        //Paciente pac = buscar en la api
        //String nombrePaciente = lo que consumo de nombre

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);

        turnoRepo.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
        Turno turn = this.findTurno(id);
        turn.setFecha(turno.getFecha());
        turn.setTratamiento(turno.getTratamiento());
        turn.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());
        turnoRepo.save(turn);
    }
}
