package es.etg.prog.correos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static es.etg.prog.correos.model.Envio.*;

public class EnvioTest {
    
    private static Envio envio;
    public static double DELTA = 0.01;

    @BeforeAll
    public static void inicializar(){
        String destinatario = "Destinatario";
        String direccion = "Direccion";
        int peso = 0;
        envio = new Envio(destinatario, direccion, peso);
    }

    @Test
    public void calcularPrecioMenos5Kg(){
        envio.setPeso(PESO_BAJO-1);

        double esperado = PRECIO_BAJO;
        double real = envio.calcularPrecio();

        assertEquals(esperado, real, DELTA);

    }

    @Test
    public void calcularPrecioMenos10Kg(){
        envio.setPeso(PESO_MEDIO-1);

        double esperado = PRECIO_MEDIO;
        double real = envio.calcularPrecio();

        assertEquals(esperado, real, DELTA);

    }

    @Test
    public void calcularPrecio22Kg(){
        envio.setPeso(22);

        double esperado = PRECIO_MEDIO+ PRECIO_KG_ADICIONAL*12;
        double real = envio.calcularPrecio();

        assertEquals(esperado, real, DELTA);

    }





}
