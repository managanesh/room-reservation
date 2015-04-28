package gani.ms.rrs.controllers;

import gani.ms.rrs.domain.Profile;
import gani.ms.rrs.repositories.ProfileRepository;
import gani.ms.rrs.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by ganesh.vallabhaneni on 4/16/2015.
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    IProfileService profileService;

    @RequestMapping(value = "/{profileId}", method = RequestMethod.GET, produces = "application/json")
    public Profile getProfile(@PathVariable("profileId") Integer profileId) {
        Optional profileObj;

    return Optional.ofNullable(profileService.getProfile(profileId)).orElse(new Profile());
    }

    @RequestMapping( method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})

    public Profile CreateProfile(@RequestBody Profile profile){

                profile =  profileService.updateProfile(profile);
                return profile;
    }

}
