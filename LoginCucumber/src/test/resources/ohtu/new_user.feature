Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation is successful with valid username and password
    Given command new user is selected
    When username "matti" and password "matti&teppo" are entered
    Then system will respond with "new user registered"

  Scenario: creation fails with already taken username and valid password
    Given user "matti" with password "mattiteppo1" is created
    And command new user is selected
    When username "matti" and password "teppo1234" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with too short username and valid password
    Given command new user is selected
    When username "ma" and password "teppo1234" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and too short password
    Given command new user is selected
    When username "teppo" and password "matti" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and password enough long but consisting of only letters
    Given command new user is selected
    When username "teppo" and password "mattijateppo" are entered
    Then system will respond with "new user not registered"

  Scenario: can login with successfully generated account
    Given user "matti" with password "mattiteppo1" is created
    And command login is selected
    When username "matti" and password "mattiteppo1" are entered
    Then system will respond with "logged in"
