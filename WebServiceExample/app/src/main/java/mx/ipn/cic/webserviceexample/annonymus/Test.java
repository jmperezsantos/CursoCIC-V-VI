package mx.ipn.cic.webserviceexample.annonymus;

import mx.ipn.cic.webserviceexample.dto.ProductDTO;

public class Test {

    void foo() {


        //UnaInterfaz interfaz = new UnaInterfaz();

        UnaInterfaz implementacion = new UnaImplementacion();//<- Respuesta aqui

        //implementacion.saludar();

        implementacion.multiplica(10, 10);
        implementacion.otroMetodoRaroConsumeBD(
                new ProductDTO(
                        "asdas",
                        "",
                        "Un Producto",
                        10)
        );


    }

    void bar() {

        //object : Interfaz
        UnaInterfaz interfaz = new UnaInterfaz() {
            @Override
            public double suma(double num1, double num2) {
                return num1 + num2;
            }

            @Override
            public double resta(double num1, double num2) {
                return 0;
            }

            @Override
            public double divide(double num1, double num2) {
                return 0;
            }

            @Override
            public double multiplica(double num1, double num2) {
                return 0;
            }

            @Override
            public void unMetodoRaroConsumeWS(ProductDTO producto) {
                //TODO productWSClient.createProduct(product)
            }

            @Override
            public void otroMetodoRaroConsumeBD(ProductDTO productDTO) {

            }
        }; //Algo

        interfaz.suma(10, 10);
        interfaz.unMetodoRaroConsumeWS(
                new ProductDTO(
                        "asdas",
                        "",
                        "Un Producto",
                        10)
        );

    }

}
