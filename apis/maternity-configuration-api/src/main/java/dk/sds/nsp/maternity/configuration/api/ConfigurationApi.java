package dk.sds.nsp.maternity.configuration.api;

import dk.sds.nsp.maternity.configuration.exceptions.MergeConflictException;
import dk.sds.nsp.maternity.configuration.exceptions.ResourceNotFoundException;
import dk.sds.nsp.maternity.configuration.model.Topic;
import dk.sds.nsp.maternity.facade.common.jaxrs.RequestContext;
import dk.sds.nsp.maternity.configuration.model.Configuration;
import dk.sds.nsp.maternity.configuration.model.EditableConfiguration;
import dk.sds.nsp.maternity.configuration.service.ConfigurationService;
import dk.sds.nsp.maternity.configuration.spring.DependencyResolver;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ConfigurationApi {

    private final ConfigurationService service;
    private static final Logger LOGGER = Logger.getLogger(ConfigurationApi.class);

    public ConfigurationApi() {
        service = DependencyResolver.getConfigurationService();
    }

    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findByTopic(
            @QueryParam("topic") String topic,
            @QueryParam("target") String target
    ) {
        try {
            final List<Configuration> configuration = service.search(Topic.fromValue(topic), target);
            return Response
                    .ok()
                    .entity(configuration)
                    .build();
        } catch (IllegalArgumentException e) {
            LOGGER.error("Unknown topic '" + topic + "'", e);
            return Response.status(HttpStatus.SC_BAD_REQUEST)
                    .build();
        } catch (Exception e) {
            LOGGER.error("Failed to read configuration for topic '" + topic + "'", e);
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") String id) {
        try{
            final Configuration configuration = service.get(id);
            return Response
                    .ok()
                    .entity(configuration)
                    .build();
        } catch (ResourceNotFoundException e) {
            LOGGER.info("No configuration with id '" + id + "' could be found", e);
            return Response.status(HttpStatus.SC_NOT_FOUND)
                    .build();
        } catch (Exception e) {
            LOGGER.error("Failed to read configuration with id '" + id + "'", e);
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(
            @PathParam("id") String id,
            final EditableConfiguration configuration
    ) {
        try{
            final Configuration updated = service.update(id, configuration);
            return Response
                    .ok()
                    .entity(updated)
                    .build();
        } catch (ResourceNotFoundException e) {
            LOGGER.info("No configuration with id '" + id + "' could be found", e);
            return Response.status(HttpStatus.SC_NOT_FOUND)
                    .build();
        } catch (MergeConflictException e) {
            LOGGER.info("Merge conflict for configuration with id '" + id + "'", e);
            return Response.status(HttpStatus.SC_CONFLICT)
                    .build();
        } catch (Exception e) {
            LOGGER.error("Failed to update configuration with id '" + id + "'", e);
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") String id) {
        try{
            service.delete(id);
            return Response
                    .noContent()
                    .build();
        } catch (ResourceNotFoundException e) {
            LOGGER.info("No configuration with id '" + id + "' could be found", e);
            return Response.status(HttpStatus.SC_NOT_FOUND)
                    .build();
        } catch (MergeConflictException e) {
            LOGGER.info("Trying to delete configuration with id '" + id + "', but someone else has updated it", e);
            return Response.status(HttpStatus.SC_CONFLICT)
                    .build();
        } catch (Exception e) {
            LOGGER.error("Failed to delete configuration with id '" + id + "'", e);
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(final EditableConfiguration configuration) {
        try{
            final Configuration created = service.create(configuration);
            return Response
                    .created(getLocation(created))
                    .entity(created)
                    .build();
        } catch (Exception e) {
            LOGGER.error("Failed to create configuration", e);
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    private static URI getLocation(final Configuration created) {
        return URI.create(RequestContext.get().getUriInfo().getAbsolutePath() + "/" + created.getId());
    }
}
