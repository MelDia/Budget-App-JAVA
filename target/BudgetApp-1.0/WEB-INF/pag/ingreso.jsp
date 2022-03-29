<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR"/>
<!DOCTYPE html>
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
        <script src="https://kit.fontawesome.com/9bc29573df.js" crossorigin="anonymous"></script><!-- comment -->


        <style>
            body {
                color: #555;
                font-family: Open Sans;
                font-size: 16px;
                position: relative;
                height: 100vh;
                font-weight: 400;
                font-family: 'Questrial', sans-serif;
            }

            .contenedor {
                width: 860px;
                margin: 60px auto;
            }

            .ingreso {
                float: left;
                width: 840px;

            }

            h2 {
                text-transform: uppercase;
                font-size: 18px;
                font-weight: 400;
                margin-bottom: 15px;
            }

            .titulo_ingreso {
                color: #85acf9;
                font-weight: bold;
            }

            .agregar {
                padding: 14px;
                border-bottom: 1px solid #e7e7e7;
                background-color: #f7f7f7;
            }

            .agregar_contenedor {
                margin: 0 auto;
                text-align: center;
            }

            .agregar_descripcion,
            .agregar_valor {
                border: 1px solid #e7e7e7;
                background-color: #fff;
                color: inherit;
                font-family: inherit;
                font-size: 14px;
                padding: 12px 15px;
                margin-right: 10px;
                border-radius: 5px;
                transition: border 0.3s;
            }

            .agregar_descripcion {
                width: 400px;
            }
            .agregar_valor {
                width: 100px;
            }

            .agregar_btn {
                font-size: 35px;
                background: none;
                border: none;
                color: #85acf9;
                cursor: pointer;
                display: inline-block;
                vertical-align: middle;
                line-height: 1.1;
                margin-left: 10px;
            }

            .agregar_btn:active {
                transform: translateY(2px);
            }

            .agregar_descripcion:focus,
            .agregar_valor:focus {
                outline: none;
                border: 1px solid #85acf9;
            }

            .agregar_btn:focus {
                outline: none;
            }
        </style>
    </head>
    <body>

        <div class="contenedor">
            <!-- INGRESO -->
            <div class="ingreso">
                <h2 class='titulo_ingreso'>Income</h2>
                <!-- AGREGAR INGRESO -->
                <form action="${pageContext.request.contextPath}/IngresoControl?action=agregarIng" method="POST">
                    <div class="agregar">
                        <div class="agregar_contenedor">
                            <input type="text" name="descripcion" class="agregar_descripcion" placeholder="Add description" />
                            <input type="number" name="valor" class="agregar_valor" placeholder="Value" />
                            <button type="submit" class="agregar_btn"> <ion-icon name="add-circle-outline" style="color: #85acf9;"></ion-icon> </button>
                        </div>
                    </div>
                </form>
                <!-- LISTAR -->
                <section >
                    <div class="container ">
                        <table class="table" style="color: #555;">
                            <tbody>
                                <c:forEach var="ingreso" items="${ingresos}" varStatus="status">
                                    <tr>
                                        <td>${ingreso.descripcion} </td>                                    
                                        <td> <fmt:formatNumber value="${ingreso.valor}" type="currency"/></td> 
                                        <td>
                                            <a href="${pageContext.request.contextPath}/IngresoControl?action=deleteIng&id_ingresos=${ingreso.id_ingresos}"
                                               class='agregar_btn'>
                                                <ion-icon name="trash-outline" style="font-size: 22px; color: #85acf9;" ></ion-icon>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </section>
            </div>
        </div>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>
</html>
