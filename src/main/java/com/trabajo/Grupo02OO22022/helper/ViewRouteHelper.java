package com.trabajo.Grupo02OO22022.helper;

public class ViewRouteHelper {

    /**** Views ****/
    // HOME
    public final static String LISTAR = "/views/users/listar";
    public final static String CREAR = "/views/users/frmCrear";

    // USER
    public final static String LOGIN = "/user/login";

    // ROLES
    public final static String LISTAR_ROLES = "/views/roles/listar";
    public final static String CREAR_ROLES = "/views/roles/frmCrear";

    // /**** Redirects ****/
    public final static String HOME_ROOT = "/home";
    public final static String REDIRECT_CLIENTE = "redirect:/views/users/";
    public final static String REDIRECT_ROLE = "redirect:/views/roles/";
    public final static String REDIRECT_HOME = "redirect:/home";
    public final static String REDIRECT_AGREGARESPACIO = "redirect:/views/agregarespacio";

    public final static String BUSCARAULA = "/views/traer/buscarAula";
    public final static String RESULTADOAULA = "/views/traer/traerAula";

    public final static String EDIFICIOYAULAS = "/views/traer/edificiosAulas";
    public final static String LISTADOEDIFICIO = "/views/traer/edificioslistar";
    public final static String RESULTADOESPACIO = "/views/traer/traerEspacio";
    public final static String BUSCARESPACIO = "/views/traer/buscarEspacio";
    public final static String AGREGARESPACIO = "/views/agregar/agregarEspacio";
    // -----Aylu-----
    public final static String AGREGARESPACIOMES = "/views/agregar/agregarEspacioMes";
    // ---------------

    public final static String ASIGNARESPACIOPEDIDO = "/views/traer/asignarEspacioPedido";

    public final static String PEDIRAULAFINAL = "/views/agregar/pedidoParaFinal";
    public final static String PEDIRAULACURSO = "/views/agregar/pedidoParaCurso";

    public final static String PEDIDOSLISTAR = "/views/traer/listarPedidos";
    public final static String REDIRECT_PEDIDO = "redirect:/pedido/listaPedidos";

}
