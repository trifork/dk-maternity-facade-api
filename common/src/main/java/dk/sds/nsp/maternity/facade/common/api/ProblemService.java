package dk.sds.nsp.maternity.facade.common.api;

import dk.sds.nsp.maternity.facade.problems.Problem;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("/problems")
public class ProblemService {

    public static final String PATH = "problems";

    @GET
    @Path("{problem}")
    @Produces(MediaType.TEXT_HTML)
    public InputStream getProblem(@PathParam("problem") final String problem) {
        return Problem.class.getResourceAsStream(problem);
    }
}
