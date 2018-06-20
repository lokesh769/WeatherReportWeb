<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>OWM - Report</title>
</head>
<body>
  <h1>OWM - Report</h1>
  <hr>

  <div class="form">
    <form action="currentWeather" method="post" onsubmit="return validate()">
      <table>
        <tr>
          <td>Select city name</td>
          <td><select id="city" name="city"> <option>London</option><option>Hong Kong</option> </select></td>
          <td><input type="submit" value="Submit"></td>
        </tr>
      </table>
    </form>
  </div>

</body>
</html>