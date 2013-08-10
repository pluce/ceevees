/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.TenantProvider;
import org.hibernate.Session;
import play.db.jpa.JPA;
import play.libs.IO;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author Pluce
 */
@With(Secure.class)
public class TenantedController extends Controller {  
    @Before
    public static void before(){
        if(Security.isConnected()) {
            String id = Security.connectedTenant().id;
            TenantProvider.setCurrentTenant(id);
            ((Session)JPA.em().getDelegate()).enableFilter("tenant").setParameter("tenantId", id);
            renderArgs.put("user", Security.connectedTenant().login);
        } else {
            forbidden();
        }
    }
    
    
    public static <T> T getObjectFromRequestBody(Class<T> clazz){
        String body = IO.readContentAsString(request.body);
        Gson gson = new GsonBuilder()./*setDateFormat("yyyy-MM-dd'T'HH:mm:ss").*/create();
        T o = gson.<T>fromJson(body,clazz);
        return o;
    }
    
}
