package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.libs.Codec;
import play.test.Fixtures;

public class SpecialAdmin extends Controller {
    
    public static void reinit(){
        Fixtures.deleteDatabase();
        Utilisateur admin = new Utilisateur();
        admin.login = "admin";
        admin.password = Codec.hexSHA1("admin");
        admin.isAdmin = true;
        admin.email = "contact@pluce.net";
        admin.save();
    }

}