<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Budget App</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Questrial&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/9bc29573df.js" crossorigin="anonymous"></script>


        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            .limpiar::after {
                content: "";
                display: table;
                clear: both;
            }

            body {
                color: #555;
                font-size: 16px;
                position: relative;
                height: 100vh;
                font-weight: 400;
                font-family: 'Questrial', sans-serif;
            }

            .derecha {
                float: right;
            }

            .cabecero {
                height: 40vh;
                background-size: cover;
                background-position: center;
                position: relative;
                width: 100%;
                padding-top: 150px;
                padding-bottom: 100px;
                color: #fff;
                background-color: #ffdcc5;
            }

            .presupuesto {
                position: absolute;
                width: 350px;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                color: #fff;
                font-weight: bold;
            }

            .titulo_presupuesto {
                font-size: 20px;
                text-align: center;
                margin-bottom: 10px;
                font-weight: 300;
                font-weight: bold;
            }

            .valor_presupuesto {
                font-weight: 300;
                font-size: 46px;
                text-align: center;
                margin-bottom: 25px;
                letter-spacing: 2px;
            }

            .ingreso_presupuesto,
            .egreso_presupuesto {
                padding: 12px;
                text-transform: uppercase;
                border-radius: 20px;
            }

            .ingreso_presupuesto {
                margin-bottom: 10px;
                background-color: #85acf9;
            }

            .egreso_presupuesto {
                background-color: #fe8800;
            }

            .ingreso_presupuesto-titulo,
            .egreso_presupuesto-titulo {
                float: left;
                font-size: 13px;
                color: #fff;
                margin-top: 2px;
            }

            .ingreso_presupuesto-valor,
            .egreso_presupuesto-valor {
                letter-spacing: 1px;
                float: left;
            }


        </style>

    </head>

    <body>
        <div class="cabecero">
            <div class="presupuesto">
                <div class="titulo_presupuesto">
                    Budget available
                </div>
                <div class="valor_presupuesto">+ 2000,00</div>
                <div class="ingreso_presupuesto limpiar">
                    <div class="ingreso_presupuesto-titulo">Income</div>
                    <div class="derecha">
                        <div class="ingreso_presupuesto-valor">1500</div>
                    </div>
                </div>
                <div class="egreso_presupuesto limpiar">
                    <div class="egreso_presupuesto-titulo">Expenses</div>
                    <div class="derecha">
                        <div class="egreso_presupuesto-valor">200</div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="WEB-INF/pag/ingreso.jsp"></jsp:include>
        <jsp:include page="WEB-INF/pag/egreso.jsp"></jsp:include>
    </body>
</html>