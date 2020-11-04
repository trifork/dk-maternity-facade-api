package dk.sds.nsp.maternity.lexicon.api;

import dk.sds.nsp.maternity.facade.common.util.Problems;
import dk.sds.nsp.maternity.lexicon.exceptions.IllegalParameterValueException;
import dk.sds.nsp.maternity.lexicon.exceptions.NoConnectionToServiceException;
import dk.sds.nsp.maternity.lexicon.model.Catalogue;
import dk.sds.nsp.maternity.lexicon.model.ProblemDetails;
import dk.sds.nsp.maternity.lexicon.model.ProblemDetailsInvalidparams;
import dk.sds.nsp.maternity.lexicon.service.LexiconService;
import dk.sds.nsp.maternity.lexicon.spring.DependencyResolver;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class LexiconApi {

    private final LexiconService service;
    private static final Logger LOGGER = Logger.getLogger(LexiconApi.class);

    public LexiconApi() {
        service = DependencyResolver.getLexiconService();
    }

    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response query(
        @QueryParam("page") Integer pageNumber,
        @QueryParam("order-by") String orderBy,
        @QueryParam("tags")  List<String> tags,
        @QueryParam("categories") List<String> categories,
        @QueryParam("query") String query
    ) {
        try {
            Catalogue result = service.query(pageNumber, orderBy, tags, categories, query);
            return Response.ok(result)
                    .build();
        } catch (NoConnectionToServiceException e) {
            return error(
                    e,
                    Response.Status.BAD_GATEWAY,
                    "No connection to underlying CMS",
                    "We could not connect to the Content Management System that provides the data for the lexicon. Please try again later",
                    "bad-gateway.html"
            );
        } catch (IllegalParameterValueException e) {
            return error(
                    e,
                    Response.Status.BAD_REQUEST,
                    "An illegal parameter was received",
                    "Received an illegal parameter",
                    "bad-request.html",
                    e.getIllegalParameters()
            );
        } catch (Exception e) {
            return error(
                    e,
                    Response.Status.INTERNAL_SERVER_ERROR,
                    "Unexpected error",
                    "An unexpected error occurred when querying the lexicon",
                    "unknown-error.html"
            );
        }
    }

    @Path("/category")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response test() {
        return Response.ok(service.getCategories()).build();
    }

    private Response error(Throwable exception, Response.Status errorCode, String title, String details, String type) {
        return error(exception, errorCode, title, details, type, null);
    }
    private Response error(Throwable exception, Response.Status errorCode, String title, String details, String type, List<ProblemDetailsInvalidparams> invalidParams) {
        String errorId = UUID.randomUUID().toString();
        LOGGER.info(String.format("ERROR_ID=%s %s", errorId, title), exception);
        return Response.status(errorCode)
                .entity(
                        new ProblemDetails()
                                .status(errorCode.getStatusCode())
                                .title(title)
                                .detail(String.format("%s. The Error id is '%s'", details, errorId))
                                .invalidParams(invalidParams)
                                .type(Problems.typeFor(type))

                ).build();
    }

}
