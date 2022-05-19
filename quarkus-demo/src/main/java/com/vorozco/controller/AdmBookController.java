package com.vorozco.controller;

import com.vorozco.model.AdmBook;
import com.vorozco.repository.AdmBookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books/")
@ApplicationScoped
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdmBookController {
    AdmBookRepository admBookRepository;

    @Inject
    public AdmBookController(AdmBookRepository admBookRepository) {
        this.admBookRepository = admBookRepository;
    }

    @GET
    public List<AdmBook> getBooks() {
        return admBookRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public AdmBook getBook(@PathParam("id") Long id) {
        return admBookRepository.findById(id);
    }

    @POST
    public Response createBook(AdmBook admBook) {
        admBookRepository.persist(admBook);
        return Response.status(Response.Status.CREATED).entity(admBook).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") Long id, AdmBook admBook) {
        admBook = admBookRepository.update(admBook);
        return Response.ok(admBook).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        var admBook = admBookRepository.findById(id);
        admBookRepository.delete(admBook);
        return Response.ok().build();
    }

}
