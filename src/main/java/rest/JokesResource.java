package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ChuckDTO;
import dtos.DadDTO;
import dtos.MyJokeDTO;
import facades.JokeFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("joke")
public class JokesResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final JokeFacade FACADE =  JokeFacade.getJokeFacade(EMF);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getJoke() throws Exception {
        System.out.println("CHECK");

//        ChuckDTO chuckDTO = FACADE.createChuckDTO(FACADE.fetchData("https://api.chucknorris.io/jokes/random"));
//        System.out.println(chuckDTO);
//        DadDTO dadDTO = FACADE.createDadDTo(FACADE.fetchData("https://icanhazdadjoke.com/"));
//        MyJokeDTO myJokeDTO = new MyJokeDTO(chuckDTO,dadDTO);
        String test = FACADE.fetchData("https://api.kanye.rest/");

        return Response.ok().entity(test).build();

    }
}
