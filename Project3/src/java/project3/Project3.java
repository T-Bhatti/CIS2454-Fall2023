package project3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tahre
 */
public class Project3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Ingredient> ingredients=new ArrayList();
        ingredients.add(new Ingredient("chicken breast","ounces",24));
        ingredients.add(new Ingredient("butter","tbsp",4));
        ingredients.add(new Ingredient("chicken broth","cups",.5));
        ingredients.add(new Ingredient("whipped cream","cups",.5));
        ingredients.add(new Ingredient("rosemerry","tbsp",1));
        String direction ="In a large skillet over medium heat, cook chicken in 1 tablespoon butter until a thermometer"
                + " reads 165°, 4-5 minutes on each side. Remove and keep warm.\n" +
"Add wine to pan; cook over medium-low heat, stirring to loosen browned bits from pan. Add cream and bring to a boil. "
                + "Reduce heat; cook and stir until slightly thickened. Stir in rosemary and remaining 3 tablespoons "
                + "butter until blended. Serve sauce with chicken.";
        Recipe recipe= new Recipe(ingredients,direction);
        ArrayList<Ingredient> newingredients=new ArrayList();
        double multiplier = Double.parseDouble(request.getParameter("multiplier"));
        for (Ingredient ingredient: ingredients){
            double quantity=ingredient.getNewQuantity(multiplier);
            String name=ingredient.getName();
            String measure=ingredient.getMeasure();
            newingredients.add(new Ingredient(name,measure,quantity));
        }
        request.setAttribute("direction",recipe.getDirection());
        request.setAttribute("ingredients",newingredients);
        getServletContext().getRequestDispatcher("/recipe.jsp").forward(request, response);
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
