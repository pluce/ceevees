/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    
    public String reference;
    
    @Lob
    @Column(columnDefinition="text")
    public String lettre;
    
    @OneToOne(cascade= CascadeType.ALL,orphanRemoval=true)
    public Contact contact = new Contact();
    
    public String libelle;
    
    @Temporal(TemporalType.DATE)
    public Date dateAjout;
    
    @Enumerated
    public OffreState etat;
    
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
    public List<ActionOffre> actions = new ArrayList<ActionOffre>();
}
