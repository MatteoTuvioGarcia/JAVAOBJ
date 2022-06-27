package fr.almeri.beerboard.controllers;

import fr.almeri.beerboard.models.User;
import fr.almeri.beerboard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profil")
    public String profile(Model pModel){
        /*TODO*/
        return "profil";
    }

    //add salt



    //Pw hash

    private static String hashMD5withSalt(String passwordToHash, byte[] salt){
        String generatedPassword = null;

        MessageDigest md = null;
        try {
            md= MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        md.update(salt);
        byte[] bytes = md.digest(passwordToHash.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
        }
        generatedPassword = sb.toString();
        return generatedPassword;
    }

    public boolean checkPassword(User user) throws NoSuchAlgorithmException, NoSuchProviderException {
        User u = userRepository.findByLogin(user.getLogin());
        if (u == null){
            return false;
        }

        String newPass = hashMD5withSalt(user.getPassword(), User.getSalt());
        return newPass.equals(u.getPassword());
    }

//    String pass = "pass";
//    try {
//        byte[] salt = User.getSalt();
//        String hashed = hashMD5withSalt(pass, salt);
//        User u = new User(1,"lapin",hashed);
//        userRepository.save(u);
//    }
//    catch (NoSuchAlgorithmException e){
//        e.printStackTrace();
//    }
//    catch (NoSuchProviderException e){
//        e.printStackTrace();
//    }
}
