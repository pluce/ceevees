package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.test.Fixtures;

@With(Secure.class)
public class Application extends TenantedController {

    public static void index() {
       /* Utilisateur pierre = new Utilisateur();
        pierre.login = "pierre";
        pierre.password = "pierre";
        pierre.email = "pierre@pierre.com";
        Utilisateur celine = new Utilisateur();
        celine.login = "celine";
        celine.password = "celine";
        celine.email = "celine@celine.com";
        
        pierre.save();
        celine.save();*/
        render();
    }

}