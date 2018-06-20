<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OWM - Report</title>
</head>
<body>
  <h1>OWM - Report</h1>
  <hr>

  <h2>Weather Report</h2>
  <div class="weather">
    <div> Date: ${date}</div>
    <div> ${city}</div>
    <div> Description: ${description}</div>
    <div> ${prettyPrint}</div>
    <div> Sunrise: ${weather.systemParameters.sunrise} </div>
    <div> Subset: ${weather.systemParameters.sunset} </div>
  </div>

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