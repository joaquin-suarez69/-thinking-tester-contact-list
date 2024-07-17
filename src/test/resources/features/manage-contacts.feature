Feature: Manage Contacts
  Verify if user is able to Login and manage his contacts

  Background:
    Given user logs in the system

  @CreateContact
  Scenario: Create a contact

    When user tries to "create" contact 1
    Then contact 1 is present on the contacts list

    @UpdateContact
    Scenario: Update a contact

      When user tries to update contact 1 with contact 2 information
      Then contact 1 has contact 2 information

    @DeleteContact
    Scenario: Delete a contact

      When user tries to "delete" contact 1
      Then contact 1 is not present on the contacts list