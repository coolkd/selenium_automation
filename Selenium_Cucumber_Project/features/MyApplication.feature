Feature: Test Facebook smoke scenario

        Scenario Outline: Test login with valid credential
        Given Open firefox and start application
        When I enter valid "<kdcool86>" and valid "turnmeon"
        Then user should be able to login successfully
        
        Examples:
        |username |password |
        |kdcool86 |turnmeon |
        |kdcool99 |turnmeon2 |
        |kdcool89 |turnmeon3 | 
        

                 
