Feature: I User want to do some arithmetics with a Calculator

  @Add
  Scenario:
    Given a calculator just turned on
    When I add 1
    And I add 2
    Then the result is 3

  @Substract
  Scenario:
    Given a calculator just reseted
    When I substract 1 from 3
    And I substract 2
    Then the result is 0

  @Multiply
  Scenario:
    Given a calculator just reseted
    When I multiply 2 with 3
    And I multiply by 2
    Then the result is 12

  @Divide
  Scenario:
    Given a calculator just reseted
    When I divide 6 by 2
    And I divide by 2
    Then the result is "1.5"

  @DivideByZero
  Scenario:
    Given a calculator just reseted
    When I divide "6 by 0"
    Then an error with the Message "Cannot divide by zero" should occur
