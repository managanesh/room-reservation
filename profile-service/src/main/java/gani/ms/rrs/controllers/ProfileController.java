package gani.ms.rrs.controllers;

import gani.ms.rrs.domain.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ganesh.vallabhaneni on 4/16/2015.
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @RequestMapping(value = "/{profileId}", method = RequestMethod.GET, produces = "application/json")
    public Profile getProfile(@PathVariable("profileId") Integer profileId) {
        System.out.println("ProfileController.getProfile");
        return new Profile();
    }
}
