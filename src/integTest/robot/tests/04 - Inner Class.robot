*** Settings ***
Variables     ${RESOURCES}/sut.py
Resource      ${LIBRARIES}/common.robot
Library       com.ca.cdd.dummy.robot.RESTClient



*** Test Cases ***
Inner Class
    Call Dummy Application  3

