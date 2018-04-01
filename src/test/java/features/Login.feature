Feature: LoginFeature
  This feature deals with the login functionality of the application

#  Scenario: Login with correct username and password
#    Given I navigate to the login page
#    And I enter the following Login
#      | userName | password      |
#      | admin    | adminpassword |
#    And I click login button
#    Then I should see the userform page
#
#  Scenario Outline: Login with correct username and password using scenario outline
#    Given I navigate to the login page
#    And I enter <userName> and <password>
#    And I click login button
#    Then I should see the userform page
#
#    Examples:
#      | userName | password      |
#      | admin    | adminpassword |
#      | admin2   | 12345678      |
#      | admin33  | asddstrter555 |
#      | adm      | 100000000     |
#
#
  Scenario: Login with correct username, password and email
    Given I navigate to the login page
    And I enter the users email address as email:admin
    And I verify the count of my salary digits for Rs 1000
    And I enter the following Login
      | userName | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform page

#    Scenario: Login with correct username and password
#    Given I navigate to the login page
#    And I enter the following Login
#      | userName | password      |
#      | admin    | adminpassword |
#    And I click login button
#    Then I should see the userform page

