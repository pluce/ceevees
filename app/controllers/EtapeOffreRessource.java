/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ActionOffre;
import models.Offre;
import static controllers.OffreRessource.getObjectFromRequestBody;
import java.util.Date;

/**
 *
 * @author pluce
 */
public class EtapeOffreRessource extends TenantedController {
    
    private static Offre getOffre(String idOffre){
        return (Offre)Offre.findById(idOffre);
    }
    
    public static void get(String idOffre){
        Offre o = getOffre(idOffre);
        if(o==null)notFound();
        renderJSON(o.actions);
    }
    
    public static void post(String idOffre){
        try {
            Offre offre = getOffre(idOffre);
            if(offre==null)notFound();
            ActionOffre ao = getObjectFromRequestBody(ActionOffre.class);
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
