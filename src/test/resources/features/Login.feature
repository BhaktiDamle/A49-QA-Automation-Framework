Feature: Login feature
  Scenario: Login success
    Given I open Login Page
    When I enter Email "bhakti.damle@testpro.io"
    And I enter password "Mangodesk234!"
    And I submit
    Then I am logged in
