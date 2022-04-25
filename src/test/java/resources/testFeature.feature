Feature: test

Scenario: init
    Then init data-loader "test <num>" "<cmd>"

Examples:
    |num|cmd                   |
    |1  |${_getData[3][4]}     | 
    |2  |${_getData[1][11]}    |
    |3  |${_getData[1111][111]}|
    |4  |${_getdata[1][11]}    |
    |5  |${_getData[111][111]} |
    |6  |${_getData[50][50]}   |
    |7  |${_getData[][]}       |
    |8  |${_getData[4][11]}    |
    |9  |${_getdata[9][11]}    |
    |10 |{_getData[9][11]}     |
    |11 |1[_getdata[9][11]}    |    