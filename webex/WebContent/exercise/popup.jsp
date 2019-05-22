<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>popup.jsp</title>
    <script>
      function setCookie(name, value, expiredays) {
        var todayDate = new Date();
        today.setDate(today.getDate() + expiredays);

        document.cookie =
          name +
          "=" +
          escape(value) +
          "; path=/; expires=" +
          todayDate.setUTCString() +
          ";";
      }
    </script>
    <style>
      #container {
        margin-top: 100px;
      }
    </style>
  </head>
  <body>
    <h3>popup.jsp</h3>
    <div id="container">
      <input type="checkbox" name="yseNo" onclick="cls()"/> 오늘 하루 안 보기
      <input type="button" value="CLOSE" onclick="self.close();" />
    </div>
    <script>
      function cls() {
      }
    </script>
  </body>
</html>
