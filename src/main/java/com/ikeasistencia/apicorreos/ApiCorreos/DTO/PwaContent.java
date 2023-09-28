package com.ikeasistencia.apicorreos.ApiCorreos.DTO;

public class PwaContent {

    private String empresaVar;
    private String nameVar;
    private String message;
    private String telephoneVar;
    private String emailVar;
    private String correoRemitente;
    private String nombreRemitente;
    private String asunto;
    private int idCorreo;
    private String[] destinatario;
    private String[] destinatarioCC;
    private String[] destinatarioCCO;
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getDestinatarioCCO() {
        return destinatarioCCO;
    }

    public void setDestinatarioCCO(String[] destinatarioCCO) {
        this.destinatarioCCO = destinatarioCCO;
    }

    public String getTelephoneVar() {
        return telephoneVar;
    }

    public void setTelephoneVar(String telephoneVar) {
        this.telephoneVar = telephoneVar;
    }

    public String getEmailVar() {
        return emailVar;
    }

    public void setEmailVar(String emailVar) {
        this.emailVar = emailVar;
    }

    public String getEmpresaVar() {
        return empresaVar;
    }
    
    public void setEmpresaVar(String empresaVar) {
        this.empresaVar = empresaVar;
    }

    public String getNameVar() {
        return nameVar;
    }

    public void setNameVar(String nameVar) {
        this.nameVar = nameVar;
    }

    public String getCorreoRemitente() {
        return correoRemitente;
    }

    public void setCorreoRemitente(String correoRemitente) {
        this.correoRemitente = correoRemitente;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public int getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(int idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String[] getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String[] destinatario) {
        this.destinatario = destinatario;
    }

    public String[] getDestinatarioCC() {
        return destinatarioCC;
    }

    public void setDestinatarioCC(String[] destinatarioCC) {
        this.destinatarioCC = destinatarioCC;
    }
}
