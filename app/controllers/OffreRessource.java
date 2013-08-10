/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Contact;
import models.Offre;

/**
 *
 * @author pluce
 */
public class OffreRessource extends TenantedController{
    
    public static void get(){
        renderJSON(Offre.all().fetch());
    }
    
    public static void getId(String id){
        Offre o = Offre.loadById(id,Offre.class);
        if(o == null) notFound();
        
        renderJSON(o);
    }
    
    public static void post(){
        try {
            Offre offre = getObjectFromRequestBody(Offre.class);
            offre.save();
            System.out.println(offre.entreprise);
            renderJSON(offre);
        } catch (Exception e){
            e.printStackTrace();
            response.status = 500;
            renderJSON(false);
        }
    }
    
    public static void put(String id){
        try {
            Offre o = Offre.loadById(id,Offre.class);
            if(o == null) notFound();
            o = getObjectFromRequestBody(Offre.class);
            o.id = id;
            o.contact = o.contact.merge();
            o = o.merge();
            o.save();
            renderJSON(true);
        } catch (Exception e){
            e.printStackTrace();
            response.status = 500;
            renderJSON(false);
        }
    }
    
    public static void delete(String id){
        try {
            Offre o = Offre.loadById(id,Offre.class);
            if(o == null) notFound();
            o.delete();
            renderJSON(true);
        } catch (Exception e){
            response.status = 500;
            renderJSON(false);
        }
    }
    
    public static void getContact(String idOffre){
        Offre o = Offre.loadById(idOffre,Offre.class);
        if(o == null) notFound();
        renderJSON(o.contact);
    }
    
    public static void postContact(String idOffre){
        Contact c = getObjectFromRequestBody(Contact.class);
        Offre o = Offre.loadById(idOffre,Offre.class);
        if(o == null) notFound();
        o.contact = c.merge();
        o.contact.validateAndSave();
        o.save();
    }
    
}
