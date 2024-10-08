package com.whoimi.utils;

import com.whoimi.model.UserKimDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author whoimi
 * @since 2023-10-12
 **/
public class SecurityKimUtils {

    public static UserKimDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserKimDetails) authentication.getPrincipal();
    }

    public static String getUsername() {
        return getCurrentUser().getUsername();
    }
}
