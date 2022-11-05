package mx.ipn.cic.webserviceexample.annonymus;

import android.util.Log;

import mx.ipn.cic.webserviceexample.dto.ProductDTO;

public class UnaImplementacion implements UnaInterfaz {

    public void saludar() {
        Log.i("MPS", "Hola Mundo!");
    }

    @Override
    public double suma(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double resta(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double divide(double num1, double num2) {

        if (num2 == 0) {
            Log.e("MPS", "No se puede dividir entre 0");
            return -1;
        } else {

            return num1 / num2;
        }

    }

    @Override
    public double multiplica(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public void unMetodoRaroConsumeWS(ProductDTO producto) {
        //TODO Consumir un WSClient retrofit
    }

    @Override
    public void otroMetodoRaroConsumeBD(ProductDTO productDTO) {
        //TODO Consumir un WSClient RoomDAO
    }
}
