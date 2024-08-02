<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flight Management System - Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('/images/airportbackground.jpg');
            height: 100vh;
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center center;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #4CAF50;
            padding: 10px 0;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
            position: relative;
        }
        nav ul li {
            display: inline-block;
            margin: 0 10px;
            position: relative;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
            padding: 10px;
            display: block;
        }
        nav ul li a:hover {
            background-color: #45a049;
        }
        nav ul li:hover .dropdown {
            display: block;
        }
        .dropdown {
            display: none;
            position: absolute;
            background-color: #4CAF50;
            min-width: 160px;
            z-index: 1;
            left: 0;
            top: 40px;
            border-radius: 5px;
        }
        .dropdown a {
            color: white;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
            background-color: #4CAF50;
            border-bottom: 1px solid #ddd;
        }
        .dropdown a:hover {
            background-color: #45a049;
        }
        .dropdown a:last-child {
            border-bottom: none;
        }
        .container {
            
            text-align: center;
        }
        h1 {
        	text-align: center;
            color: #333;
            font-size: 3em;
            margin-bottom: 20px;
            text-shadow: 2px 2px 5px #aaa;
        }
        .motivational {
            color: #555;
            font-size: 1.5em;
            margin: 20px 0;
        }
        footer {
            text-align: center;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
<h1>Customer DashBoard</h1>
    <header>
        <nav>
            <ul>
                
                <li>
                    <a href="#">Airport</a>
                    <div class="dropdown">
                        
                        <a href="airportview">Find Airport</a>
                    </div>
                </li>
                
                <li>
                    <a href="#">Flight Booking</a>
                    <div class="dropdown">
                        <a href="${pageContext.request.contextPath}/searchFlight">Search Flights</a>
                    </div>
                </li>
                
                 <li>
                    <a href="#">Passenger</a>
                    <div class="dropdown">
                        <a href="${pageContext.request.contextPath}/passengerDetailsC">Passenger Details</a>
                    </div>
                </li>
               
                <li>
                    <a href="#">Ticket</a>
                    <div class="dropdown">
                        <a href="${pageContext.request.contextPath}/ticketsBooked">Tickets Booked</a>
                    </div>
                </li>
                
                <li><a href="<c:url value='/logout' />">LogOut</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h1>Welcome to Flight Management System</h1>
    </div>

    <footer>
        Flight Management System @2024 Infosys Springboard
    </footer>
</body>
</html>
