<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notificacion</title>
    <style>
        *{
            margin: 0;
            padding 0;
        }
        .container{
            width: 100vw;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: left;
            color :black;
            background-color: whitesmoke;
        }
        hr {
            border:1px solid rgb(43, 128, 226)  ;
        }
        .container > *{
            padding-left: 2vw;
        }
        footer{
            display: flex;
            justify-content: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <br>
        <h1>Servicio de asistencia vial Atlas Assist</h1>
        <br>
        <hr>
        <br>
        <h3>NOMBRE DE LA CUENTA: ${nombreVar}</h3>
        <br>
        <h3>NUMERO DE EXPEDIENTE: ${expedienteVar}</h3>
        <br>
        <h3>USUARIO: ${usuarioVar}</h3>
        <br>
        <h3>FECHA DE ASIGNACION Y HORA: ${fechaVar}</h3>
        <br>
        <h3>SERVICIO: ${servicioVar}</h3>
        <br>
        <h3>SUBSERVICIO: ${subservicioVar}</h3>
        <br>
        <h3>POLIZA: ${polizaVar}</h3>
        <br>
        <h3>MARCA DE AUTO: ${autoVar}</h3>
        <br>
        <h3>TIPO DE AUTO : ${tipoautoVar}</h3>
        <br>
        <h3>MODELO DE AUTO : ${modeloautoVar}</h3>
        <br>
        <h3>PLACAS: ${placasVar}</h3>
        <br>
        <h3>ENTIDAD-MUNICIPIO ORIGEN: ${origenVar}</h3>
        <br>
        <h3>ENTIDAD-MUNICIPIO DESTINO: ${destinoVar}</h3>
        <br>
        <br>
        <footer>
            <h3>** CORREO GENERADO AUTOMATICAMENTE, NO RESPONDER **</h3>
        </footer>
        
    </div>
</body>
</html>