package com.ikeasistencia.apicorreos.ApiCorreos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ikeasistencia.apicorreos.ApiCorreos.DTO.PwaContent;
import com.ikeasistencia.apicorreos.ApiCorreos.Entity.Plantillas;
import com.ikeasistencia.apicorreos.ApiCorreos.repository.PlantillasRepositorio;
import com.ikeasistencia.apicorreos.ApiCorreos.servicios.*;

import java.util.Map;

import java.io.StringReader;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

@RestController

public class CorreoController {

    @Autowired
    private CorreoService correoService;
    
    @Autowired
    PlantillasRepositorio repositorio;

    @PostMapping("/correo")
    public Map<String, String> enviaCorreo(@RequestBody Map<String, String> body) {

        HashMap<String, String> response = new HashMap<>();
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String template = " ";
        String nombreDestinatario = body.get("nombreDestinatario");
        String correoDestinatario = body.get("correoDestinatario");
        //String opcion = body.get("idCorreo");

        Plantillas opcion = repositorio.findById(Long.valueOf(body.get("idCorreo")));
        String correoRemitente = body.get("correoRemitente");
        String nombreRemitente = body.get("nombreRemitente");
        String asunto = body.get("asunto");
        Matcher matcher = pattern.matcher(correoDestinatario);
        Matcher matcherRem = pattern.matcher(correoRemitente);
        template = opcion.getNombreTemplate();
        if(Long.valueOf(body.get("idCorreo").toString()) > 3 ){
            response.put("Status", "Error");
            response.put("Mensaje", "Datos erroneos, el idCorreo no corresponde al endpoint");
            return response;
        }
        if (matcher.find() == true && matcherRem.find() == true && !template.equals("st")
                && !nombreDestinatario.equals("") && !nombreRemitente.equals("") && !asunto.equals("")) {
            try {

                correoService.servicioCorreo(nombreDestinatario, template, correoDestinatario, correoRemitente,
                        nombreRemitente, asunto);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            response.put("Status", "Ok");
            response.put("Mensaje", "Correo Enviado con exito");
        } else {

            response.put("Status", "Error");
            response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
        }

        return response;
    }

    @PostMapping("/compensar/correo")
    public Map<String, String> correoCompensar(@RequestBody String body) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        Gson json = new Gson();
        JsonReader reader = new JsonReader(new StringReader(body));
        reader.setLenient(true);
        HashMap<String,Object> datosCorreo = json.fromJson(reader, HashMap.class);
        Plantillas opcion = repositorio.findById(Long.valueOf(datosCorreo.get("idCorreo").toString()));
        String template = opcion.getNombreTemplate();
        
        if(Long.valueOf(datosCorreo.get("idCorreo").toString()) < 4 || (Long.valueOf(datosCorreo.get("idCorreo").toString()) > 7 && Long.valueOf(datosCorreo.get("idCorreo").toString())!=10 && Long.valueOf(datosCorreo.get("idCorreo").toString())!=12)){
            response.put("Status", "Error");
            response.put("Mensaje", "Datos erroneos, el idCorreo no corresponde al endpoint");
            return response;
        }

        if(Long.valueOf(datosCorreo.get("idCorreo").toString()) == 4 ){
            try {
                
                correoService.correoCompensar(body, template);
                response.put("Status", "Ok");
                response.put("Mensaje", "Correo Enviado con exito");
            } catch (Exception e) {
                System.out.println(e);
                response.put("Status", "Error");
                response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
            }
        }else if(Long.valueOf(datosCorreo.get("idCorreo").toString()) == 5 ){
            try {
                correoService.wkCompensar(body, template);
                response.put("Status", "Ok");
                response.put("Mensaje", "Correo Enviado con exito");
            } catch (MessagingException e) {
                response.put("Status", "Error");
                response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
            }
        }else if(Long.valueOf(datosCorreo.get("idCorreo").toString()) == 6 ){
            try {
                correoService.pqrCompensar(body, template);
                response.put("Status", "Ok");
                response.put("Mensaje", "Correo Enviado con exito");
            } catch (MessagingException e) {
                response.put("Status", "Error");
                response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
            }
        }else if(Long.valueOf(datosCorreo.get("idCorreo").toString()) == 7 ){
            try {
               correoService.RecurrenciaCompensar(body, template);
                response.put("Status", "Ok");
                response.put("Mensaje", "Correo Enviado con exito");
            } catch (MessagingException e) {
                response.put("Status", "Error");
                response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
            }
        }else if(Long.valueOf(datosCorreo.get("idCorreo").toString()) == 10 ){
            try {
                correoService.wkCompensar(body, template);
                response.put("Status", "Ok");
                response.put("Mensaje", "Correo Enviado con exito");
            } catch (MessagingException e) {
                response.put("Status", "Error");
                response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
            }
        }else if(Long.valueOf(datosCorreo.get("idCorreo").toString()) == 12 ){
            try {
                correoService.wkCompensarFamilias(body, template);
                response.put("Status", "Ok");
                response.put("Mensaje", "Correo Enviado con exito");
            } catch (MessagingException e) {
                response.put("Status", "Error");
                response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
            }
        }
       
        
        return response;

    }

