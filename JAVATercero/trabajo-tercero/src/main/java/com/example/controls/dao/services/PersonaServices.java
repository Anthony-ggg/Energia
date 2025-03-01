package com.example.controls.dao.services;

import com.example.controls.dao.PersonaDao;
import com.example.controls.tda.list.LinkedList;
import com.example.models.Persona;


public class PersonaServices {
    private PersonaDao obj;

    public PersonaServices() {
        obj = new PersonaDao();
    }
    
    
    public Boolean save() throws Exception {
        return obj.save();
    }
    

    public LinkedList listAll() {
        return obj.getListAll();
    }

    public Persona getPersona() {
        return obj.getPersona();
    }
   

    public void setPersona(Persona persona) {
        obj.setPersona(persona);
    }
    public Persona get(Integer id) throws Exception {
        return obj.get(id);
    }
   
  
}
