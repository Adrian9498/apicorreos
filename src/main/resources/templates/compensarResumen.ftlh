<html lang="es">

<head>
    <title>Compensar</title>
    <!--Inicio de styles-->
    <style type="text/css">
        .naranja {
            color: #E54F16;
            font-size: 26px;
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
        .precios{
            color: #E54F16;
            font-size: 16px;
            font-family: Arial, Helvetica, sans-serif;

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
            <tr>
                <td  colspan="3" style="color: rgb(73, 75, 75); ">                   
                    <p align="center" class="naranja "><strong> ¡gracias por tu compra!</strong></p>   
                    <p align="center" >Tu transacción ha sido aprobada y registrada con el número</p>   
                    <p align="center" style="line-height:5px"> <strong>${numeroIDpago}</strong> </p>  
                    <p align="center" > A continuación encontrarás el detalle del producto adquirido</p>
                    <p style="line-height:1px">&nbsp;</p>                                 
                </td>
            </tr> 
            <tr>
                <td  colspan="3">   
                                   
                    <p align="center" class="tutulo2" height="100"><strong>Resumen de compra</strong></p>            

                </td>  
            </tr> 
        </tbody>
    </table>
    <br>
    <table class="detalle" align="center" border="1" cellpadding="8" cellspacing="10" width="500" >
        <tbody class="text" >
            <tr >
                <td style="width: 250px;">Nombre del titular</td>
                <td>${nombreTitular}</td>
            </tr>
            <tr>
                <td>ID registro de pago</td>
                <td>${numeroIDpago}</td>
            </tr>
            <tr>
                <td>Tipo y n&uacute;mero documento</td>
                <td>${tipoNumeroDocumento}</td>
            </tr>
            <tr>
                <td>Total planes adquiridos</td>
                <td>${totalPlanes}</td>
            </tr>
            <tr>
                <td>Fecha y hora de transacción</td>
                <td>${fechaHora}</td>
            </tr>
            <tr>
                <td>M&eacute;todo de pago utlizado</td>
                <td>${metodoPago}</td>
            </tr>
            <#list planes as plan>
                <tr>
                    <td>Nombre del plan</td>
                    <td>${plan}</td>
                </tr>
            </#list>
            <tr>
                <td>N&uacute;mero autorización</td>
                <td>${numeroAutorizacion}</td>
            </tr>
           
        </tbody>
    </table>
    <table  align="center"  cellpadding="4" cellspacing="0" width="500" >
        <tbody>
            <tr>
                <td align="right " >
                   <strong class="precios">Subtotal:${subtotal}</strong> 
                </td>
            </tr>
            <tr>
                <td align="right ">
                   <strong class="precios">IVA:${iva}</strong> 
                </td>
            </tr>
            <tr>
                <td align="right " >
                   <strong class="precios">Total: ${total} </strong> 
                </td>
            </tr>
        </tbody>
    </table>
    <table align="center" border="0" cellpadding="0" cellspacing="0" >
        <tbody>
            <tr>
                <td  colspan="3">                    
                    <p><img src="${base}FooterCompensar.png"  width="650" height="auto" alt="" /></p>                                     
                </td>
            </tr>    
        </tbody>
    </table>

</body>
</html>