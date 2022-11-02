package com.trabajo.Grupo02OO22022.controller;

import java.util.List;

import javax.validation.Valid;

import com.trabajo.Grupo02OO22022.entity.Role;
import com.trabajo.Grupo02OO22022.entity.User;
import com.trabajo.Grupo02OO22022.helper.ViewRouteHelper;
import com.trabajo.Grupo02OO22022.service.IRoleService;
import com.trabajo.Grupo02OO22022.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/roles")
public class RoleController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Secured({ "ROLE_ADMIN", "ROLE_AUDITOR" })
    @GetMapping("/")
    public String listarRoles(Model model) {
        List<Role> listadoRoles = roleService.listarActivos();
        model.addAttribute("titulo", "Lista de roles");
        model.addAttribute("role", listadoRoles);

        return ViewRouteHelper.LISTAR_ROLES;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/create")
    public String crear(Model model) {
        Role role = new Role();
        List<User> listUser = userService.listarActivos();
        model.addAttribute("titulo", "Formulario: Nuevo Rol");
        model.addAttribute("role", role);
        model.addAttribute("user", listUser);

        return ViewRouteHelper.CREAR_ROLES;
    }

    // ********************* ABM Role ******************** */
    // Guardar User en BD
    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Role role, BindingResult result, Model model,
            RedirectAttributes attributes) {

        List<User> listUser = userService.listarActivos();
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo User");
            model.addAttribute("role", role);
            model.addAttribute("user", listUser);

            return ViewRouteHelper.CREAR_ROLES;
        }
        role.setDescripcion("ROLE_" + role.getDescripcion().toUpperCase());
        role.setEnabled(true);
        roleService.guardar(role);
        attributes.addFlashAttribute("success", "Role guardado con exito");

        return ViewRouteHelper.REDIRECT_ROLE;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idRole, Model model, RedirectAttributes attributes) {

        Role role = null;
        if (idRole > 0) {
            role = roleService.buscarPorID(idRole);
            role.setDescripcion(role.getDescripcion().split("ROLE_")[1]);
        }
        if (role == null) {
            attributes.addFlashAttribute("error", "*ERROR* el Rol solicitado no existe");

            // cambiar view
            return ViewRouteHelper.REDIRECT_ROLE;
        }

        List<User> listUser = userService.listarActivos();

        model.addAttribute("titulo", "Formulario: Editar Rol");
        model.addAttribute("role", role);
        model.addAttribute("user", listUser);

        // cambiar view
        return ViewRouteHelper.CREAR_ROLES;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idRole, RedirectAttributes attribute) {

        Role role = null;

        if (idRole > 0) {
            role = roleService.buscarPorID(idRole);
        }
        if (role == null) {
            attribute.addFlashAttribute("error", "*ERROR* el rol solicitado no existe");
            return ViewRouteHelper.REDIRECT_ROLE;
        }

        role.setEnabled(false);
        roleService.guardar(role);
        attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

        return ViewRouteHelper.REDIRECT_ROLE;
    }

    // ********************* ABM User ******************** */

}
