@anticipation
Feature: Verificar a autorização das APIs com escopo anticipation com token gerado pelo Oauth V1 e oauth2

    Deve receber o header Authorization com token Bearer e validar o comportamento da autorização

    @001
    Scenario Outline: Verificar autorização da API <name> com token do oauth2
        Given url baseUrl
        And header Authorization = "Bearer " + oauth2Token
        And path '<path>'
        When method get
        Then status 200
        And match response == {}
        Examples:
            | read('/data/anticipation.yaml') |

    @002
    Scenario Outline: Verificar autorização da API <name> com token do oauth v1
        Given url baseUrl
        And header Authorization = "Bearer " + oauth1Token
        And path '<path>'
        When method get
        Then status 200
        And match response == {}
        Examples:
            | read('/data/anticipation.yaml') |

    @003
    Scenario Outline: Verificar autorização da API de Anticipation com token inválido
        Given url baseUrl
        And header Authorization = "Bearer invalid_token"
        And path '<path>'
        When method get
        Then status 401
        Examples:
            | path              |
            | anticipation/data |

    @004
    Scenario: Verificar autorização da API de Anticipation sem escopo adequado
        Given url baseUrl
        And header Authorization = "Bearer " + tokenWithoutAnticipationScope
        And path 'anticipation/data'
        When method get
        Then status 403
