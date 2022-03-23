package com.rest.blog.util;

public class Constantes {

    public static final String LOGIN_URL = "/api/login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT

    public static final String ISSUER_INFO = "Blog";
    public static final String SUPER_SECRET_KEY = "BlogApi";
    public static final int TOKEN_EXPIRATION_TIME = 60000;

    // TOKEN

    public static final String REQUEST_TOKEN_URL = "/api/login";
    public static final String AUTHORITIES_KEY = "CLAIM_TOKEN";
    public static final String SIGNING_KEY = "KEY_0532";
    public static final String CLIENTE = "Blog_Api";
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 28800;
    public static final String ISSUER_TOKEN = "ISSUER";
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";

    public static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/v3/api-docs",
            "/swagger-resources/**",
            "/swagger-ui/**"};

    // ROLES

    public static final String ADMIN = "ADMIN";
    public static final String USER = "[ROLE_USER]";
    public static final String OPERATIONAL = "[ROLE_OPERATIONAL]";

    // PATH
    public static final String LOGIN = "/api/login";
    public static final String USER_AUTHORIZE = "/api/userAuthorize";
}
