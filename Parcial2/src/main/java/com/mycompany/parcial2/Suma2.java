/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parcial2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcela Moran
 */
public class Suma2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String nom;
     int contador=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Suma2</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet Suma2 at " + request.getContextPath() + "</h1>");
            nom = request.getParameter("nombre");
            out.println("<h1>BIENVENIDO " + nom+"</h1>");
            int numero1 = Integer.parseInt(request.getParameter("numero1"));
            int numero2 = Integer.parseInt(request.getParameter("numero2"));
            int suma = numero1 + numero2;
            out.println("\n<h3>El resultado de la suma es de: " + suma+"</h3>");
            out.println("\n<h3>Numeros primos que hay entre el rango de "+numero1+" y "+numero2+":</h3>");
            for(int num1=numero1; num1<=numero2;num1++){
                if(esPrimo(num1)){
                   contador++;
                    out.println(String.valueOf(num1)+",");
                }
            }
            //out.println("<br>");
            out.println("\n<h3>Total de numeros primos: "+contador+"</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public static boolean esPrimo(int numero){
        // el 0,1 y 4 no son primos
        if(numero==0 || numero==1 || numero==4){
            return false;
        }
        for(int x=2; x<numero/2; x++){
            //si es divisble por cualquiera de estos numeros no es primo
            if(numero % x==0)
                return false;
        }
        return true;
        
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
