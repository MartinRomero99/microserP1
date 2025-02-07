package com.microserv.pacientes.controller;

import com.microserv.pacientes.model.Paciente;
import com.microserv.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {
    //inyeccion de dependencia al service con autowired
    @Autowired
    private IPacienteService pacienteServ;

    //crear un paciente
    @PostMapping("/pacientes/crear")
    public String crearPaciente(@RequestBody Paciente pac){
        pacienteServ.savePaciente(pac);
        return "Paciente creado exitosamente";
    }
    //traer todos los pacientes
    @GetMapping ("/pacientes/traer")
    public List<Paciente> traerPacientes(){
        return pacienteServ.getPacientes();
    }
    //eliminar un paciente
    @DeleteMapping ("/pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable Long id){
        pacienteServ.deletePaciente(id);
        return "El paciente fue borrado exitosamente";
    }
    //editar un paciente
    @PutMapping ("/pacientes/editar/{idOriginal}")
    public Paciente editPaciente(@PathVariable Long idOriginal,
                                 @RequestBody Paciente pacienteEditar){
        pacienteServ.editPaciente(idOriginal,pacienteEditar);
        Paciente pacienteEditado = pacienteServ.findPaciente(idOriginal);
        return  pacienteEditado;
    }
    //obtener un paceinte particular
    @GetMapping("/pacientes/traer/{id}")
    public Paciente traerPaciente (@PathVariable Long id){
        return pacienteServ.findPaciente(id);
    }

    //obtener un paceinte particular
    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente traerPacienteDni (@PathVariable String dni){
        return pacienteServ.findPacienteDni(dni);
    }
}
