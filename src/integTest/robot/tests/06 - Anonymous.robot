*** Settings ***
Variables     ${RESOURCES}/sut.py
Resource      ${LIBRARIES}/common.robot
Library       com.ca.cdd.dummy.robot.RESTClient

*** Test Cases ***
Anonymous
    Call Dummy Application  5

