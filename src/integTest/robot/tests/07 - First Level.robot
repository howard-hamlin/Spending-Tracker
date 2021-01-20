*** Settings ***
Variables     ${RESOURCES}/sut.py
Resource      ${LIBRARIES}/common.robot
Library       com.ca.cdd.dummy.robot.RESTClient

*** Test Cases ***
First Level
    Call Dummy Application  6

