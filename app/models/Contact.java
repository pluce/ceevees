/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 *
 * @author Pluce
 */
@Entity
public class Contact extends MultiTenantModel{
    @Enumerated
    public Sexe sexe = Sexe.HOMME;
    public String nom;
    public String prenom;
    public String adresse;
    public String codePostal;
    public String ville;
    public String telephone;
    public String email;
    public String fonction;
}
