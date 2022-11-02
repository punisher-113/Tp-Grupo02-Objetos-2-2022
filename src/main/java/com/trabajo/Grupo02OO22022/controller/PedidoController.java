package com.trabajo.Grupo02OO22022.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.trabajo.Grupo02OO22022.entity.Aula;
import com.trabajo.Grupo02OO22022.entity.Curso;
import com.trabajo.Grupo02OO22022.entity.Edificio;
import com.trabajo.Grupo02OO22022.entity.Espacio;
import com.trabajo.Grupo02OO22022.entity.Final;
import com.trabajo.Grupo02OO22022.entity.Materia;
import com.trabajo.Grupo02OO22022.helper.ViewRouteHelper;
import com.trabajo.Grupo02OO22022.service.MateriaServiceImplements;
import com.trabajo.Grupo02OO22022.service.NotaPedidoServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    @Qualifier("notaPedidoService")
    public NotaPedidoServiceImplements pedidoService;

    @Autowired
    @Qualifier("materiaService")
    public MateriaServiceImplements materiaService;

    @Secured("ROLE_ASISTENTE")
    @GetMapping("/pedidoParaFinal")
    public ModelAndView pedirParaFinal() {

        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIRAULAFINAL);
        Final finalPedido = new Final();
        LocalDate fecha = LocalDate.now();
        char turno = ' ';
        String aula = " ";
        List<Materia> listaMateria = materiaService.listaMaterias();
        int cantEstudiantes = 0;
        String observaciones = " ";
        LocalDate fechaExamen = LocalDate.now();
        mAV.addObject("finalPedido", finalPedido);
        mAV.addObject("fecha", fecha);
        mAV.addObject("turno", turno);
        mAV.addObject("listaMateria", listaMateria);
        mAV.addObject("cantEstudiantes", cantEstudiantes);
        mAV.addObject("observaciones", observaciones);
        mAV.addObject("aula", aula);
        mAV.addObject("fechaExamen", fechaExamen);
        finalPedido.setFecha(fecha);
        finalPedido.setFechaExamen(fechaExamen);

        return mAV;

    }

    @Secured("ROLE_ASISTENTE")
    @PostMapping("/pedidoenviadofinal")
    public ModelAndView pedidoFinalEnviado(@Valid @ModelAttribute Final finalPedido, RedirectAttributes attributes) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REDIRECT_HOME);
        pedidoService.insertOrUpdate(finalPedido);

        attributes.addFlashAttribute("success", "Pedido enviado con exito");

        return mAV;
    }

    @Secured("ROLE_ASISTENTE")
    @GetMapping("/pedidoParaCurso")
    public ModelAndView pedirParaCurso() {

        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIRAULACURSO);
        Curso cursoPedido = new Curso();
        LocalDate fecha = LocalDate.now();
        char turno = ' ';
        String aula = " ";
        List<Materia> listaMateria = materiaService.listaMaterias();
        int cantEstudiantes = 0;
        String carrera = " ";
        boolean proyector = false;
        String observaciones = " ";
        mAV.addObject("cursoPedido", cursoPedido);
        mAV.addObject("fecha", fecha);
        mAV.addObject("turno", turno);
        mAV.addObject("listaMateria", listaMateria);
        mAV.addObject("cantEstudiantes", cantEstudiantes);
        mAV.addObject("observaciones", observaciones);
        mAV.addObject("carrera", carrera);
        mAV.addObject("aula", aula);
        mAV.addObject("proyector", proyector);
        cursoPedido.setFecha(fecha);

        return mAV;

    }

    @Secured("ROLE_ASISTENTE")
    @PostMapping("/pedidoenviadocurso")
    public ModelAndView pedidoCursoEnviado(@Valid @ModelAttribute Curso cursoPedido, RedirectAttributes attributes) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REDIRECT_HOME);
        pedidoService.insertOrUpdateCurso(cursoPedido);

        attributes.addFlashAttribute("success", "Pedido enviado con exito");

        return mAV;
    }

    @Secured({ "ROLE_ADMIN_GENERAL", "ROLE_ASISTENTE" })
    @GetMapping("/listaPedidos")
    public ModelAndView listarPedidos() {

        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDOSLISTAR);

        List<Final> final1 = pedidoService.getAll();
        List<Curso> curso = pedidoService.getAll1();
        List<Final> final3 = new ArrayList<>();
        List<Curso> curso3 = new ArrayList<>();
        for (Final final2 : final1) {
            if (final2.getEspacio() == null) {
                final2.setEspacio(new Espacio());
                final2.getEspacio().setAula(new Aula());
                final2.getEspacio().getAula().setEdificio(new Edificio());
                final3.add(final2);
            } else {
                final3.add(final2);
            }
        }
        for (Curso curso2 : curso) {
            if (curso2.getEspacio() == null) {
                curso2.setEspacio(new Espacio());
                curso2.getEspacio().setAula(new Aula());
                curso2.getEspacio().getAula().setEdificio(new Edificio());
                curso3.add(curso2);
            } else {
                curso3.add(curso2);
            }
        }

        mAV.addObject("final1", final1);
        mAV.addObject("curso", curso);

        return mAV;

    }

    @Secured({"ROLE_ADMIN_GENERAL","ROLE_ASISTENTE"})
    @GetMapping("/deleteFinal/{id}")
    public String eliminarFinal(@PathVariable("id") Long idPedido, RedirectAttributes attribute) {

        Final final1 = null;
        if (idPedido > 0) {
            final1 = pedidoService.buscarPorID(idPedido);
            if (final1 == null) {
                attribute.addFlashAttribute("error", "*ERROR* el pedido solicitado no existe");
                return ViewRouteHelper.REDIRECT_PEDIDO;
            }else{
                pedidoService.eliminarFinal(idPedido);

            }
        }else{
            attribute.addFlashAttribute("error", "*ERROR* el pedido solicitado no existe");
            return ViewRouteHelper.REDIRECT_PEDIDO;

        }
        
       
        attribute.addFlashAttribute("warning", "Pedido eliminado con Exito!");

        return ViewRouteHelper.REDIRECT_PEDIDO;
    }

    @Secured({"ROLE_ADMIN_GENERAL","ROLE_ASISTENTE"})
    @GetMapping("/deleteCurso/{id}")
    public String eliminarCurso(@PathVariable("id") Long idPedido, RedirectAttributes attribute){
        Curso curso1 = null;
        if (idPedido > 0) {
            curso1 = pedidoService.buscarPorIDCurso(idPedido);
            if (curso1 == null) {
                System.out.println("hola");
                attribute.addFlashAttribute("error", "*ERROR* el pedido solicitado no existe");
                return ViewRouteHelper.REDIRECT_PEDIDO;
            }else{
                pedidoService.eliminarCurso(idPedido);
            }
        }else{
            attribute.addFlashAttribute("error", "*ERROR* el pedido solicitado no existe");
            return ViewRouteHelper.REDIRECT_PEDIDO;

        }
       
        attribute.addFlashAttribute("warning", "Pedido eliminado con Exito!");

        return ViewRouteHelper.REDIRECT_PEDIDO;
    }
}

