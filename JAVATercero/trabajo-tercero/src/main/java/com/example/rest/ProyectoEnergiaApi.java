package com.example.rest;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.controls.dao.ProyectoEnergiaDao;
import com.example.controls.dao.services.PersonaServices;
import com.example.controls.dao.services.ProyectoEnergiaServices;
import com.google.gson.Gson;
import com.example.models.*;



@Path("energia")
public class ProyectoEnergiaApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProyectoEnergia() {
        HashMap map = new HashMap<>();
        ProyectoEnergiaServices ps = new ProyectoEnergiaServices();
        map.put("msg", "OK");
        map.put("data", ps.listAll().toArray());
        if (ps.listAll().isEmpty()) {
            map.put("data", new Object[]{});

        }
        return Response.ok(map).build();
    } 
    /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        HashMap mapa = new HashMap<>();
        ProyectoEnergiaServices pd = new ProyectoEnergiaServices();
        //PersonaServices pd = new PersonaServices();
        String aux = "";
        try {
            pd.getProyectoEnergia().setNombre("Proyecto 1");
            pd.getProyectoEnergia().setInversion(1000.0);       
            pd.getProyectoEnergia().setTiempoVida(10);
            pd.getProyectoEnergia().setFechaInicio("12/12/2020");
            pd.getProyectoEnergia().setFechaFin("12/12/2021");
            pd.getProyectoEnergia().setCapacidadDiaria(100.0);
            pd.save(); 
            
          
            aux = "La lista esta vasia"+pd.listAll().isEmpty();
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        mapa.put("msg","Ok");
        mapa.put("data", "test"+aux);
        return Response.ok(mapa).build();
    } */
 

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap map) {
        HashMap res = new HashMap<>();
        
            /// TODO
            /// VALIDACION
       
        System.out.println("ASAS");
        ProyectoEnergiaDao ps = new ProyectoEnergiaDao();
        
       

        try {
            ps.getProyectoEnergia().setNombre(map.get("nombre").toString());
            ps.getProyectoEnergia().setInversion(Double.parseDouble(map.get("inversion").toString()));
            ps.getProyectoEnergia().setTiempoVida(Integer.parseInt(map.get("tiempoVida").toString()));
            ps.getProyectoEnergia().setFechaInicio(map.get("fechaInicio").toString());
            ps.getProyectoEnergia().setFechaFin(map.get("fechaFin").toString());
            ps.getProyectoEnergia().setCapacidadDiaria(Double.parseDouble(map.get("capacidadDiaria").toString()));
            
            System.out.println("ASs");

            ps.save();
            res.put("msg", "OK");
            res.put("data", "Proyecto Registarado");
            return Response.ok(res).build();

            
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.BAD_REQUEST).entity(res).build();

        }

    }
    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProyectoEnergia(@PathParam ("id")Integer  id) {
        HashMap map = new HashMap<>();
        ProyectoEnergiaServices ps = new ProyectoEnergiaServices();
       
        try {
            ps.setProyectoEnergia(ps.get(id));
        } catch (Exception e) {
            
        }
        map.put("msg", "Ok");
        map.put("data", ps.getProyectoEnergia());
        
        if (ps.getProyectoEnergia().getId() == null) {
            
            map.put("data", "Persona no encontrada");
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }
        
        return Response.ok(map).build();

    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap map) {
        HashMap res = new HashMap<>();
        
            /// TODO
            /// VALIDACION
       
        System.out.println("ASAS");
        
    
        try {
            ProyectoEnergiaDao ps = new ProyectoEnergiaDao();
            ps.setProyectoEnergia(ps.get(Integer.parseInt(map.get("id").toString())));
            ps.getProyectoEnergia().setNombre(map.get("nombre").toString());
            ps.getProyectoEnergia().setInversion(Double.parseDouble(map.get("inversion").toString()));
            ps.getProyectoEnergia().setTiempoVida(Integer.parseInt(map.get("tiempoVida").toString()));
            ps.getProyectoEnergia().setFechaInicio(map.get("fechaInicio").toString());
            ps.getProyectoEnergia().setFechaFin(map.get("fechaFin").toString());
            ps.getProyectoEnergia().setCapacidadDiaria(Double.parseDouble(map.get("capacidadDiaria").toString()));
            
            System.out.println("ASs");

            ps.update();
            res.put("msg", "OK");
            res.put("data", "Proyecto Registarado");
            return Response.ok(res).build();

            
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.BAD_REQUEST).entity(res).build();

        }

    }








}