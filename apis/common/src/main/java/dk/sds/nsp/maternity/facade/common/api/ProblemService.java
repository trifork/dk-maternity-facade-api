package dk.sds.nsp.maternity.facade.common.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

import static dk.sds.nsp.maternity.facade.common.api.ProblemService.PATH;

@Path(PATH)
public class ProblemService {

    public static final String PATH = "problems/";
    private final ClassLoader classLoader;

    public ProblemService() {
        classLoader = getClass().getClassLoader();
    }

    @GET
    @Path("{problem}")
    @Produces(MediaType.TEXT_HTML)
    public InputStream getProblem(@PathParam("problem") final String problem) {
        return classLoader.getResourceAsStream("rfc7807/" + problem);
    }
}
