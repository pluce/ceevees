/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.ActionOffre;
import models.Offre;
import static controllers.OffreRessource.getObjectFromRequestBody;
import java.util.Date;
import play.libs.IO;
import play.mvc.Controller;

/**
 *
 * @author pluce
 */
public class EtapeOffreRessource extends TenantedController {
    
    private static Offre getOffre(String idOffre){
        return (Offre)Offre.findById(idOffre);
    }
    
    public static void get(String idOffre){
        renderJSON(getOffre(idOffre).actions);
    }
    
    public static ActionOffre getObjectFromRequestBody(){
        String body = IO.readContentAsString(request.body);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        ActionOffre o = gson.<ActionOffre>fromJson(body,ActionOffre.class);
        return o;
    }
    
    public static void post(String idOffre){
        try {
            Offre offre = getOffre(idOffre);
            ActionOffre ao = getObjectFromRequestBody();
            offre.actions.add(ao);
            ao.date = new Date();
            offre.etat = ao.newState;
            ao.save();
            offre.save();
            renderJSON(offre);
        } catch (Exception e){
            e.printStackTrace();
            response.status = 500;
            renderJSON(false);
        }
    }
}
