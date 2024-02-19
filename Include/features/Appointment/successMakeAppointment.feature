@Appointment
Feature: Appointment - Success
	Background:
		Given I open browser and navigate to website
		Then I login in that website with username John Doe and password ThisIsNotAPassword

  @Testing
  Scenario Outline: Success Make an Appointment
    When I select a value <facility> in dropdown facility field
    And I figure it out to select hospital readmission checklist <readmission>
    And I select a value <healthcare_program> radio button Healthcare Program
    And I input visit schedule and set date
    And Write a comment
    And Click Book Appointment button 
    Then Success create appointment and verify the input <facility> <healthcare_program> <readmission>

    Examples: 
      | facility                        | healthcare_program     | readmission |
      | Tokyo CURA Healthcare Center    | radio_program_medicare | Y           |
      | Hongkong CURA Healthcare Center | radio_program_medicaid | N           |
      | Seoul CURA Healthcare Center    | radio_program_none     | Y           |