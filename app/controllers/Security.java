package controllers;

import models.Utilisateur;
import play.libs.Codec;


/**
 *
 * @author Pluce
 */
public class Security extends Secure.Security {
    
    public static Utilisateur connectedTenant(){
        return Utilisateur.find("byLogin",connected()).first();
    }
    
    
    static boolean authenticate(String username, String password) {
        if(request.params.get("email") != null && request.params.get("passwordbis") != null){    
            
            if(request.params.get("username").length() == 0){
                flash.put("errorRegister", "Un identifiant vide n'est pas une bonne idée.");
                return false;
            }   
            if(Utilisateur.find("byLogin",username).fetch().size() > 0){
                flash.put("errorRegister", "Cet identifiant est déjà utilisé, veuillez en changer.");
                return false;
            }   
            if(Utilisateur.find("byEmail",request.params.get("email")).fetch().size() > 0){
                flash.put("errorRegister", "Cet email est déjà utilisé, veuillez en changer.");
                return false;
            }               
            if(request.params.get("passwordbis").length() == 0 || request.params.get("password").length() == 0 ){
                flash.put("errorRegister", "Un mot de passe vide n'est pas une bonne idée.");
                return false;
            }
            if(!request.params.get("passwordbis").equals(password)){
                flash.put("errorRegister", "Les deux mots de passe ne correspondent pas.");
                return false;
            }
            if(!validation.email(request.params.get("email")).ok){
                flash.put("errorRegister", "L'email n'est pas correct");
                return false;
            }
            Utilisateur util = new Utilisateur();
            util.login = username;
            util.password = Codec.hexSHA1(password);
            util.email = request.params.get("email");
            util.isAdmin = false;
            util.save();
            return true;
        }
        
        Utilisateur u = Utilisateur.find("byLoginAndPassword",username,Codec.hexSHA1(password)).first();
        if(u == null){
            return false;
        }
        return true;
    }
    
    static boolean check(String profile) {
        if(profile.equals("admin")){
            Utilisateur u = connectedTenant();
            if(u.isAdmin == null || u.isAdmin.equals(false)){
                return false;
            } else {
                return true;
            }
        }
        return isConnected();
    }
}