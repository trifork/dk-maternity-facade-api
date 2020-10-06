package dk.sds.nsp.maternity.facade.maternity.api;

import dk.sds.nsp.maternity.facade.common.security.SessionContext;
import dk.sds.nsp.maternity.facade.maternity.model.CprIdentifiedPerson;
import dk.sds.nsp.maternity.facade.maternity.model.DataCard;
import dk.sds.nsp.maternity.facade.maternity.model.HealthCareOrganization;
import dk.sds.nsp.maternity.facade.maternity.model.PersonName;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.UUID;

import static dk.sds.nsp.maternity.facade.maternity.security.SecurityHandler.updateContextCookie;

@Path("data-card")
@Produces(MediaType.APPLICATION_JSON)
public class DataCardService {

    private final DataCard dataCard;

    public DataCardService() {
        final HealthCareOrganization author = new HealthCareOrganization();
        author.setName("Jeppe Gravgaard");

        final PersonName name = new PersonName();
        name.addFirstNamesItem("Ronnie");
        name.addMiddleNamesItem("Birkelund");
        name.setLastName("Trøjborg");

        final CprIdentifiedPerson recordTarget = new CprIdentifiedPerson();
        recordTarget.setIdentifier("6509810001");
        recordTarget.setName(name);

        dataCard = new DataCard();
        dataCard.setModifiedTime(LocalDateTime.now());
        dataCard.setAuthor(author);
        dataCard.setRecordTarget(recordTarget);
    }

    @GET
    public Response getDataCards(
            @CookieParam("context") final SessionContext context,
            @HeaderParam("X-Patient-Identifier") final String patientIdentifier,
            @HeaderParam("X-Break-The-Glass-Reason") final String breakTheGlassReason) {
        return Response
                .ok()
                .entity(new DataCard[] { dataCard })
                .cookie(updateContextCookie(context))
                .build();
    }

    @GET
    @Path("{identifier}")
    public Response getDataCard(
            @CookieParam("context") final SessionContext context,
            @PathParam("identifier") final UUID id) {
        return Response
                .ok()
                .entity("identifier = " + id)
                .cookie(updateContextCookie(context))
                .build();
    }
}