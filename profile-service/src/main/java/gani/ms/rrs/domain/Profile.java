package gani.ms.rrs.domain;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ganesh.vallabhaneni on 4/13/2015.
 */
@Entity
public class Profile implements Serializable{



    @Id
    @GeneratedValue
    private Integer profileId;


    private String name;

    private String email;


    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (email != null ? !email.equals(profile.email) : profile.email != null) return false;
        if (profileId != null ? !profileId.equals(profile.profileId) : profile.profileId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = profileId != null ? profileId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
