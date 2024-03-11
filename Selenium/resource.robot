*** Settings ***
Library    SeleniumLibrary
Library    XML
Library     Collections

*** Variables ***
${username}    amrimukh2@gmail.com
${password}     Infotiv
${password2}     myData
${url}      https://rental12.infotiv.net/
${cardnumber}   1234567899876543
${cvc}     123
${checkboxMake_xpath}  //div[@id='ms-list-1']//button[@type='button']
${checkboxPassenger_xpath}  //div[@id='ms-list-2']//button[@type='button']
@{actuallist}
@{expectedlist}      5	Audi	Q7	2024-02-17	2024-02-17	5	BBE466

*** Keywords ***
setup
  #  Set Selenium Speed    1    #används för att styra hastighet
    Open Browser    browser=Chrome
    Go To   ${url}

Log in with right credentials
    [Documentation]     goto login page
    [Tags]      VG_Test_login
    [Arguments]     ${username}     ${password}
    #Wait Until Page Contains    When do you want to make your trip?
    Maximize Browser Window
    Input Text    //input[@id='email']    ${username}
    Input Password    //input[@id='password']    ${password}
    Click Element    //button[@id='login']
    Wait Until Page Contains    You are signed in as Amrita

Logout
    [Documentation]     Logout
    [Tags]      VG_Test_logout
    Click Element    //button[@id='logout']
    
 Log in with wrong password
    [Documentation]     goto login page
    [Tags]      VG_Test_login
    Wait Until Page Contains    Infotiv Car Rental
    [Arguments]     ${username}     ${password2}
    Maximize Browser Window
    Input Text    //input[@id='email']    ${username}
    Input Password    //input[@id='password']    ${password2}
    Click Element    //button[@id='login']
    Wait Until Page Contains    Wrong e-mail or password

 Log in without entering password
    [Documentation]     goto login page , Negative test case
    [Tags]      VG_Test_login
    Wait Until Page Contains    Infotiv Car Rental
    [Arguments]     ${username}
    Maximize Browser Window
    Input Text    //input[@id='email']    ${username}
    Click Element    //button[@id='login']
    ${is_required}      SeleniumLibrary.Get Element Attribute    //input[@id='password']    required
    #Log    ${is_required}
    Should Be Equal    ${is_required}    true



I select continue
    [Documentation]     Car booking
    [Tags]      VG_Test_Book
    Click Element    //button[@id='continue']

I click on Book
    [Documentation]     Car booking
    [Tags]      VG_Test_Book
    Click Element    id=bookQ7pass5

I enter my card details and click confirm
    [Documentation]     Enter Card details
    [Tags]      VG_Test_Book
    Input Text    //input[@id='cardNum']    ${cardnumber}
    Input Text    //input[@id='fullName']    Amrita
    Select From List By Label    //select[@title='Month']   11
    Select From List By Label    //select[@title='Year']    2025
    Input Text    id=cvc    ${cvc}
    Click Button    id=confirm

The system should be able to show me the booked car details
    [Documentation]     Car booking
    [Tags]      VG_Test_Book
    Wait Until Page Contains    is now ready for pickup     10s
    Click Element    //button[@id='logout']



I select model and number of passengers
    [Documentation]     Car selection
    [Tags]      VG_Test_Book
    Click Button   ${checkboxMake_xpath}
    Select Checkbox    id=ms-opt-1
  #  Checkbox Should Be Selected    id=ms-opt-1
    Click Button    ${checkboxPassenger_xpath}
    Select Checkbox    id=ms-opt-5
  #  Checkbox Should Be Selected    id=ms-opt-5


I should be able to see the book button
    [Documentation]     Car selection , Negative scenario
    [Tags]      VG_Test_Book
    Wait Until Page Contains Element    id=bookTTpass2

I select the models and number of passengers

    [Documentation]     Car selection
    [Tags]      VG_Test_Book
    Click Button   ${checkboxMake_xpath}
    Select Checkbox    id=ms-opt-1
    Select Checkbox    id=ms-opt-2
    Select Checkbox    id=ms-opt-3
  #  Checkbox Should Be Selected    id=ms-opt-1
    Click Button    ${checkboxPassenger_xpath}
    Select Checkbox    id=ms-opt-5


Verify I can select only one model

    [Documentation]     Car selection
    [Tags]      VG_Test_Book
    Checkbox Should Be Selected    id=ms-opt-1
    Checkbox Should Not Be Selected    id=ms-opt-2
   # Checkbox Should Be Selected    id=ms-opt-5
    #Click Element    //button[@id='logout']



I select start and end date
    [Documentation]     Date selection
    [Tags]      VG_Test1_Date
    Input Text    //input[@id='start']      2024/02/29
    Input Text    //input[@id='end']    2024/02/29

I should be able to see an alert to log in
    [Documentation]     Car booking
    [Tags]      VG_Test1_Date
    Alert Should Be Present     You need to be logged in to continue.

I click on MyPage
    [Documentation]     Page Navigation
    [Tags]      VG_Test_Navigate
    Click Element    //button[@id='mypage']

I can see my Bookings
    [Documentation]     Page Navigation
    [Tags]      VG_Test_Navigate
    Page Should Contain Element    //td[@id='order1']

I can also see my bookings under Show History
    [Documentation]     Page Navigation
    [Tags]      VG_Test_Book
    Click Element    //button[@id='show']
    Page Should Not Contain    Order history empty




Verify I am at Car Selection Page
    [Documentation]     Car selection
    [Tags]      VG_Test_Book
    Click Element    //button[@id='cancel']
    Wait Until Page Contains    What would you like to drive?     10s

    
Open the browser
    [Documentation]     Browser
    [Tags]      VG_Test1_browser
    Open Browser    https://rental12.infotiv.net/   chrome
    Wait Until Page Contains Element    //button[@id='login']

Close the Browser
    [Documentation]     Browser
    [Tags]      VG_Test1_browser
    Close Browser


    







