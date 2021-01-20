*** Variables ***
${EXTENSION}=  api/libraries

*** Keywords ***

Call Dummy Application
    [Arguments]  ${index}=${EMPTY}
    ${response}=  Rest Call  GET  ${SERVER_URL}/${EXTENSION}/${index}
    Log  \nRESPONSE: ${response}  console=yes