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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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
    private TypeBiereRepository typeBiereRepository;

    @GetMapping("/beers")
    public String getPageExemple(Model pModel, HttpSession session) {
        if (session.getAttribute("auth") != null) {
            ArrayList<Biere> listBeerFromDatabase = (ArrayList<Biere>) biereRepository.findAll();
            pModel.addAttribute("listbeer", listBeerFromDatabase);
            return "beers";
        } else {
            // Page de connexion
            return "login";
        }
    }


    @GetMapping("/see-beer")
    public String GetBeerByCode(Model pModel, @RequestParam String nomMarque, @RequestParam String nomVersion, HttpSession session) {
        if (session.getAttribute("auth") != null) {
            BiereId bid = new BiereId(new Marque(nomMarque), nomVersion);
            Biere beer = biereRepository.findById(bid).orElseThrow();
            pModel.addAttribute("biere", beer);
            return "beer";
        } else {
            // Page de connexion
            return "login";
        }
    }

    @GetMapping("/add-beer")
    public String addBeerForm(Model pModel, HttpSession session) {
        if (session.getAttribute("auth") != null) {
            pModel.addAttribute("update", false);
            pModel.addAttribute("biere", new Biere());

            ArrayList<TypeBiere> listTypes = (ArrayList<TypeBiere>) typeBiereRepository.findAll();

            ArrayList<Marque> listMarque = (ArrayList<Marque>) marqueRepository.findAll();
            pModel.addAttribute("listeMarque", listMarque);
            ArrayList<TypeBiere> listType = (ArrayList<TypeBiere>) typeBiereRepository.findAll();
            pModel.addAttribute("listeTypeBiere", listType);
            pModel.addAttribute("update", false);
            return "add-beer";


        } else {
            // Page de connexion
            return "login";
        }
    }

    @PostMapping("/add-beer")
    public String ajouterBiere(@Validated @ModelAttribute Biere biere, Model pModel, HttpSession session) {
        if (session.getAttribute("auth") != null) {
            biereRepository.save(biere);
            return "redirect:/beers";
        } else {
            // Page de connexion
            return "login";
        }
    }

    @GetMapping("/mod-beer")
    public String GetBeerByCodeMod(Model pModel, @RequestParam String nomMarque, @RequestParam String nomVersion, HttpSession session) {
        if (session.getAttribute("auth") != null) {
            // Id bière
            BiereId idBiere = new BiereId(new Marque(nomMarque), nomVersion);
            pModel.addAttribute("update", true);
            pModel.addAttribute("biere", biereRepository.findById(idBiere));
            pModel.addAttribute("listeTypeBiere", typeBiereRepository.findAll());
            pModel.addAttribute("listeMarque", marqueRepository.findAll());
            pModel.addAttribute("update", true);
            return "add-beer";
        } else {
            // Page de connexion
            return "login";
        }
    }

    @PostMapping("/mod-beer")
    public String modifierBiere(@Validated @ModelAttribute Biere biere, Model pModel, HttpSession session) {
        if (session.getAttribute("auth") != null) {

            biereRepository.save(biere);
            return "redirect:/beers";
        } else {
            // Page de connexion
            return "login";
        }
    }

    @PostMapping("/del-beer")
    public String SupprimerBiere(Model pModel, @RequestParam String nomMarque, @RequestParam String nomVersion, HttpSession session, RedirectAttributes message) {
        if (session.getAttribute("auth") != null) {
            BiereId idBiere = new BiereId(new Marque(nomMarque), nomVersion);
            Biere biere = biereRepository.findById(idBiere).orElseThrow();
            biereRepository.delete(biere);
            message.addFlashAttribute("messagehtml", " La bière " + biere.getVersion() + " a bien été supprimée.");


            return "redirect:/beers";
        } else {
            // Page de connexion
            return "login";
        }
    }

}
