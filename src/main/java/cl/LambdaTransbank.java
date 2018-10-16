package cl;

import cl.pojos.Request;
import cl.pojos.ResponseBase;
import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.WebpayOneClick;
import cl.transbank.webpay.configuration.Configuration;
import com.amazonaws.services.lambda.runtime.Context;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.transbank.webpayserver.webservices.OneClickInscriptionOutput;

public class LambdaTransbank implements RequestHandler<Request, ResponseBase> {


    public ResponseBase handleRequest(Request request, Context context) {

        LambdaLogger logger = context.getLogger();

        ResponseBase response = new ResponseBase();
        logger.log("Request: {} "+ request);
        try {

            //CARGAR CONFIGURACION POR DEFECTO
            Configuration configuration = Configuration.forTestingWebpayOneClickNormal();

            /* PARA CARGAR TU CODIGO COMERCIO Y CERTIFICADOS

            Configuration configuration = new Configuration();

            configuration.setCommerceCode("0000000");   //CODIGO COMERCIOs

            configuration.setEnvironment(Webpay.Environment.INTEGRACION);
            configuration.setPublicCert( // pega acá tu certificado público
                                    "-----BEGIN CERTIFICATE-----\n" +
                                    "-----END CERTIFICATE-----");

            configuration.setPrivateKey( // pega acá la llave privada de tu certificado
                            "-----BEGIN RSA PRIVATE KEY-----\n" +
                            "-----END RSA PRIVATE KEY-----");

            */
            logger.log("Codigo Comercio: {} "+ configuration.getCommerceCode());
            logger.log("Private key: {} "+ configuration.getPrivateKey());
            logger.log("Certificate: {} "+ configuration.getPublicCert());


            WebpayOneClick transaction =
                    new Webpay(configuration).getOneClickTransaction();

            OneClickInscriptionOutput initResult =
                    transaction.initInscription(request.getUsername(), request.getEmail(), request.getUrlCallback());
            String formAction = initResult.getUrlWebpay();
            String tbkToken = initResult.getToken();
            response.setToken(tbkToken);
            response.setUrlToken(formAction);
            logger.log("formAction: {}" +formAction);
            logger.log("token: {}" + tbkToken);
        } catch (Exception e) {
            e.printStackTrace();
            logger.log("Error al llamar Iniciar transaccion: {}"+e.getMessage());
        }


        response.setCode("200");

        return response;

    }
}