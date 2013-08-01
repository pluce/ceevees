/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import play.db.jpa.Model;

/**
 *
 * @author pluce
 */
@Entity
public class Offre extends MultiTenantModel{
    
    public String entreprise;
    public String ville;
    public String email;
    public String url;
    
    public String libelle;
    
    @Temporal(TemporalType.DATE)
    public Date dateAjout;
    
    @Enumerated
    public OffreState etat;
    
    @OneToMany
    public List<ActionOffre> actions = new ArrayList<ActionOffre>();
}
