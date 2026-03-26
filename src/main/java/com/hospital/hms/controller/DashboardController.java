package com.hospital.hms.controller;

import com.hospital.hms.model.*;
import com.hospital.hms.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired private MedicoService medicoService;
    @Autowired private PacienteService pacienteService;
    @Autowired private AlaService alaService;
    @Autowired private LeitoService leitoService;
    @Autowired private EspecialidadeService especialidadeService;
    @Autowired private QuartoService quartoService;
    @Autowired private TipoSanguineoService tipoSanguineoService;

    private boolean isNotLogged(HttpSession session) {
        return session.getAttribute("usuarioLogado") == null;
    }

    // DASHBOARD HOME
    @GetMapping
    public String home(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("totalMedicos", medicoService.listarTodos().size());
        model.addAttribute("totalPacientes", pacienteService.listarTodos().size());
        model.addAttribute("totalLeitos", leitoService.listarTodos().size());
        return "dashboard";
    }

    // MÉDICOS
    @GetMapping("/medicos")
    public String listarMedicos(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("medicos", medicoService.listarTodos());
        return "medicos/listar";
    }

    @GetMapping("/medicos/novo")
    public String novoMedico(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("medico", new Medico());
        model.addAttribute("especialidades", especialidadeService.listarTodas());
        return "medicos/form";
    }

    @PostMapping("/medicos/salvar")
    public String salvarMedico(@ModelAttribute Medico medico) {
        medicoService.salvar(medico);
        return "redirect:/dashboard/medicos";
    }

    // PACIENTES
    @GetMapping("/pacientes")
    public String listarPacientes(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "pacientes/listar";
    }

    @GetMapping("/pacientes/novo")
    public String novoPaciente(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("paciente", new Paciente());
        model.addAttribute("tiposSanguineos", tipoSanguineoService.listarTodos());
        return "pacientes/form";
    }

    @PostMapping("/pacientes/salvar")
    public String salvarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.salvar(paciente);
        return "redirect:/dashboard/pacientes";
    }

    // LEITOS
    @GetMapping("/leitos")
    public String listarLeitos(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("leitos", leitoService.listarTodos());
        return "leitos/listar";
    }

    // ALAS
    @GetMapping("/alas")
    public String listarAlas(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("alas", alaService.listarTodas());
        return "alas/listar";
    }

    @GetMapping("/alas/novo")
    public String novaAla(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("ala", new Ala());
        return "alas/form";
    }

    @PostMapping("/alas/salvar")
    public String salvarAla(@ModelAttribute Ala ala) {
        alaService.salvar(ala);
        return "redirect:/dashboard/alas";
    }

    // QUARTOS
    @GetMapping("/quartos")
    public String listarQuartos(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("quartos", quartoService.listarTodos());
        return "quartos/listar";
    }

    @GetMapping("/quartos/novo")
    public String novoQuarto(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("quarto", new Quarto());
        model.addAttribute("alas", alaService.listarTodas());
        return "quartos/form";
    }

    @PostMapping("/quartos/salvar")
    public String salvarQuarto(@ModelAttribute Quarto quarto) {
        quartoService.salvar(quarto);
        return "redirect:/dashboard/quartos";
    }

    // ESPECIALIDADES
    @GetMapping("/especialidades")
    public String listarEspecialidades(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("especialidades", especialidadeService.listarTodas());
        return "especialidades/listar";
    }

    @GetMapping("/especialidades/novo")
    public String novaEspecialidade(HttpSession session, Model model) {
        if (isNotLogged(session)) return "redirect:/login";
        model.addAttribute("especialidade", new Especialidade());
        return "especialidades/form";
    }

    @PostMapping("/especialidades/salvar")
    public String salvarEspecialidade(@ModelAttribute Especialidade especialidade) {
        especialidadeService.salvar(especialidade);
        return "redirect:/dashboard/especialidades";
    }
}
