package com.ganesh.flightManagementSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.ganesh.flightManagementSystem.bean.Airport;
import com.ganesh.flightManagementSystem.exception.AirportNotFoundException;
import com.ganesh.flightManagementSystem.service.AirportService;
@Controller
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airportlist")
    public String showAllAirports(Model model) {
        List<Airport> airports = airportService.showAllAirports();
        airports.forEach(airport -> System.out.println(airport.getAirportCode() + " " + airport.getAirportLocation()));
        model.addAttribute("airportlist", airports);
        return "airportlist";
    }
    @GetMapping("/airportview")
    public String showIndexPage() {
        return "airportview";
    }


    @GetMapping("/addAirport")
    public String showAddAirportForm(Model model) {
        model.addAttribute("airport", new Airport());
        return "addAirport";
    }

    @PostMapping("/addAirport")
    public String addAirport(@ModelAttribute("airport") Airport airport, Model model) {
        Airport existingAirport = airportService.showAirport(airport.getAirportCode());
        if (existingAirport != null) {
            model.addAttribute("errorMessage", "Airport Code already exists.");
            return "addAirport";
        }
        airportService.addAirport(airport);
        model.addAttribute("success", true); 
        return "addAirport";
    }

    @GetMapping("/airport/{code}")
    public String showAirport(@PathVariable("code") String code, Model model) {
        Airport airport = airportService.showAirport(code);
        if (airport == null) {
            model.addAttribute("errorMessage", "Airport not Exists.");
            return "error";
        }
        model.addAttribute("airportview", airport);
        return "airportview";
    }

    @GetMapping("/searchAirport")
    public String searchAirport(@RequestParam("code") String code, Model model) {
        Airport airport = airportService.showAirport(code);
        if (airport == null) {
            model.addAttribute("errorMessage", "Airport not found.");
            return "airportview";
        }
        model.addAttribute("airportview", airport);
        return "airportview";
    }
}