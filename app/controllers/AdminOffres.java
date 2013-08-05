/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Offre;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author Pluce
 */
@With(Secure.class)
public class AdminOffres extends Controller{    
    @Check("admin")
    public static void getAll(){
        renderJSON(Offre.findAll());
    }
}
