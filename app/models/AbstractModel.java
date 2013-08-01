/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;
import play.db.jpa.GenericModel;

/**
 *
 * @author Pluce
 */
@MappedSuperclass
public class AbstractModel extends GenericModel  {
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    public String id;
    public String getId(){
        return id;
    }
    
  
    @Override
    public Object _key() {
        return getId();
    }
}
