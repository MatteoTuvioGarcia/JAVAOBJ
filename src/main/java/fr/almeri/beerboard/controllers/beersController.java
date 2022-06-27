package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.*;
import fr.almeri.beerboard.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

//indique à spring boot un routage
@Controller
public class beersController {
    //route de GET

    @Autowired
    private BiereRepository biereRepository;
    @Autowired
    private MarqueRepository marqueRepository;
    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/beers")
    public String getPageExemple(Model pModel)
    {
        ArrayList<Biere> listBeerFromDatabase = (ArrayList<Biere>) biereRepository.findAll();
        pModel.addAttribute("listbeer",listBeerFromDatabase);
        return "beers";
    }

    @GetMapping("/see-beer")
    public String GetBeerByCode(Model pModel, @RequestParam String nomMarque, @RequestParam String nomVersion )
    {
        BiereId bid = new BiereId(new Marque(nomMarque),nomVersion);
        Biere beer = biereRepository.findById(bid).orElseThrow();
        pModel.addAttribute("biere", beer);
        return "beer";
    }

    @GetMapping("/add-beer")
    public String addBeerForm(Model pModel)
    {
        pModel.addAttribute("biere", new Biere());
        pModel.addAttribute("update", false);
        pModel.addAttribute("listeType", typeRepository.findAll());
        pModel.addAttribute("listeMarque", marqueRepository.findAll());


        return "add-beer";
    }

    @PostMapping("/add-beer")
    public String ajouterBiere (@Validated @ModelAttribute Biere biere, Model pModel)
    {

        biereRepository.save(biere);
        return "redirect:/beers";
    }

    @GetMapping("/mod-beer")
    public String GetBeerByCodeMod(Model pModel, @RequestParam String nomMarque, @RequestParam String nomVersion )
    {
        // Id bière
        BiereId idBiere = new BiereId(new Marque(nomMarque),nomVersion);

        pModel.addAttribute("update", true);
        pModel.addAttribute("biere", biereRepository.findById(idBiere));
        pModel.addAttribute("listeType", typeRepository.findAll());
        pModel.addAttribute("listeMarque", marqueRepository.findAll());


        return "add-beer";
    }

    @PostMapping("/mod-beer")
    public String modifierBiere (@Validated @ModelAttribute Biere biere, Model pModel)
    {

        biereRepository.save(biere);
        return "redirect:/beers";
    }

}
