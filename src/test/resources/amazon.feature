Feature: Test on Amazon.it

  Rule: only test on Amazon.it

  Background:
    Given start driver

  Scenario: Print the category of amazon
    Given open amazon
    Then print the category

  Scenario: Search the suggest item
    Given open amazon
    When make a search of item ipho
    Then click on the suggest item

  Scenario: Print the evidence item
    Given open amazon
    Then evidence element are printed

  Scenario: Print item on the first three page
    Given open amazon
    When make a search of item ipho
    Then click on the suggest item
    Then item page 1 are printed
    Then item page 2 are printed
    Then item page 3 are printed

  Scenario: Open three element in three new tab
    Given open amazon
    When search item iphone
    Then open new tab

  Scenario: Print number of element
    Given open amazon
    When search item iphone
    Then print number

  Scenario: Add to cart and clear cart
    Given open amazon
    When search item groot
    When add item mascherina item borraccia item rocket at cart
    Then clear cart