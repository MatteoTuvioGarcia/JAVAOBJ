package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.Pays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ExempleController {
    //définit les routes appelée par méthode GET
    @GetMapping("/exemple")
    public String getPageExemple(Model pModel){

        Pays pays = new Pays();
        pays.setNomPays("France");
        pays.setConsommation(120);
        pays.setProduction(10);

        Pays pays2 = new Pays();
        pays2.setNomPays("Allemagne");
        pays2.setConsommation(12);
        pays2.setProduction(4);

        Pays pays3 = new Pays();
        pays3.setNomPays("USA");
        pays3.setConsommation(1204);
        pays3.setProduction(120);

        Pays pays4 = new Pays();
        pays4.setNomPays("Belgique");
        pays4.setConsommation(6);
        pays4.setProduction(17);

        ArrayList<Pays> listPays = new ArrayList<>();

        listPays.add(pays);
        listPays.add(pays2);
        listPays.add(pays3);
        listPays.add(pays4);
        //Objet model instnacié par Spring automatiquement, permet de modifier les données de la page


        pModel.addAttribute("listPays",listPays);
        return "exemple";
    }
}
