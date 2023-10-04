package com.ikeasistencia.apicorreos.ApiCorreos.servicios;


import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ikeasistencia.apicorreos.ApiCorreos.DTO.PwaContent;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

@Service
public class CorreoService {

    @Value("${base.url.imagenes}")
    private String baseUrlImg;

    final Configuration configuration;
    final JavaMailSender javaMailSender;
    


    

    //Constructor del Servicio
    public CorreoService (Configuration configuration, JavaMailSender javaMailSender) throws IOException{
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }
    

    //Metodo para la creacion de correos Banorte
    public void servicioCorreo(String nombreDestinatario,String template,String correoDestinatario,String correoRemitente,String nombreRemitente,String asunto) throws MessagingException{
        String destinatarioFinal = nombreRemitente + "<"+correoRemitente+">";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String contenido = contenidoCorreo(nombreDestinatario,template);
        helper.setSubject(asunto);
        helper.setTo(correoDestinatario);
        helper.setBcc(new String[]{"ccarrillo@ikeasistencia.com"});
        helper.setFrom(destinatarioFinal);
        helper.setText(contenido,true);
        javaMailSender.send(mimeMessage);

    }

    //Metodo para la creacion de correo de resumen Compensar
    public void correoCompensar(String body,String template) throws Exception{
        Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        JsonElement jsonCom = datosCorreo.get("datosCompensar");
        JsonObject datosCompensar = json.fromJson(jsonCom, JsonObject.class);
        String destinatarioFinal = datosCorreo.get("nombreRemitente").getAsString() + "<"+datosCorreo.get("correoRemitente").getAsString()+">" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        String contenido;
        try {

            contenido = contenidoCompensar(datosCompensar,template,body);
            helper.setSubject(datosCorreo.get("asunto").getAsString());
            helper.setTo(datosCorreo.get("correoDestinatario").getAsString());
            helper.setBcc(new String[]{"adgutierrez@ikeasistencia.com","ventasecommerce@komcareips.com.co"});
            helper.setFrom(destinatarioFinal);
            helper.setText(contenido,true);
            javaMailSender.send(mimeMessage);
            
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void informacionAtlas(String body,String template) throws Exception{
        Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        JsonElement jsonAtlas = datosCorreo.get("datosAtlas");
        JsonElement correos = datosCorreo.get("destinatarios");
        JsonElement copias = datosCorreo.get("destinatarioCC");
        JsonElement copiasOcultas = datosCorreo.get("destinatarioCCO");
    
        String[] correosJava = json.fromJson(correos, String[].class);
        String[] copiasJava = json.fromJson(copias, String[].class);
        String[] copiasOcultasJava = json.fromJson(copiasOcultas, String[].class);
        
        
        
        JsonObject datosAtlas = json.fromJson(jsonAtlas, JsonObject.class);
        String destinatarioFinal = datosCorreo.get("nombreRemitente").getAsString() + "<"+datosCorreo.get("correoRemitente").getAsString()+">" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        String contenido;
        try {

            contenido = contenidoAtlas(datosAtlas,template,body);
            helper.setSubject(datosCorreo.get("asunto").getAsString());
            helper.setTo(correosJava);
            helper.setCc(copiasJava);
            helper.setBcc(copiasOcultasJava);
            helper.setFrom(destinatarioFinal);
            helper.setText(contenido,true);
            javaMailSender.send(mimeMessage);
            
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void informacionPWA(PwaContent content,String template) throws Exception{

        String destinatarioFinal = content.getNombreRemitente() + "<"+content.getCorreoRemitente()+">" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        String contenido;
        try {

            contenido = contenidoPWA(content,template);
            helper.setSubject(content.getAsunto());
            helper.setTo(content.getDestinatario());
            helper.setCc(content.getDestinatarioCC());
            helper.setBcc(content.getDestinatarioCCO());
            helper.setFrom(destinatarioFinal);
            helper.setText(contenido,true);
            javaMailSender.send(mimeMessage);
            
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void informacionEncuestador(String url,String email,String template) throws Exception{

        String destinatarioFinal = "Encuestador IKE" + "<prueba@encuestador.com>" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        String contenido;
        try {

            contenido = contenidoEncuestador(url,template);
            helper.setSubject("Recuperacion de contraseña");
            helper.setTo(email);
            helper.setCc("ualonso@ikeasistencia.com");
            helper.setBcc("rrios@ikeasistencia.com");
            helper.setFrom(destinatarioFinal);
            helper.setText(contenido,true);
            javaMailSender.send(mimeMessage);
            
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void correoMindef(String body,String template) throws Exception{
        Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        JsonElement jsonMin = datosCorreo.get("datosMindef");
        JsonObject datosMindefensa = json.fromJson(jsonMin, JsonObject.class);
        String destinatarioFinal = datosCorreo.get("nombreRemitente").getAsString() + "<"+datosCorreo.get("correoRemitente").getAsString()+">" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        String contenido;
        try {

            contenido = contenidoMindefensa(datosMindefensa,template);
            helper.setSubject(datosCorreo.get("asunto").getAsString());
            helper.setTo(datosCorreo.get("correoDestinatario").getAsString());
            helper.setBcc(new String[]{"adgutierrez@ikeasistencia.com","ventasecommerce@komcareips.com.co"});
            helper.setFrom(destinatarioFinal);
            helper.setText(contenido,true);
            javaMailSender.send(mimeMessage);
            
        } catch (Exception e) {
            throw e;
        }
        
    }


    

     //correo recurrencia compensar
    public void RecurrenciaCompensar(String body,String template) throws Exception{
       Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        JsonElement jsonCom = datosCorreo.get("planes");
        JsonArray planes = json.fromJson(jsonCom, JsonArray.class);
        String destinatarioFinal = datosCorreo.get("nombreRemitente").getAsString() + "<"+datosCorreo.get("correoRemitente").getAsString()+">" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String contenido;
        try {
            contenido = contenidoWK(planes,template,body);
        } catch (Exception e) {
            throw e;
        }
        helper.setSubject(datosCorreo.get("asunto").getAsString());
        helper.setTo(datosCorreo.get("correoDestinatario").getAsString());
        helper.setBcc(new String[]{"adgutierrez@ikeasistencia.com","ventasecommerce@komcareips.com.co"});
        helper.setFrom(destinatarioFinal);
        helper.setText(contenido,true);
        javaMailSender.send(mimeMessage);
    }

    public void wkCompensar(String body,String template) throws Exception{
        Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        JsonElement jsonCom = datosCorreo.get("planes");
        JsonArray planes = json.fromJson(jsonCom, JsonArray.class);
        String destinatarioFinal = datosCorreo.get("nombreRemitente").getAsString() + "<"+datosCorreo.get("correoRemitente").getAsString()+">" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String contenido;
        try {
            contenido = contenidoWK(planes,template,body);
        } catch (Exception e) {
            throw e;
        }
        helper.setSubject(datosCorreo.get("asunto").getAsString());
        helper.setTo(datosCorreo.get("correoDestinatario").getAsString());
        helper.setBcc(new String[]{"adgutierrez@ikeasistencia.com","ventasecommerce@komcareips.com.co"});
        helper.setFrom(destinatarioFinal);
        helper.setText(contenido,true);
        javaMailSender.send(mimeMessage);

    }

      public void wkCompensarFamilias(String body,String template) throws Exception{
        Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        JsonElement jsonCom = datosCorreo.get("planes");
        JsonArray planes = json.fromJson(jsonCom, JsonArray.class);
        String destinatarioFinal = datosCorreo.get("nombreRemitente").getAsString() + "<"+datosCorreo.get("correoRemitente").getAsString()+">" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String contenido;
        try {
            contenido = contenidoWK(planes,template,body);
        } catch (Exception e) {
            throw e;
        }
        helper.setSubject(datosCorreo.get("asunto").getAsString());
        helper.setTo(datosCorreo.get("correoDestinatario").getAsString());
        helper.setBcc(new String[]{"adgutierrez@ikeasistencia.com","ventasecommerce@komcareips.com.co"});
        helper.setFrom(destinatarioFinal);
        helper.setText(contenido,true);
        javaMailSender.send(mimeMessage);

    }

    public void wkMindef(String body,String template) throws Exception{
        Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        String destinatarioFinal = datosCorreo.get("nombreRemitente").getAsString() + "<"+datosCorreo.get("correoRemitente").getAsString()+">" ;
        //MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String pdfName = datosCorreo.get("nombreArchivo").getAsString();
        String contenido;
        try {
            contenido = contenidoWKMD(datosCorreo,template);
        } catch (Exception e) {
            throw e;
        }
        javaMailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws MessagingException {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                helper.setSubject(datosCorreo.get("asunto").getAsString());
                helper.setTo(datosCorreo.get("correoDestinatario").getAsString());
                helper.setBcc(new String[]{"adgutierrez@ikeasistencia.com","ventasecommerce@komcareips.com.co"});
                helper.setFrom(destinatarioFinal);
                helper.setText(contenido,true);
                helper.addAttachment(pdfName, new ClassPathResource("files/"+pdfName));
            }});
    }
    
    public void pqrCompensar(String body,String template) throws Exception{
        Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        String destinatarioFinal = datosCorreo.get("nombreRemitente").getAsString() + "<"+datosCorreo.get("correoRemitente").getAsString()+">" ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String contenido;
        try {
            contenido = contenidoPqr(datosCorreo,template,body);
        } catch (Exception e) {
            throw e;
        }
        System.out.println(contenido);
        helper.setSubject(datosCorreo.get("asunto").getAsString());
        helper.setTo(datosCorreo.get("correoDestinatario").getAsString());
        helper.setBcc(new String[]{"adgutierrez@ikeasistencia.com","pqrbanco@ikeasistencia.com.co","ventasecommerce@komcareips.com.co"});
        helper.setFrom(destinatarioFinal);
        helper.setText(contenido,true);
        javaMailSender.send(mimeMessage);
    }
    //Metodo para la creacion del contenido html de correos Banorte
    public String contenidoCorreo(String name,String template){
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
        model.put("name",name);
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        
        return stringWriter.getBuffer().toString();
    }

    //Filtrado y obtencion de planes enviados en JSON compensar
    public ArrayList<String> filterPlanes(String body){
        ArrayList<String> result = new ArrayList<String>();
        Gson json = new Gson();
        JsonObject datosCorreo = json.fromJson(body, JsonObject.class);
        JsonElement jsonCom = datosCorreo.get("datosCompensar");
        JsonObject datosCompensar = json.fromJson(jsonCom, JsonObject.class);
        JsonElement planes = datosCompensar.get("planes");
        JsonArray planesArr = json.fromJson(planes , JsonArray.class);

        planesArr.forEach(entry->{
            HashMap<String,String> planEspecifico= json.fromJson(entry.toString(),HashMap.class);
            result.add(planEspecifico.get("plan"));
        });
        
        return result;
    }

    
    //Metodo para la creacion del contenido html de correos Compensar
    public String contenidoCompensar(JsonObject datosCompensar, String template,String body) throws Exception{
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
        ArrayList<String> planesArr = filterPlanes(body);
        model.put("nombreTitular",datosCompensar.get("nombreTitular").getAsString());
        model.put("nombreTomador", datosCompensar.get("nombreTomador").getAsString());
        model.put("numeroIDpago", datosCompensar.get("numeroIDpago").getAsString());
        model.put("tipoNumeroDocumento", datosCompensar.get("tipoNumeroDocumento").getAsString());
        model.put("correoElectronico", datosCompensar.get("correoElectronico").getAsString());
        model.put("direccion", datosCompensar.get("direccion").getAsString());
        model.put("telefonoTomador", datosCompensar.get("telefonoTomador").getAsString());
        model.put("totalPlanes", datosCompensar.get("totalPlanes").getAsString());
        model.put("fechaHora", datosCompensar.get("fechaHora").getAsString());
        model.put("metodoPago", datosCompensar.get("metodoPago").getAsString());
        model.put("numeroAutorizacion", datosCompensar.get("numeroAutorizacion").getAsString());
        model.put("planes", planesArr);
        model.put("subtotal",datosCompensar.get("subtotal").getAsString());
        model.put("iva",datosCompensar.get("iva").getAsString());
        model.put("total",datosCompensar.get("total").getAsString());
        model.put("base", this.baseUrlImg );
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }

    public String contenidoAtlas(JsonObject datos,String template,String body) throws Exception{
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
       
        model.put("nombreVar", datos.get("nombreCuenta").getAsString());
        model.put("expedienteVar", datos.get("expediente").getAsString());
        model.put("usuarioVar", datos.get("usuario").getAsString());
        model.put("fechaVar", datos.get("fechaHoraAsig").getAsString());
        model.put("servicioVar", datos.get("servicio").getAsString());
        model.put("subservicioVar", datos.get("subServicio").getAsString());
        model.put("polizaVar", datos.get("poliza").getAsString());
        model.put("autoVar", datos.get("marcaAuto").getAsString());
        model.put("tipoautoVar", datos.get("tipoAuto").getAsString());
        model.put("modeloautoVar", datos.get("modeloAuto").getAsString());
        model.put("placasVar",datos.get("placas").getAsString());
        model.put("origenVar",datos.get("munOrigen").getAsString());
        model.put("destinoVar",datos.get("munDestino").getAsString());
        ;
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }

    public String contenidoPWA(PwaContent datos,String template) throws Exception{
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
       
        model.put("nameVar", datos.getNameVar());
        model.put("empresaVar", datos.getEmpresaVar());
        model.put("message", datos.getMessage());
        model.put("telephoneVar", datos.getTelephoneVar());
        model.put("emailVar", datos.getEmailVar());
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }

    public String contenidoEncuestador(String url,String template) throws Exception{
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
       
        model.put("linkVar", url);
       
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }

    public String contenidoMindefensa(JsonObject datosMindefensa, String template) throws Exception{
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
        model.put("numeroTransaccion",datosMindefensa.get("numeroTransaccion").getAsString());
        model.put("nombreTitular",datosMindefensa.get("nombreTitular").getAsString());
        model.put("nombreTomador", datosMindefensa.get("nombreTomador").getAsString());
        model.put("idPago", datosMindefensa.get("idPago").getAsString());
        model.put("cedula", datosMindefensa.get("cedula").getAsString());
        model.put("correoTomador", datosMindefensa.get("correoTomador").getAsString());
        model.put("direccion", datosMindefensa.get("direccion").getAsString());
        model.put("telefonoTomador", datosMindefensa.get("telefonoTomador").getAsString());
        model.put("fechaTransaccion", datosMindefensa.get("fechaTransaccion").getAsString());
        model.put("detalleCodigoPago", datosMindefensa.get("detalleCodigoPago").getAsString());
        model.put("numeroAutorizacion", datosMindefensa.get("numeroAutorizacion").getAsString());
        model.put("plan", datosMindefensa.get("plan").getAsString());
        model.put("total",datosMindefensa.get("total").getAsString());
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }

    public String contenidoBeneficiario(JsonObject datos, String template) throws Exception{
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
        model.put("planVar",datos.get("planVar").getAsString());
        model.put("nombreVar",datos.get("nombreVar").getAsString());
        model.put("folioVar", datos.get("folioVar").getAsString());
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }

    public String contenidoWK(JsonArray planes,String template, String body)throws Exception{
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
        HashMap<String,String> planesUrl = new HashMap<>();
        planes.forEach(entry->{
            Gson json = new Gson();
            JsonObject aux = json.fromJson(entry, JsonObject.class);
            planesUrl.put(aux.get("plan").getAsString(), aux.get("url").getAsString());
        });
        
        model.put("planes", planesUrl);
        model.put("base", this.baseUrlImg );
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }

    public String contenidoPqr(JsonObject datosCompensar, String template,String body) throws Exception{
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();

        model.put("nombre",datosCompensar.get("nombreDestinatario").getAsString());
        model.put("celular", datosCompensar.get("celular").getAsString());
        model.put("tipoDocumento", datosCompensar.get("tipoDocumento").getAsString());
        model.put("documento", datosCompensar.get("documento").getAsString());
        model.put("correo", datosCompensar.get("correoDestinatario").getAsString());
        model.put("tipoSolicitud", datosCompensar.get("tipoSolicitud").getAsString());
        model.put("comentario", datosCompensar.get("comentario").getAsString());

        model.put("base", this.baseUrlImg );


        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }

    public String contenidoWKMD(JsonObject datosCorreo, String template){
        StringWriter stringWriter = new StringWriter();
        Map<String,Object> model = new HashMap<>();
        model.put("nombreArchivo",datosCorreo.get("nombreArchivo").getAsString());
        model.put("idVenta", datosCorreo.get("idVenta").getAsString());
        try {
            configuration.getTemplate(template).process(model,stringWriter);
        } catch (Exception e) {
            
        }
        return stringWriter.getBuffer().toString();
    }
}