/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Arrays;
import java.util.List;
import models.Offre;
import models.Utilisateur;
import play.modules.pdf.PDF;

/**
 *
 * @author Pluce
 */
public class LettreRessource extends TenantedController{
    
    public static void getLettre(String idOffre){
        Offre offre = Offre.findById(idOffre);
        if(offre == null) notFound();
        Utilisateur utilisateur = Security.connectedTenant();
        List<String> paragraphes = null;
        if(offre.lettre != null) paragraphes = Arrays.asList(offre.lettre.split("\n"));
        PDF.renderPDF(offre,utilisateur,paragraphes);
    }
    
}
