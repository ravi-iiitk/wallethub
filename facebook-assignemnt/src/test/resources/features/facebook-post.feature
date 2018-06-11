Feature: Facebook User Post 

Scenario: To Verify Facebook post is working
Given I have opened facebook page
When I am on facebook login page
And I enter credentials
|user_id			 |password	 |
|ravi.iiitk@gmail.com|F@ceb00kPwd|
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
