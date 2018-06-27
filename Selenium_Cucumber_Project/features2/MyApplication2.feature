Feature: Test Facebook smoke scenario

         Scenario: Testlogin with invalid credential
         Given open firefox and start application
         When I enter valid username and invalid password
         Then User should get validation message
         
         