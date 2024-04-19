//package com.ecom.service;
//
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequestEntityConverter;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.security.oauth2.core.OAuth2Error;
//import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
//import org.springframework.security.oauth2.core.OAuth2TokenValidator;
//import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
//import org.springframework.security.oauth2.core.user.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.user.OAuth2UserRequestEntityConverter;
//import org.springframework.security.oauth2.core.user.OAuth2UserService;
//import org.springframework.security.oauth2.core.user.OAuth2UserServiceException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.util.Assert;
//import org.springframework.util.StringUtils;
//import org.springframework.web.client.RestTemplate;
//
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2UserServiceException {
//        Assert.notNull(userRequest, "userRequest cannot be null");
//
//        ClientRegistration clientRegistration = userRequest.getClientRegistration();
//        String userInfoEndpointUri = clientRegistration.getProviderDetails().getUserInfoEndpoint().getUri();
//
//        OAuth2AccessToken accessToken = userRequest.getAccessToken();
//        String tokenType = accessToken.getTokenType().getValue();
//        String accessTokenValue = accessToken.getTokenValue();
//        String requestUrl = StringUtils.hasText(userInfoEndpointUri) ? userInfoEndpointUri : "";
//
//        // Customize the request URL or parameters as needed
//
//        // Add your custom logic here
//
//        return null; // Return the OAuth2User object with the desired user information
//    }
//}
