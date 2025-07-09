function fn() {
    var config = {
        baseUrl: 'http://localhost:8080',
        oauth1Token: 'oauth1_token_example',
        oauth2Token: 'oauth2_token_example',
        tokenWithoutAffiliateScope: 'token_without_affiliate_scope',
        tokenWithoutAnticipationScope: 'token_without_anticipation_scope',
        tokenWithoutAppstoreScope: 'token_without_appstore_scope'
    };

    var env = karate.env;
    if (env == 'dev') {
        config.baseUrl = 'http://localhost:8080';
    } else if (env == 'qa') {
        config.baseUrl = 'https://qa.example.com';
    } else if (env == 'prod') {
        config.baseUrl = 'https://api.example.com';
    }

    return config;
}
