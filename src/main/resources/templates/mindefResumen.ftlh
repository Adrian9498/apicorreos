<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0;">
    <meta name="format-detection" content="telephone=no" />
    <style type="text/css">
        #texto-detalle {
            margin-left: 10px;
            color: #4563ad;
            text-align: center;
            line-height: 2rem;
        }

        #tabla-detalle {
            width: 100%;
            min-width: 500px;
            display: inline-table;
        }

        #tabla-detalle td,
        th {
            padding: 10px;
        }

        #tabla-detalle th {
            background: #4563ad;
            text-align: center;
            color: white;
        }

        #tabla-detalle td {
            color: #4563ad;
            border: 1px solid #4563ad;
        }

        .td1 {
            width: 40%;
            background: #e5e9f3;
        }

        #tabla-footer {
            background: #4563ad;
            color: white;
        }

        #descarga {
            width: 100%;
            text-align: right;
            margin-top: 10px;
            color: #4563ad;
        }

        #tabla-footer th {
            text-align: end;
        }

        #modal-tabla {
            max-width: 650px !important;
        }

        #a-descarga {
            color: #4563ad !important;
        }
    </style>
    <title>Informacion de Contacto</title>
</head>

<body topmargin="0" rightmargin="0" bottommargin="0" leftmargin="0" marginwidth="0" marginheight="0" width="100%"
    style="border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; width: 100%; height: 100%; -webkit-font-smoothing: antialiased; text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; line-height: 100%;background-color: #F0F0F0;color: #000000;"
    bgcolor="#F0F0F0" text="#000000">
    <div class="modal fade" id="detalle" data-backdrop="static" data-keyboard="false" tabindex="-1"
        aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" id="modal-tabla">
            <div class="modal-content">
                <div class="modal-header"></div>
                <div class="modal-body"> 
                     <p id="texto-detalle"> <b>¡Gracias por tu compra!<br>Tu transacción ha sido aprobada y registrada
                            con el número  ${numeroTransaccion} <br>A continuacion encontrarás el detalle del
                            producto adquirido.</b></p> 
                     <table id="tabla-detalle" class="table-responsive"> 
                         <tr> 
                             <th colspan="4">Resumen de compra</th> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Nombre del Titular</td> 
                             <td colspan="2">  ${nombreTitular} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Nombre del Tomador</td> 
                             <td colspan="2">  ${nombreTomador} </td> 
                             </tr> 
                         <tr> 
                              <td class="td1" colspan="2">Número ID Registro Pago </td> 
                             <td colspan="2">  ${idPago} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Tipo y número de documento</td> 
                             <td colspan="2">  ${cedula} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Correo electrónico</td> 
                             <td colspan="2">  ${correoTomador} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Dirección</td> 
                             <td colspan="2">  ${direccion} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Teléfono Tomador</td> 
                             <td colspan="2">  ${telefonoTomador} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Total planes adquiridos</td> 
                             <td colspan="2">1</td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Fecha y hora transacción</td> 
                             <td colspan="2">  ${fechaTransaccion} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Método de pago utilizado</td> 
                             <td colspan="2"> ${detalleCodigoPago} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Nombre del plan</td> 
                             <td colspan="2">  ${plan} </td> 
                             </tr> 
                         <tr> 
                             <td class="td1" colspan="2">Número de autorización</td> 
                             <td colspan="2">  ${numeroAutorizacion} </td> 
                             </tr>
                        <tr id="tabla-footer">
                            <td colspan="2"></td>
                            <th>Pago Total</th>
                            <th>  ${total} </th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>