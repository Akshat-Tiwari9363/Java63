package com.jersey;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("Student")
public class StudentResource {

    StudentRepo repo=new StudentRepo();

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Student> getStudent(){
        return repo.getStudents();
    }

    @GET
    @Path("get/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Student get(@PathParam("id") int id){
        return repo.getStudent(id);
    }

    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Student create(Student s1){
        repo.create(s1);
        return s1;
    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Student update(Student s1){
        if(repo.getStudent(s1.getId()).getId()!=0){
            repo.update(s1);
        }else{
            s1.setName("Record not found");
        }
        return s1;
    }

    @DELETE
    @Path("delete/{id}")
    public Student delete(@PathParam("id") int id){
        Student s1=repo.getStudent(id);
        if(s1.getId()!=0){
            repo.delete(id);
        }else{
            s1.setName("Record not found");
        }
        return s1;
    }
    
}
