package com.example.fact001;

public class ModeloCliente {

    String cliApellidos, cliCedula, cliCorreo, cliDireccion, cliImg, cliNombres, cliTelefono;

    public ModeloCliente() {
    }

    public ModeloCliente(String cliApellidos, String cliCedula, String cliCorreo, String cliDireccion, String cliImg, String cliNombres, String cliTelefono) {
        this.cliApellidos = cliApellidos;
        this.cliCedula = cliCedula;
        this.cliCorreo = cliCorreo;
        this.cliDireccion = cliDireccion;
        this.cliImg = cliImg;
        this.cliNombres = cliNombres;
        this.cliTelefono = cliTelefono;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public String getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliImg() {
        return cliImg;
    }

    public void setCliImg(String cliImg) {
        this.cliImg = cliImg;
    }

    public String getCliNombres() {
        return cliNombres;
    }

    public void setCliNombres(String cliNombres) {
        this.cliNombres = cliNombres;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

}
