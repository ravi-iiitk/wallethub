Feature: Login for facebook

Scenario: To test positive login flow.
Given I am on facebook login page
When I enter the user id
And I enter the password
And I hit login
Then I must be able to login.