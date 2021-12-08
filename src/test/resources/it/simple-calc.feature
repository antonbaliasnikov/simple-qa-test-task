Feature: Simple Calc Integration

  Scenario Outline: Should sum up
    Given SimpleCalc exists
    When I add <x> and <y>
    Then the result should be int <result>
    Examples:
    | x          | y           | result      |
    | 0          | 0           | 0           |
    | 1          | 1           | 2           |
    | -1         | -1          | -2          |
    | 2147483647 | 0           | 2147483647  |
    | 0          | -2147483648 | -2147483648 |

  Scenario Outline: Should multiply
    Given SimpleCalc exists
    When I multiply <x> and <y>
    Then the result should be double <result>
    Examples:
    | x  | y  | result |
    | 0  | 0  | 0      |
    | 1  | 0  | 0      |
    | 0  | 1  | 0      |
    | 1  | -1 | -1     |
    | -1 | 1  | -1     |
    | -1 | -1 | 1      |
    | 5  | 5  | 25     |

  Scenario Outline: Should sum up evens
    Given SimpleCalc exists
    When I sum the evens of [<array>]
    Then the result should be int <result>
    Examples:
    | array          | result |
    | 1, 2, 3, 4, 5  | 6      |
    | 0              | 0      |
    | 2              | 2      |
    | 1, 3, 5        | 0      |
    | -2, 2          | 0      |
    | -1, -2, -3, -4 | -6     |

  Scenario: Should return 0 when empty array
    Given SimpleCalc exists
    When I sum the evens of empty array
    Then the result should be int 0