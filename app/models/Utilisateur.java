/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pluce
 */
@Entity
public class Utilisateur extends AbstractModel {
    public String login;
    public String password;
    public String email;
    
    
    public Boolean isAdmin = false;
    
    @Temporal(TemporalType.DATE)
    public Date dateAjout;
    
    @OneToOne(cascade= CascadeType.ALL,orphanRemoval=true)
    public Contact details = new Contact();
}
