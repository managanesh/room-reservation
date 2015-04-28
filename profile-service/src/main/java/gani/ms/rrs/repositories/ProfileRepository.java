package gani.ms.rrs.repositories;

import gani.ms.rrs.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ganesh.vallabhaneni on 4/13/2015.
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    Profile findByProfileId(Integer profileId);
}
