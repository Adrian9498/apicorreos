<html lang="es">

<head>
    <title>Compensar</title>
    <!--Inicio de styles-->
    <style type="text/css">
        .naranja {
            color: #E54F16;
            font-size: 18px;
            font-family: Arial, Helvetica, sans-serif;
        }
        .tutulo2{
            font-size: 24px;
            font-family: Arial, Helvetica, sans-serif;
            color: rgb(95, 93, 93);
        }
        .text{
            font-family: Arial, Helvetica, sans-serif;
            color:rgb(75, 78, 78)
        }        
        .detalle{
            border: 1px solid #E54F16;
            border-collapse: collapse;
        }
        body {
            margin-top: 0px;
            text-align: center;
            margin-left: 0px;
            margin-right: 0px;
        }
    </style>
    <!--FIN de styles-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
    <!--in,agen de arriba-->
    <table align="center" border="0" style="border: #E54F16;" cellpadding="0" cellspacing="0" width="650">
        <tbody>
            <tr>
                <td  colspan="3">                    
                    <p><img src="${base}HeaderCompensar.png"  width="650" height="auto" alt="" /></p>                                     
                </td>
            </tr>              
        </tbody>
    </table>
    <br>
    <table class="detalle" align="center" border="1" cellpadding="8" cellspacing="22" width="500" >
        <tbody class="text">
            <tr>
                <td  colspan="2" align="center" class="naranja">Se notifica datos de contacto registrado en la Landing Page de Compensar</td>                
            </tr>
            <tr>
                <td  style="width:150px;" >Nombres:</td>
                <td>${nombre}</td>
            </tr>
            <tr>
                <td >celular:</td>
                <td>${celular}</td>
            </tr>
            <tr>
                <td  >tipo de documento:</td>
                <td>${tipoDocumento}</td>
            </tr>
            <tr>
                <td ># Documento:</td>
                <td>${documento}</td>
            </tr>
            <tr>
                <td >Correo electrónico:</td>
                <td>${correo}</td>
            </tr>
            <tr>
                <td >Tipo de solicitud:</td>
                <td>${tipoSolicitud}</td>
            </tr>
            <tr >
                <td >Comentario:</td>
                <td>${comentario}</td>
            </tr> 
        </tbody>
    </table>    
   
</body>
</html>