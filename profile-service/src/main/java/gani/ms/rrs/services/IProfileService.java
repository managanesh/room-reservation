package gani.ms.rrs.services;

import gani.ms.rrs.domain.Profile;

/**
 * Created by ganesh.vallabhaneni on 4/14/2015.
 */
public interface IProfileService {

    public Profile getProfile(Profile profile);

    public Profile getProfile(Integer profileId);

    public void updateProfile(Profile profile);

    public void deleteProfile(Profile profile);

    public void deleteProfile(Integer profileId);
}
