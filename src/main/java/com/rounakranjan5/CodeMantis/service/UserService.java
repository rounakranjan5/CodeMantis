package com.rounakranjan5.CodeMantis.service;

import com.rounakranjan5.CodeMantis.entity.User;
import com.rounakranjan5.CodeMantis.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public User registerOrUpdate(OAuth2User oAuth2User){

        Integer githubUserId=oAuth2User.getAttribute("id");
        String username=oAuth2User.getAttribute("login");
        String name=oAuth2User.getAttribute("name");
        String email=oAuth2User.getAttribute("email");
        String avatarUrl=oAuth2User.getAttribute("avatar_url");



        Optional<User> existingUser= userRepository.findByGithubUserId(githubUserId);

        if(existingUser.isPresent()){
            User user=existingUser.get();
            user.setName(name);
            user.setUsername(username);
            user.setAvatarUrl(avatarUrl);
            user.setEmail(email);
            return userRepository.save(user);
        }


        User user=new User(githubUserId,username,name,email,avatarUrl);
        return userRepository.save(user);

    }

}
