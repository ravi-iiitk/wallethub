Feature: Facebook User Post 


Scenario: To test positive login flow.
Given I am on facebook login page
When I enter the user id
And I enter the password
And I hit login
Then I must be able to login.

@smoke
Scenario: To Verify Facebook post is working
Given I have opened facebook page
When I am on facebook login page
And I enter credentials
|user_id			 |password	 |
|<user_id>|<password>|
And Click on Login Button 
Then I must be able to login 
And I must see my facebook home page
When I create a post
|post_text  |	
|Hello World|
And Post it to my time line 
Then I must see the recently created facebook post
|post_text  |	
|Hello World|
When I click on logout button
Then I must be logged out from facebook
