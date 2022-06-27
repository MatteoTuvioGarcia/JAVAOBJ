package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.*;
import fr.almeri.beerboard.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String getPage(Model pModel)
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

    @GetMapping("/add-brewery")
    public String ajouterBrasserieForm(Model model)
    {
        model.addAttribute("update", false);
        model.addAttribute("brasserie", new Brasserie());
        // regionRepository.getListeNomRegionObjAsc() retourne la liste des régions
        model.addAttribute("listeRegion", regionRepository.getListeNomRegionObjAsc());

        return "add-brewery";
    }

    @PostMapping("/add-brewery")
    public String ajouterBrasserie (@Validated @ModelAttribute Brasserie brasserie, Model model)
    {
        // Création d'une brasserie + enregistrement dans la base de données.
        brasserieRepository.save(brasserie);

        return "redirect:/breweries";
    }

    @PostMapping("/mod-brewery")
    public String ModifierBrasserie (@Validated @ModelAttribute Brasserie brasserie, Model model)
    {
        // Création d'une brasserie + enregistrement dans la base de données.
        brasserieRepository.save(brasserie);

        return "redirect:/breweries";
    }

    @PostMapping("/del-brewery")
    public String SupprimerBrasserie (@Validated @ModelAttribute Brasserie brasserie, Model model)
    {
        // suppression d'une brasserie
        brasserieRepository.delete(brasserie);
        return "redirect:/breweries";
    }


}
