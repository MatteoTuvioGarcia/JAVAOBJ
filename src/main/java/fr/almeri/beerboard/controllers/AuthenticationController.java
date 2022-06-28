package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.Utils;
import fr.almeri.beerboard.models.*;
import fr.almeri.beerboard.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
@Controller
public class AuthenticationController {
    @Autowired
    private UserRepository usersRepository;

    @GetMapping("/login")
    public String redirectToLogin(Model model, HttpSession session)
    {
        if (session.getAttribute("auth") != null)
        {
            return "redirect:/";

        }else {
            model.addAttribute("isBad", false);
            return "login";
        }


    }

    @PostMapping("/login")
    public String Authentifier(@ModelAttribute User user, HttpSession session, Model model) throws NoSuchAlgorithmException, NoSuchFieldException, NoSuchProviderException {

        // Vérification au niveau de la base de données.
        boolean isOk = this.checkPassword(user);


        if (isOk)
        {
            session.setAttribute("auth", user);
            session.setMaxInactiveInterval(600);
            return "redirect:/";

        } else {
            return "redirect:/login";
        }


    }
    @GetMapping("/logout")
    public String logout(Model pModel, HttpSession session){
        session.removeAttribute("auth");
        session.invalidate();
        return "redirect:/login";
    }
    private boolean checkPassword(User user) throws NoSuchAlgorithmException, NoSuchFieldException, NoSuchProviderException {
        User u = usersRepository.findByLogin(user.getLogin());
        if (u == null)
        {
            return false;
        }
        String newPass = Utils.hashMD5withSalt(user.getPassword(), u.getSalt());
        return newPass.equals(u.getPassword());
    }
}
