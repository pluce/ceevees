/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.io.StringReader;
import java.text.DateFormat;
import models.Contact;
import models.Offre;
import play.libs.IO;
import play.mvc.Controller;

/**
 *
 * @author pluce
 */
public class OffreRessource extends TenantedController{
    
    public static void get(){
        renderJSON(Offre.all().fetch());
    }
    
    public static void getId(String id){
        /*Offre o = Offre.findById(id);
        System.out.println(o.lettre);*/
        renderJSON(Offre.findById(id));
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
            Offre o = getObjectFromRequestBody(Offre.class);
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
            ((Offre)Offre.findById(id)).delete();
            renderJSON(true);
        } catch (Exception e){
            response.status = 500;
            renderJSON(false);
        }
    }
    
    public static void getContact(String idOffre){
        Offre o = Offre.findById(idOffre);
        renderJSON(o.contact);
    }
    
    public static void postContact(String idOffre){
        Contact c = getObjectFromRequestBody(Contact.class);
        Offre o = Offre.findById(idOffre);
        o.contact = c.merge();
        o.contact.validateAndSave();
        o.save();
    }
    
}
