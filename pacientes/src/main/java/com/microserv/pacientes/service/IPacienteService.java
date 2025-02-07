package com.microserv.pacientes.service;

import com.microserv.pacientes.model.Paciente;

import java.util.List;

public interface IPacienteService {
    // crear los metodos pero sin implementar porque es una interfaz, va a haber una clase con el mismo nombre

    public List<Paciente> getPacientes();
    public void savePaciente (Paciente pac);
    public void deletePaciente (Long id);
    public Paciente findPaciente(Long id);
    public void editPaciente(Long id, Paciente pac);
    //public Paciente findPacienteByDni (String dni);

    public Paciente findPacienteDni(String dni);
}
