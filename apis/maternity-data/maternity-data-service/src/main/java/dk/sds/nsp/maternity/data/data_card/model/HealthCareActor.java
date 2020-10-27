package dk.sds.nsp.maternity.data.data_card.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * HealthCareActor
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(HealthCareOrganization.class), @JsonSubTypes.Type(HealthCareProfessional.class)
})


public interface HealthCareActor {
}
