package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.*;
import fr.almeri.beerboard.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

//indique à spring boot un routage
@Controller
public class BreweriesController {
    //route de GET
    @Autowired
    private BrasserieRepository brasserieRepository;
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("/breweries")
    public String getPageExemple(Model pModel)
    {
        ArrayList<Brasserie> listBrassFromDatabase = (ArrayList<Brasserie>) brasserieRepository.findAll();
        pModel.addAttribute("listbrass",listBrassFromDatabase);

        return "breweries";
    }

    @GetMapping("/see-brewery/{code}")
    public String getBrewery(Model pModel, @PathVariable(required = true) String code){
        Brasserie brasserie = brasserieRepository.findById(code).orElseThrow();
        Iterable<Region> regions = regionRepository.findAll();
        pModel.addAttribute("brasserie", brasserie);
        pModel.addAttribute("regions", regions);
        return "brewery";
    }
//    @GetMapping("/see-brewery1")
//    public String getBreweryByCode(Model pModel, @RequestParam String code){
//        return "brewery";
//    }



}
