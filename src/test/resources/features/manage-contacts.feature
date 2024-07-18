Feature: Manage Contacts
  As an user I should be able to create, update and delete contacts in my agenda

  Background:
    Given user logs in the system

  @CreateContact
  Scenario: Create a contact

    When user "creates" contact 3
    Then contact 3 is present on the contacts list
    And user logs out of the system

    @UpdateContact
    Scenario: Update a contact

      When user updates contact 3 with contact 2 information
      Then contact 3 has contact 2 information
      And user logs out of the system

    @DeleteContact
    Scenario: Delete a contact

      When user "deletes" contact 2
      Then contact 2 is not present on the contacts list
      And user logs out of the system