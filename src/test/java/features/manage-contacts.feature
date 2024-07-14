Feature: Manage Contacts
  Verify if user is able to Login and manage his contacts

  Background:
    Given user "1" logs in the system

  @CreateContact
    Scenario: Create a contact

      When user tries to create a contact

      Then success message is displayed

    @UpdateContact
    Scenario: Update a contact

      When user tries to update a contact

      Then success message is displayed

    @DeleteContact
    Scenario: Delete a contact

      When user tries to delete a contact

      Then success message is displayed