<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 5-4-2018
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="script/jquery.js"></script>
    <script src="script/rest.js"></script>
  </head>
  <body>

  <select id="table1">
    <option value="null">Select table</option>
  </select>
  <select id="column1">
    <option value="null">Select column</option>
  </select>
  
    <script>
      var input = JSON.parse("{}");
      input["database_id"] = 1;
      var data = postCall(input, "http://localhost:8080/rest/target/tables", "json");
      $.each(data.tables, function () {
          $("#table1").append("<option value='" + this +"'>" + this +"</option>")
      });

      $("#table1").change(function () {
          var input1 = JSON.parse("{}");
          input1["table"] = $(this).val();
          var columns = postCall(input1, "http://localhost:8080/rest/target/columns", "json");
          $("#column1").empty();
          $("#column1").append("<option value='" + null +"'>" + 'select column' +"</option>");
          $.each(columns.columns, function () {
              $("#column1").append("<option value='" + this +"'>" + this +"</option>")
          })
      });


      function enable(){
          var object = JSON.parse("{}");
          object["id"] = temp;
          object["name"] = temp;
          postCall(object, "http://localhost:8080/rest/businessRule/activate", "json")
      }

      function disable(){
          var object = JSON.parse("{}");
          object["id"] = temp;
          object["name"] = temp;
          postCall(object, "http://localhost:8080/rest/businessRule/deactivate", "json")
      }
    </script>
  </body>
</html>
