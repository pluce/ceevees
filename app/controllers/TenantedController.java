/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.TenantProvider;
import org.hibernate.Session;
import play.db.jpa.JPA;
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
}
