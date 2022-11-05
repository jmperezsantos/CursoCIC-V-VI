package mx.ipn.cic.webserviceexample.annonymus;

import mx.ipn.cic.webserviceexample.dto.ProductDTO;

//Protocolo
public interface UnaInterfaz {

    double suma(double num1, double num2);

    double resta(double num1, double num2);

    double divide(double num1, double num2);

    double multiplica(double num1, double num2);

    void unMetodoRaroConsumeWS(ProductDTO producto);

    void otroMetodoRaroConsumeBD(ProductDTO productDTO);

}
