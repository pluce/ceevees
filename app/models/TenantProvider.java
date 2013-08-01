/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import play.db.jpa.Model;

/**
 *
 * @author Pluce
 */
public class TenantProvider {
    public static String tenant;
    
    public static void setCurrentTenant(String id){
        tenant = id;
    }
    
    public static String getCurrentTenant(){
        return tenant;
    }
}
