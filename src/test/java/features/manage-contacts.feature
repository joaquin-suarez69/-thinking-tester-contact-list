Feature: Manage Contacts
  Verify if user is able to Login and manage his contacts

  Background:
    Given user "1" logs in the system

  @CreateContact
    Scenario: Create a contact

      When user tries to create a contact

      Then new contact is present on the contacts list

    @UpdateContact
    Scenario: Update a contact

      When user tries to update a contact

      Then updated contact on the contacts list

    @DeleteContact
    Scenario: Delete a contact

      When user tries to delete a contact

      Then success message is displayed