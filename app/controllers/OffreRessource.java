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
        renderJSON(Offre.findById(id));
    }
    
    public static Offre getObjectFromRequestBody(){
        String body = IO.readContentAsString(request.body);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Offre o = gson.<Offre>fromJson(body,Offre.class);
        return o;
    }
    
    public static void post(){
        try {
            Offre offre = getObjectFromRequestBody();
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
            Offre o = getObjectFromRequestBody();
            o.id = id;
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
    
}