    @PostMapping("/mindefensa/correo")
    public Map<String, String> correoMindefensa(@RequestBody String body) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        Gson json = new Gson();
        JsonReader reader = new JsonReader(new StringReader(body));
        reader.setLenient(true);
        HashMap<String,Object> datosCorreo = json.fromJson(reader, HashMap.class);
        Plantillas opcion = repositorio.findById(Long.valueOf(datosCorreo.get("idCorreo").toString()));
        String template = opcion.getNombreTemplate();
        
        if(Long.valueOf(datosCorreo.get("idCorreo").toString()) < 8 || Long.valueOf(datosCorreo.get("idCorreo").toString()) > 9 ){
            response.put("Status", "Error");
            response.put("Mensaje", "Datos erroneos, el idCorreo no corresponde al endpoint");
            return response;
        }

        if(Long.valueOf(datosCorreo.get("idCorreo").toString()) == 8 ){
            try {
                
                correoService.correoMindef(body, template);
                response.put("Status", "Ok");
                response.put("Mensaje", "Correo Enviado con exito");
            } catch (Exception e) {
                System.out.println(e);
                response.put("Status", "Error");
                response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
            }
        }else if(Long.valueOf(datosCorreo.get("idCorreo").toString()) == 9 ){
            try {
                correoService.wkMindef(body, template);
                response.put("Status", "Ok");
                response.put("Mensaje", "Correo Enviado con exito");
            } catch (MessagingException e) {
                response.put("Status", "Error");
                response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
            }
        }
       
        return response;
    }

    @PostMapping("/correo/atlas")
    public Map<String, String> correoAtlas(@RequestBody String body) throws Exception {
        HashMap<String, String> response = new HashMap<>();
        Gson json = new Gson();
        JsonReader reader = new JsonReader(new StringReader(body));
        reader.setLenient(true);
        HashMap<String,Object> datosCorreo = json.fromJson(reader, HashMap.class);
        Plantillas opcion = repositorio.findById(Long.valueOf(datosCorreo.get("idCorreo").toString()));
        String template = opcion.getNombreTemplate();
        
        if(Long.valueOf(datosCorreo.get("idCorreo").toString()) != 11){
            response.put("Status", "Error");
            response.put("Mensaje", "Datos erroneos, el idCorreo no corresponde al endpoint");
            return response;
        }

        
        try {
            
            correoService.informacionAtlas(body, template);
            response.put("Status", "Ok");
            response.put("Mensaje", "Correo Enviado con exito");
        } catch (Exception e) {
            System.out.println(e);
            response.put("Status", "Error");
            response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
        }
        
       
        return response;
    }

    @PostMapping("/correo/pwa")
    public Map<String, String> correoPWA(@RequestBody PwaContent content) throws Exception {
       
        HashMap<String,String> response = new HashMap<>();

        Plantillas opcion = repositorio.findById(Long.valueOf(content.getIdCorreo()));

        String template = opcion.getNombreTemplate();
        
        if(content.getIdCorreo() != 13){
            response.put("Status", "Error");
            response.put("Mensaje", "Datos erroneos, el idCorreo no corresponde al endpoint");
            return response;
        }

        
        try {
            
            correoService.informacionPWA(content, template);
            response.put("Status", "Ok");
            response.put("Mensaje", "Correo Enviado con exito");
        } catch (Exception e) {
            System.out.println(e);
            response.put("Status", "Error");
            response.put("Mensaje", "Datos erroneos, verifica tus datos. No se envio el correo");
        }
        
       
        return response;
    }


    @GetMapping("/listaTemplates")
    public ModelAndView listaTemplates(Plantillas template) {
        ModelAndView response = new ModelAndView("listaTemplates.html");
        response.addObject("plantilla",new Plantillas());
        response.addObject("plantillas",repositorio.findAll());
        return response;
    }

    
    



}
