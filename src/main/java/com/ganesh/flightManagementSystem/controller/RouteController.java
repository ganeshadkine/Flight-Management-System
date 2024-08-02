package com.ganesh.flightManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ganesh.flightManagementSystem.bean.Airport;
import com.ganesh.flightManagementSystem.bean.Flight;
import com.ganesh.flightManagementSystem.bean.Route;
import com.ganesh.flightManagementSystem.exception.AirportNotFoundException;
import com.ganesh.flightManagementSystem.exception.RouteAlreadyExistsException;
import com.ganesh.flightManagementSystem.service.FlightService;
import com.ganesh.flightManagementSystem.service.RouteService;

import java.util.List;


@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/addRoute")
    public String showAddRouteForm() {
        return "addRoute";
    }
    
    @GetMapping("/viewRoute")
    public String viewRoutes(Model model) {
        Iterable<Route> routes = routeService.getAllRoutes();
        model.addAttribute("routes", routes);
        return "viewRoute";
    }

    @PostMapping("/addRoute")
    public String addRoute(@RequestParam("sourceAirport") String sourceAirport,
                           @RequestParam("destinationAirport") String destinationAirport,
                           @RequestParam("fare") double fare,
                           Model model) {
        try {
            routeService.addRoute(sourceAirport, destinationAirport, fare);
            model.addAttribute("successMessage", "Route added successfully!");
        } catch (RouteAlreadyExistsException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (AirportNotFoundException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Route Already Exists!");
        }
        return "addRoute";
    }
    
    @GetMapping("/modifyRouteF")
    public ModelAndView showModifyRouteForm(@RequestParam("routeId") Long routeId) {
        Route route = routeService.getRouteById(routeId);
        ModelAndView modelAndView = new ModelAndView("modifyRoute");
        modelAndView.addObject("route", route);
        return modelAndView;
    }
    
    @PostMapping("/updateRoute")
    public String updateRoute(@RequestParam("routeId") Long routeId,
                              @RequestParam("sourceAirport") String sourceAirport,
                              @RequestParam("destinationAirport") String destinationAirport,
                              @RequestParam("fare") Double fare,
                              Model model) {
        Route route = routeService.getRouteById(routeId);
        route.setSourceAirport(sourceAirport);
        route.setDestinationAirport(destinationAirport);
        route.setFare(fare);
        routeService.updateRoute(route);

        return "redirect:/viewRoute";
    }
    
    @PostMapping("/deleteRoute")
    public ModelAndView deleteRoute(@RequestParam("routeId") Long routeId) {
        boolean isDeleted = routeService.deleteRoute(routeId);
        ModelAndView modelAndView = new ModelAndView("deleteRoute");
        if (isDeleted) {
            modelAndView.addObject("message", "Route deleted successfully.");
        } else {
            modelAndView.addObject("message", "Route cancellation failed.");
        }
        return modelAndView;
    }
    
}