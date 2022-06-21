package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.*;
import fr.almeri.beerboard.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

//indique à spring boot un routage
@Controller
public class beersController {
    //route de GET

    @Autowired
    private BiereRepository biereRepository;

    @GetMapping("/beers")
    public String getPageExemple(Model pModel)
    {
        ArrayList<Biere> listBeerFromDatabase = (ArrayList<Biere>) biereRepository.findAll();
        pModel.addAttribute("listbeer",listBeerFromDatabase);

        return "beers";
    }

    @GetMapping("/see-beer/{marque}?{version}")
    public String getBrewery(Model pModel, @PathVariable(required = true) String marque, @PathVariable(required = true) String version){

        return "beer";
    }

}