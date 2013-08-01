package controllers;

import models.Utilisateur;


/**
 *
 * @author Pluce
 */
public class Security extends Secure.Security {
    
    public static Utilisateur connectedTenant(){
        return Utilisateur.find("byLogin",connected()).first();
    }
    
    static boolean authenticate(String username, String password) {
        Utilisateur u = Utilisateur.find("byLoginAndPassword",username,password).first();
        if(u == null){
            return false;
        }
        return true;
    }
    
    static boolean check(String profile) {
        return isConnected();
    }
}