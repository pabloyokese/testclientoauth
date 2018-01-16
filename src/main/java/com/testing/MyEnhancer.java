package com.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;


import java.util.HashMap;
import java.util.Map;

public class MyEnhancer extends JwtAccessTokenConverter {
	@Autowired
	private UserRepository userRepository;
	
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        OAuth2AccessToken token = super.enhance(accessToken, authentication);
        Map<String, Object> additionalInfo = new HashMap<>();
        CustomUserDetails principal = (CustomUserDetails)authentication.getPrincipal();
        additionalInfo.put("user_id", principal.getId());
        token.getAdditionalInformation().putAll(additionalInfo);
        User user = userRepository.findOne(principal.getId());
        UserInfo userInfo = new UserInfo(user);
        additionalInfo.put("user_info", userInfo);
        ((DefaultOAuth2AccessToken)token).setAdditionalInformation(additionalInfo);
        
        // Encode Token to JWT
        String encoded = super.encode(token, authentication);
        // Set JWT as value of the token
        ((DefaultOAuth2AccessToken) token).setValue(encoded);
        return token;
    }


}
