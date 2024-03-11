*** Settings ***
Resource    resource.robot
Documentation    test for Infotiv Car Rental Internship Project
Library    SeleniumLibrary
Suite Setup     setup




*** Test Cases ***
Log in with positive scenario

    Log in with right credentials       ${username}      ${password}
    Logout


Log in with negative scenario
    Log in with wrong password   ${username}     ${password2}

Log in without password

    Log in without entering password    ${username}

Book a car

    Given Log in with right credentials      ${username}      ${password}
    When I select continue
    And I click on Book
    And I enter my card details and click confirm
    Then The system should be able to show me the booked car details


Book a car by selecting a model and passenger
    Given Open the browser
    And Log in with right credentials      ${username}      ${password}
    When I select continue
    When I select model and number of passengers
    Then I should be able to see the book button
    And Close the Browser


To verify that user can select only one car model and number of passenger
    Given Open the browser
    And Log in with right credentials      ${username}      ${password}
    When I select continue
    And I select the models and number of passengers
    Then Verify I can select only one model
    And Close the Browser




Book a car on a specific date without logging in

    Given Open the browser
    When I select start and end date
    And I select continue
    When I click on Book
    Then I should be able to see an alert to log in
    And Close the Browser


Navigate to my page to see Booking History
    Given Open the browser
    Given Log in with right credentials      ${username}      ${password}
    When I click on MyPage
    And I can see my Bookings
    Then I can also see my bookings under Show History
    And Close the Browser












