/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Utilisateur;
import play.mvc.Controller;

/**
 *
 * @author pluce
 */
public class Register extends Controller {
    public static void register(String username,String password,String passwordbis,String email) throws Throwable{
        Utilisateur util = new Utilisateur();
        util.login = username;
        util.password = password;
        util.email = email;
        util.save();
    }
}
