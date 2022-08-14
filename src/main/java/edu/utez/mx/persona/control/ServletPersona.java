package edu.utez.mx.persona.control;

import edu.utez.mx.persona.modelo.BeanPersona;
import edu.utez.mx.persona.servicios.ServicePersona;
import edu.utez.mx.persona.utils.ResultAction;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "ServletPersona",
        urlPatterns = {
                "/consultar",
                "/registrar",
                "/crear",
                "/modificar",
                "/actualizar",
                "/eliminar"

        })
public class ServletPersona extends HttpServlet {

    Logger logger = Logger.getLogger("ServletPersona");
    String action;
    String urlRedirect = "/consultar";
    ServicePersona servicePersona = new ServicePersona();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path->" + action);
        switch (action) {
            case "/consultar":
                try {
                    request.setAttribute("personas",servicePersona.getAll());
                    urlRedirect = "/vistas/consulta.jsp";
                }catch (Exception e){
                    urlRedirect = "/consultar";
                }
                break;
            case "/registrar":
                try {
                    urlRedirect = "/vistas/registro.jsp";
                }catch (Exception e){
                    urlRedirect = "/consultar";
                }
                break;
            case "/modificar":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                try {
                    BeanPersona persona = servicePersona.getUsuario(Long.parseLong(id));
                    request.setAttribute("persona",persona);
                    urlRedirect = "/vistas/modificar.jsp";
                } catch (Exception e) {
                    urlRedirect = "/get-pokemons";
                }
                break;
            default:
                urlRedirect = "/consultar";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch (action) {
            case "/crear":
                try {
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String curp = request.getParameter("curp");
                    String birthday = request.getParameter("birthday");
                    BeanPersona persona = new BeanPersona();
                    persona.setName(name);
                    persona.setSurname(surname);
                    persona.setCurp(curp);
                    persona.setBirthday(birthday);
                    ResultAction rsElm = servicePersona.save(persona);
                    urlRedirect = "/consultar?result=" +
                            rsElm.isResult() + "&message=" + URLEncoder.encode(rsElm.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + rsElm.getStatus();
                } catch (Exception e) {
                    urlRedirect = "/consultar?result=false" + "&message="
                            + URLEncoder.encode(e.toString(), StandardCharsets.UTF_8.name())
                            + "&status=500";
                }
                break;
            case "/actualizar":
                try {
                    String id= request.getParameter("id");
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String curp = request.getParameter("curp");
                    String birthday = request.getParameter("birthday");
                    BeanPersona persona = new BeanPersona();
                    persona.setId(Long.parseLong(id));
                    persona.setName(name);
                    persona.setSurname(surname);
                    persona.setCurp(curp);
                    persona.setBirthday(birthday);
                    ResultAction rsElm = servicePersona.update(persona);
                    urlRedirect = "/consultar?result=" +
                            rsElm.isResult() + "&message=" + URLEncoder.encode(rsElm.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + rsElm.getStatus();
                } catch (Exception e) {
                    urlRedirect = "/consultar?result=false" + "&message="
                            + URLEncoder.encode(e.toString(), StandardCharsets.UTF_8.name())
                            + "&status=500";
                }
                break;
            case "/eliminar":
                try {
                    String id_elm = request.getParameter("id");
                    id_elm = (id_elm == null) ? "0" : id_elm;
                    ResultAction rsElm = servicePersona.delete(Long.parseLong(id_elm));
                    urlRedirect = "/consultar?result=" +
                            rsElm.isResult() + "&message=" + URLEncoder.encode(rsElm.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + rsElm.getStatus();
                } catch (Exception e) {
                    urlRedirect = "/consultar?result=false" + "&message="
                            + URLEncoder.encode(e.toString(), StandardCharsets.UTF_8.name())
                            + "&status=500";
                }
                break;

            default:
                urlRedirect = "/consultar";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
