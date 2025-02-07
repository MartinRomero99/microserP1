package com.microserv.turnos.controller;

import com.microserv.turnos.dto.TurnoDTO;
import com.microserv.turnos.model.Turno;
import com.microserv.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoServ;

    //crear nuevo turno
    @PostMapping ("/crear")
    public String crearTurno (@RequestBody TurnoDTO turnoDTO){
        turnoServ.saveTurno(turnoDTO.getFecha(), turnoDTO.getTratamiento(), turnoDTO.getDniPaciente());
        return "Turno creado correctamente";
    }

    @GetMapping ("/traer")
    public List<Turno> traerTurnos(){
        return turnoServ.getTurnos();
    }

    @DeleteMapping ("/borrar/{id}")
    public String deleteTurno (@PathVariable Long id){
        turnoServ.deleteTurno(id);
        return "Turno eliminado correctamente";
    }

    @PutMapping ("/editar/{idOriginal}")
    public Turno editTurno (@PathVariable Long idOriginal,
                            @RequestBody Turno turnoEditar){
        turnoServ.editTurno(idOriginal, turnoEditar);
        Turno turnoEditado = turnoServ.findTurno(idOriginal);
        return turnoEditado;
    }

    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id){
        return turnoServ.findTurno(id);
    }
}
