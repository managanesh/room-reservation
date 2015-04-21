package gani.ms.rrs.services.impl;

import gani.ms.rrs.domain.Profile;
import gani.ms.rrs.repositories.ProfileRepository;
import gani.ms.rrs.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by ganesh.vallabhaneni on 4/14/2015.
 */

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProfileServiceImpl implements IProfileService {

    @Autowired
    private ProfileRepository profileRepository;


    @Override

    public Profile getProfile(@NotNull Profile profile) {

        return getProfile(profile.getProfileId());
    }

    @Override
    public Profile getProfile(@NotNull Integer profileId) {
        return  (Profile)profileRepository.getOne(profileId);
    }

    @Override
    public void updateProfile(@NotNull Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(@NotNull Profile profile) {
        profileRepository.delete(profile);
    }

    @Override
    public void deleteProfile(@NotNull Integer profileId) {
        profileRepository.delete(profileId);
    }


    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileRepository getProfileRepository() {
        return profileRepository;
    }

}
