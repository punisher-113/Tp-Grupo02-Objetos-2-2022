package com.trabajo.Grupo02OO22022.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.trabajo.Grupo02OO22022.entity.Aula;
import com.trabajo.Grupo02OO22022.entity.Curso;
import com.trabajo.Grupo02OO22022.entity.Espacio;
import com.trabajo.Grupo02OO22022.entity.Final;
import com.trabajo.Grupo02OO22022.entity.Laboratorio;
import com.trabajo.Grupo02OO22022.entity.NotaPedido;
import com.trabajo.Grupo02OO22022.entity.Tradicional;
import com.trabajo.Grupo02OO22022.helper.ViewRouteHelper;
import com.trabajo.Grupo02OO22022.service.AulaServiceImplements;
import com.trabajo.Grupo02OO22022.service.EspacioServiceImplements;
import com.trabajo.Grupo02OO22022.service.NotaPedidoServiceImplements;

@Controller
@RequestMapping("/espacio")
public class EspacioController {

	@Autowired
	@Qualifier("espacioService")
	public EspacioServiceImplements espacioService;

	@Autowired
	@Qualifier("aulaService")
	public AulaServiceImplements aulaService;

	@Autowired
	@Qualifier("notaPedidoService")
	public NotaPedidoServiceImplements pedidoService;

	@Secured({ "ROLE_ASISTENTE", "ROLE_ADMIN_GENERAL" })
	@GetMapping("/buscarespacio")
	public ModelAndView buscarEspacio() {
		LocalDate fecha = LocalDate.now();
		char turno = 'm';
		long idaula = 0;
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.BUSCARESPACIO);
		mAV.addObject("fecha", fecha);
		mAV.addObject("turno", turno);
		mAV.addObject("idaula", idaula);

		List<Tradicional> tradicional = new ArrayList<>();
		List<Laboratorio> laboratorio = new ArrayList<>();

		for (Aula aula : aulaService.listaAulas()) {
			if (aula instanceof Tradicional) {
				tradicional.add((Tradicional) aula);
			}

			else {
				laboratorio.add((Laboratorio) aula);
			}

		}

		mAV.addObject("tradicional", tradicional);
		mAV.addObject("laboratorio", laboratorio);

