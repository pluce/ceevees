@FilterDef(
        name="tenant",
        parameters={
            @ParamDef( name="tenantId", type="string") },
            defaultCondition=":tenantId = tenantId")
package models;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

