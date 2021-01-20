*** Settings ***
Variables     ${RESOURCES}/sut.py
Resource      ${LIBRARIES}/common.robot
Library       com.ca.cdd.dummy.robot.RESTClient

*** Test Cases ***
Parameters From Parent
    Call Dummy Application  9

