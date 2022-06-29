package fr.almeri.beerboard.controllers;

//import fr.almeri.beerboard.models.Users;

import fr.almeri.beerboard.Utils;
import fr.almeri.beerboard.models.Brasserie;
import fr.almeri.beerboard.models.User;
import fr.almeri.beerboard.repositories.PaysRepository;
import fr.almeri.beerboard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profil")
    public String profile(Model pModel, HttpSession session) {

        if (session.getAttribute("auth") != null) {
            pModel.addAttribute("user", new User());
            return "profil";

        } else {
            // Page de connexion
            return "login";
        }

    }
    @GetMapping("/add-user")
    public String addUserForm(Model pModel, HttpSession session) {

        if (session.getAttribute("auth") != null) {
            pModel.addAttribute("user", new User());
            return "add-user";

        } else {
            // Page de connexion
            return "login";
        }

    }
    @PostMapping("/add-user")
    public String addProfil(@Validated @ModelAttribute User user, Model pModel, HttpSession session, RedirectAttributes message) throws NoSuchAlgorithmException, NoSuchFieldException, NoSuchProviderException {
        if (session.getAttribute("auth") != null) {
            user.setSalt(Utils.getSalt());
            user.setPassword(Utils.hashMD5withSalt(user.getPassword(), user.getSalt()));
            userRepository.findByLogin()
            message.addFlashAttribute("messagehtml", " L'utilisateur a bien été enregistré.");
            userRepository.save(user);
            return "redirect:/";

        } else {
            // Page de connexion
            return "login";
        }
    }
}
