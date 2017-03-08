package servlet;

import entidade.Carro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCarro", urlPatterns = {"/ServletCarro"})
public class ServletCarro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomeCarro = request.getParameter("nomeCarro");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String potencia = request.getParameter("potencia");
        String cor = request.getParameter("cor");
        String placa = request.getParameter("placa");
        String ativo = request.getParameter("ativo");
        
        Carro carro = new Carro();
        
        carro.setNomeCarro(nomeCarro);
        carro.setMarca(marca);
        carro.setPotencia(Double.parseDouble(potencia));
        carro.setModelo(modelo);
        carro.setCor(cor);
        carro.setPlaca(placa);
        if (ativo != null && ativo.equals("on")){
            carro.setAtivo(true);
        } else {
            carro.setAtivo(false);
        }
        
        List<Carro> carrosCadastrados = new ArrayList<>();
        if(request.getSession().getAttribute("carrosCadastrados") != null) {
            carrosCadastrados = (List<Carro>) request.getAttribute("carrosCadastrados");
        }
        carrosCadastrados.add(carro);
        request.getSession().setAttribute("carrosCadastrados", carrosCadastrados);
        
        response.sendRedirect("/FormularioServlet/index.jsp");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}