		return mAV;

	}

	@Secured({ "ROLE_ASISTENTE", "ROLE_ADMIN_GENERAL" })
	@PostMapping("/espacioencontrado")
	public ModelAndView espacioEncontrado(String fecha, char turno, long idaula, RedirectAttributes attributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REDIRECT_HOME);
		LocalDate fecha1 = LocalDate.parse(fecha);
		Espacio espacio = null;
		Tradicional tradicional = aulaService.buscarPorID(idaula);
		Laboratorio laboratorio = aulaService.buscarPorIDLab(idaula);
		if (tradicional != null) {
			espacio = espacioService.traerEspacio(fecha1, turno, (Aula) tradicional);
		} else {
			espacio = espacioService.traerEspacio(fecha1, turno, (Aula) laboratorio);

		}

		if (espacio == null) {
			attributes.addFlashAttribute("error", "Espacio no encontrado");
			mAV.setViewName(ViewRouteHelper.REDIRECT_HOME);
		} else {
			mAV.setViewName(ViewRouteHelper.RESULTADOESPACIO);

		}

		mAV.addObject("espacio", espacio);

		return mAV;

	}

	@Secured("ROLE_ADMIN_GENERAL")
	@GetMapping("/agregarespacio")
	public ModelAndView agragarEspacio(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.AGREGARESPACIO);

		Espacio espacio = new Espacio();
		LocalDate fecha = LocalDate.now();
		List<Aula> listaAula = aulaService.listaAulas();
		mAV.addObject("fecha", fecha);
		mAV.addObject("espacio", espacio);
		mAV.addObject("listaAula", listaAula);
		espacio.setFecha(fecha);

		List<Tradicional> tradicional = new ArrayList<>();
		List<Laboratorio> laboratorio = new ArrayList<>();

		for (Aula aula : listaAula) {
			if (aula instanceof Tradicional) {
				tradicional.add((Tradicional) aula);
			}

			else {
				laboratorio.add((Laboratorio) aula);
			}

		}

		mAV.addObject("tradicional", tradicional);
		mAV.addObject("laboratorio", laboratorio);

		return mAV;
	}

	@Secured("ROLE_ADMIN_GENERAL")
	@PostMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Espacio espacio, BindingResult result, Model model,
			RedirectAttributes attributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REDIRECT_HOME);
		LocalDate fecha = LocalDate.now();
		List<Aula> listaAula = aulaService.listaAulas();
		Tradicional tradicional = aulaService.buscarPorID(espacio.getAula().getId());
		Laboratorio laboratorio = aulaService.buscarPorIDLab(espacio.getAula().getId());

		List<Tradicional> tradicionalList = new ArrayList<>();
		List<Laboratorio> laboratorioList = new ArrayList<>();

		for (Aula aula : listaAula) {
			if (aula instanceof Tradicional) {
				tradicionalList.add((Tradicional) aula);
			}

			else {
				laboratorioList.add((Laboratorio) aula);
			}

		}

		mAV.addObject("tradicional", tradicional);
		mAV.addObject("laboratorio", laboratorio);

		if (tradicional.getEdificio() != null) {
			if (espacioService.traerEspacio(espacio.getFecha(), espacio.getTurno(), (Aula) tradicional) == null) {
				espacioService.guardar(espacio);
				attributes.addFlashAttribute("success", "Espacio guardado con exito");

			} else {

				mAV.addObject("fecha", fecha);
				mAV.addObject("espacio", espacio);
				mAV.addObject("listaAula", listaAula);
				espacio.setFecha(fecha);
				attributes.addFlashAttribute("error", "Espacio ya existe");
				mAV.setViewName(ViewRouteHelper.REDIRECT_HOME);

			}
		} else if (laboratorio.getEdificio() != null) {
			if (espacioService.traerEspacio(espacio.getFecha(), espacio.getTurno(), (Aula) laboratorio) == null) {
				espacioService.guardar(espacio);
				attributes.addFlashAttribute("success", "Espacio guardado con exito");

			} else {
				mAV.addObject("fecha", fecha);
				mAV.addObject("espacio", espacio);
				mAV.addObject("listaAula", listaAula);
				espacio.setFecha(fecha);
				attributes.addFlashAttribute("error", "Espacio ya existe");
				mAV.setViewName(ViewRouteHelper.REDIRECT_HOME);
			}
		}

		return mAV;
	}

	@Secured("ROLE_ADMIN_GENERAL")
	@GetMapping("/{id}")
	public ModelAndView asignarEspacio(@PathVariable("id") Long idEspacio, Model model, RedirectAttributes attribute) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ASIGNARESPACIOPEDIDO);
		long idPedido = 0;
		List<NotaPedido> notaPedido = pedidoService.listarTodos();

		mAV.addObject("notaPedido", notaPedido);
		mAV.addObject("idPedido", idPedido);
		mAV.addObject("idEspacio", idEspacio);

		return mAV;
	}

	@Secured("ROLE_ADMIN_GENERAL")
	@PostMapping("/asignado/{id}")
	public ModelAndView espacioAsignado(@PathVariable("id") Long idEspacio, Long idPedido, Model model,
			RedirectAttributes attribute) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REDIRECT_HOME);
		Espacio espacio = espacioService.buscarPorID(idEspacio);
		Final final1 = pedidoService.buscarPorID(idPedido);
		Curso curso = pedidoService.buscarPorIDCurso(idPedido);
		if (final1 != null) {
			final1.setEspacio(espacio);
			final1.getEspacio().setAula(espacio.getAula());
			final1.getEspacio().getAula().setEdificio(espacio.getAula().getEdificio());
			pedidoService.insertOrUpdate(final1);
		} else {
			curso.setEspacio(espacio);
			curso.getEspacio().setAula(espacio.getAula());
			curso.getEspacio().getAula().setEdificio(espacio.getAula().getEdificio());
			pedidoService.insertOrUpdateCurso(curso);
		}
		// setea en Libre, lo opuesto a lo que ya tenga
		espacio.setLibre(!espacio.isLibre());
		espacioService.guardar(espacio);
		attribute.addFlashAttribute("success", "Editado con Exito");
		return mAV;
	}

	@Secured("ROLE_ADMIN_GENERAL")
	@GetMapping("/agregarespaciomes")
	public ModelAndView agregarEspaciomes(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.AGREGARESPACIOMES);
		Espacio espacio = new Espacio();
		LocalDate fecha = LocalDate.now();
		List<Aula> listaAula = aulaService.listaAulas();
		mAV.addObject("fecha", fecha);
		mAV.addObject("espacio", espacio);
		mAV.addObject("listaAula", listaAula);
		espacio.setFecha(fecha);

		List<Tradicional> tradicional = new ArrayList<>();
		List<Laboratorio> laboratorio = new ArrayList<>();

		for (Aula aula : listaAula) {
			if (aula instanceof Tradicional) {
				tradicional.add((Tradicional) aula);
			}

			else {
				laboratorio.add((Laboratorio) aula);
			}

		}

		mAV.addObject("tradicional", tradicional);
		mAV.addObject("laboratorio", laboratorio);

		return mAV;
	}

	// Agrega un Espacio para todo el mes y año designado
	@Secured("ROLE_ADMIN_GENERAL")
	@PostMapping("/guardarmes")
	public ModelAndView agregarEspacioMes(@Valid @ModelAttribute Espacio espacio, BindingResult result, Model model,
			RedirectAttributes attribute) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REDIRECT_HOME);

		long idaula = espacio.getAula().getId();
		int anio = espacio.getFecha().getYear();
		int mes = espacio.getFecha().getMonthValue();
		char turno = espacio.getTurno();

		List<Aula> listaAula = aulaService.listaAulas();

		for (Aula aula : listaAula) {

			if (aula.getId() == idaula) {

				if (aula instanceof Tradicional) {
					espacioService.agregarEspacioMes(mes, anio, turno, aula);
				}

				else {
					espacioService.agregarEspacioMes(mes, anio, turno, aula);

				}

			}

		}
		attribute.addFlashAttribute("success", "Espacios agregados con Exito");

		return mAV;
	}

}
