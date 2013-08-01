/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import play.db.jpa.Model;

/**
 *
 * @author pluce
 */
@Entity
public class ActionOffre extends MultiTenantModel{
    @Temporal(TemporalType.TIMESTAMP)
    public Date date;
    
    @Enumerated
    public OffreState newState;
    
    public String comment;
}
