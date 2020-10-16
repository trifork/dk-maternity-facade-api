package dk.sds.nsp.maternity.facade.maternity.api;

import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;
import dk.sds.nsp.maternity.facade.maternity.model.CprIdentifiedPerson;
import dk.sds.nsp.maternity.facade.maternity.model.CreateDataCardRequest;
import dk.sds.nsp.maternity.facade.maternity.model.DataCard;
import dk.sds.nsp.maternity.facade.maternity.model.DataCardResponse;
import dk.sds.nsp.maternity.facade.maternity.model.HealthCareOrganization;
import dk.sds.nsp.maternity.facade.maternity.model.PersonName;
import dk.sds.nsp.maternity.facade.maternity.security.SessionContext;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("data-card")
@Produces(MediaType.APPLICATION_JSON)
public class DataCardService {

    private final DataCardResponse dataCardResponse;

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

        dataCardResponse = new DataCardResponse();
        dataCardResponse.setModifiedTime(LocalDateTime.now());
        dataCardResponse.setAuthor(author);
        dataCardResponse.setRecordTarget(recordTarget);
        dataCardResponse.setEpisodeOfCareIdentifier(UUID.fromString("a312e032-8007-59cd-ba66-022cb8146b04"));
    }

    @GET
    public Response getDataCards(
            @CookieParam("context") final SessionContext context,
            @HeaderParam("X-Patient-Identifier") final String patientIdentifier,
            @HeaderParam("X-Break-The-Glass-Reason") final String breakTheGlassReason) {
        return Response
                .ok()
                .entity(new DataCard[] {dataCardResponse})
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDataCard(
            @CookieParam("context") final SessionContext context,
            final CreateDataCardRequest dataCard) {
        final DataCardResponse created = dataCardResponse;
        return Response
                .created(getLocation(created))
                .entity(created)
                .build();
    }

    @GET
    @Path("{identifier}")
    public Response getDataCard(
            @CookieParam("context") final SessionContext context,
            @PathParam("identifier") final UUID id) {
        return id.equals(dataCardResponse.getEpisodeOfCareIdentifier()) ?
                Response
                        .ok()
                        .entity(dataCardResponse)
                        .build() :
                Response.noContent().build();
    }

    @PUT
    @Path("{identifier}")
    public Response updateDataCard(
            @CookieParam("context") final SessionContext context,
            @PathParam("identifier") final UUID id) {
        return id.equals(dataCardResponse.getEpisodeOfCareIdentifier()) ?
                Response
                        .ok()
                        .entity(dataCardResponse)
                        .build() :
                Response.status(NOT_FOUND).build();
    }

    @DELETE
    @Path("{identifier}")
    public Response deleteDataCard(
            @CookieParam("context") final SessionContext context,
            @PathParam("identifier") final UUID id) {
        return id.equals(dataCardResponse.getEpisodeOfCareIdentifier()) ?
                Response
                        .ok()
                        .build() :
                Response.status(NOT_FOUND).build();
    }

    private static URI getLocation(final DataCardResponse created) {
        return URI.create(RequestContext.get().getUriInfo().getAbsolutePath() + "/" + created.getEpisodeOfCareIdentifier().toString());
    }

}