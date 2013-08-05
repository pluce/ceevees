/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;

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
}
