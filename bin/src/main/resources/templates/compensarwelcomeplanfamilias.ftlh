<html lang="es">

<head>
    <title>Compensar</title>
    <!--Inicio de styles-->
    <style type="text/css">
        .naranja {
            color: #E54F16;
            font-size: 22px;
            font-family: Arial, Helvetica, sans-serif;
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
                    <p><img src="${base}HeaderWK.png" 
                     width="650" height="auto" alt="" /></p>                                     
                </td>
            </tr>              
        </tbody>
    </table>
    <br>
    <table  align="center" bellpadding="4" cellspacing="16" width="500" >
        <#list planes as key,value>
            <tr align="center" >
                <td class="naranja"> <strong>${key}</strong></td>
                <td><a href="${value}">*Ver Condiciones</a></td>
            </tr>
        </#list>         
           
        </tbody>
    </table>
  
    <table align="center" border="0" cellpadding="0" cellspacing="0" >
        <tbody>
            <tr>
                <td  colspan="3">                    
                     <p><img src="${base}FooterWKFamilias.png"   
                      width="650" height="auto" alt="" /></p>                                     
                </td>
            </tr>    
        </tbody>
    </table>

</body>
</html>