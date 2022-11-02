package com.trabajo.Grupo02OO22022.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trabajo.Grupo02OO22022.entity.Aula;
import com.trabajo.Grupo02OO22022.entity.Edificio;
import com.trabajo.Grupo02OO22022.entity.Laboratorio;
import com.trabajo.Grupo02OO22022.entity.Tradicional;
import com.trabajo.Grupo02OO22022.helper.ViewRouteHelper;
import com.trabajo.Grupo02OO22022.service.IEdificioService;

@Controller
@RequestMapping("/edificios")
public class EdificioController {

	@Autowired
	private IEdificioService edificioService;

	@GetMapping("/")
	public ModelAndView listarEdificios() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LISTADOEDIFICIO);
		List<Edificio> listaEdif = edificioService.listaEdificios();

		mAV.addObject("edif", listaEdif);

		return mAV;

	}

	@GetMapping("/{id}")
	public ModelAndView listarEdificiosYaulas(@PathVariable("id") Long idEdificio, Model model,
			RedirectAttributes attributes) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIOYAULAS);

		Edificio edificio = null;
		if (idEdificio > 0) {
			edificio = edificioService.buscarPorID(idEdificio);
		}
		if (edificio == null) {
			attributes.addFlashAttribute("error", "*ERROR* el Edificio solicitado no existe");
			mAV.setViewName(ViewRouteHelper.LISTADOEDIFICIO);
		}

		List<Tradicional> tradicional = new ArrayList<>();
		List<Laboratorio> laboratorio = new ArrayList<>();

		for (Aula aula : edificio.getAulas()) {
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

}
