package com.Admin.DemoAdmin.Mapper;

import com.Admin.DemoAdmin.DTOs.ProfileDTO;
import com.Admin.DemoAdmin.Entity.Profile;
import com.Admin.DemoAdmin.Entity.User;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    public ProfileDTO toProfileDTO(User user, Profile profile) {
        String createdAtString = user != null && user.getCreateAt() != null ? dateFormatter.format(user.getCreateAt()) : null;
        String fullName = profile != null ? profile.getFullName() : null;
        String bio = profile != null ? profile.getBio() : null;
        String phoneNumber = profile != null ? profile.getPhoneNumber() : null;
        String address = profile != null ? profile.getAddress() : null;
        String birthdayString = profile != null && profile.getBirthday() != null ? dateFormatter.format(profile.getBirthday()) : null;
        String avatar = profile != null ? profile.getAvatarUrl() : null;

        return new ProfileDTO(
            user != null ? user.getUserId() : null,
            user != null ? user.getUsername() : null,
            user != null ? user.getEmail() : null,
            user != null ? user.getGender().toString() : null,
            user != null ? user.getRole() : null,
            createdAtString,
            user != null ? user.isLocked() ? "Unban" : "Ban" : null,
            fullName,
            bio,
            phoneNumber,
            address,
            birthdayString,
            avatar
        );
    }
}

