package com.trabajo.Grupo02OO22022.controller;

import com.trabajo.Grupo02OO22022.entity.Edificio;
import com.trabajo.Grupo02OO22022.entity.Laboratorio;
import com.trabajo.Grupo02OO22022.entity.Tradicional;
import com.trabajo.Grupo02OO22022.helper.ViewRouteHelper;
import com.trabajo.Grupo02OO22022.service.AulaServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/traer")
public class TraerController {

	@Autowired
	@Qualifier("aulaService")
	public AulaServiceImplements aulaService;

	@Secured({ "ROLE_ASISTENTE", "ROLE_ADMIN_GENERAL" })
	@GetMapping("/buscar")
	public ModelAndView buscarAula() {
		long idabuscar = 0;
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.BUSCARAULA);
		mAV.addObject("idabuscar", idabuscar);

		return mAV;

	}

	@Secured({ "ROLE_ASISTENTE", "ROLE_ADMIN_GENERAL" })
	@PostMapping("/aulaxid")
	public ModelAndView aulaEncontrada(long idabuscar, RedirectAttributes attributes) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RESULTADOAULA);
		Tradicional tradicional = aulaService.buscarPorID(idabuscar);
		Laboratorio laboratorio = aulaService.buscarPorIDLab(idabuscar);
		if (laboratorio == null && tradicional == null) {
			attributes.addFlashAttribute("error", "Aula no encontrada");
			mAV.setViewName(ViewRouteHelper.REDIRECT_HOME);
		}

		if (tradicional != null) {
			laboratorio = new Laboratorio();
			laboratorio.setEdificio(new Edificio());

		} else if (laboratorio != null) {
			tradicional = new Tradicional();
			tradicional.setEdificio(new Edificio());

		}
		mAV.addObject("tradicional", tradicional);
		mAV.addObject("laboratorio", laboratorio);

		return mAV;

	}

}
