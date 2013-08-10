/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Contact;
import models.Utilisateur;
import play.mvc.With;

/**
 *
 * @author Pluce
 */
public class UtilisateurRessource extends TenantedController{
    public static void details(){
        renderJSON(Security.connectedTenant().details);
    }
    
    public static void postDetails(){
        Contact c = getObjectFromRequestBody(Contact.class);
        Utilisateur me = Security.connectedTenant();
        me.details = c.merge();
        me.details.validateAndSave();
        me.save();
    }
}
