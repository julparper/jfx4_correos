package es.etg.prog.correos.model;

public class Envio {
    
    public static final double PESO_BAJO = 5.0;
    public static final double PESO_MEDIO = 10.0;

    public static final double PRECIO_BAJO = 23.10;
    public static final double PRECIO_MEDIO = 27.50;
    public static final double PRECIO_KG_ADICIONAL = 1.29;

    private String destinatario;
    private String direccion;
    private double peso;

    public Envio(String destinatario, String direccion, double peso) {
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.peso = peso;
    }

    public double calcularPrecio(){
        double precio = 0;
        if(peso < PESO_BAJO){
            precio = PRECIO_BAJO;
        }else if(peso< PESO_MEDIO){
            precio = PRECIO_MEDIO;
        }else{
            int kilos = 0;
            precio = PRECIO_MEDIO;
            double kilosAdicionales =  peso - PESO_MEDIO;

            kilos = (int) kilosAdicionales;
            if((kilosAdicionales - kilos) > 0.01){
                kilos++;
            }

            precio = PRECIO_MEDIO + kilos * PRECIO_KG_ADICIONAL;
        }
        return precio;

    }
    public String facturar(){
        final String MSG = "El coste del envío realizado por %s con dirección %s es de : %s";
        double precio = calcularPrecio();

        return String.format(MSG, destinatario, direccion, precio);
    }
    
    public String getDestinatario() {
        return destinatario;
    }


    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public double getPeso() {
        return peso;
    }


    public void setPeso(double peso) {
        this.peso = peso;
    }







}
