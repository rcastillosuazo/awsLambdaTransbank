# awsLambdaTransbank
AWS Lambda con integración a Transbank por SDK Java

Función Lambda llamada desde API Gateway

Una vez instalada la función lambda, crear API Gateway con llamada a función:

Json de llamada:

{
    "username": "rcastillo",
    "email":"rcastillo@email.com",
    "urlCallback":"www.google.com"
}
