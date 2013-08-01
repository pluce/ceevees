/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import play.db.jpa.GenericModel;

/**
 *
 * @author Pluce
 */
@MappedSuperclass
@FilterDef(
    name="tenant",
    parameters={
        @ParamDef( name="tenantId", type="string") },
        defaultCondition=":tenantId = tenantId")
@Filter(name="tenant")
public class MultiTenantModel extends AbstractModel {
    
    public String tenantId = TenantProvider.getCurrentTenant();

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    
    /**
     * Return true if the entity is owned by given tenant id
     * @param id
     * @return true if id == tenantId
     */
    public boolean isOwnedBy(String id){
        return id.equals(tenantId);
    }
}
