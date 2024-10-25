# CS-320

How can I ensure that my code, program, or software is functional and secure?

To ensure that my code is both functional and secure, I adopted a test-driven development (TDD) approach. By writing unit tests for each service class such as 'Contact', 'Task', and 'Appointment', I was able to verify the functionality of my code and uncover potential issues early on. I also applied validation checks, such as making sure that phone numbers only contain digits and limiting the length of input fields like descriptions. In terms of security, I validated all inputs to avoid potential exploits like buffer overflows or incorrect data entry. I also made sure that immutable fields like 'contactID' and 'appointmentID' could not be altered, preserving data integrity.

How do I interpret user needs and incorporate them into a program?

User needs were interpreted through the project’s software requirements, which clearly outlined the behavior and constraints for each service. I made sure that these needs were translated into functional code by strictly adhering to the requirements, such as validating the length of task names and making sure that appointment dates could not be set in the past. Regular feedback also helped refine my understanding of user needs, leading to more robust input validation and error handling, such as using 'assertThrows()' in JUnit tests to confirm proper exception handling.

How do I approach designing software?

My approach to designing software is iterative and focused on modularity and reusability. For instance, I created helper methods like 'validateInput()' to centralize validation logic and ensure consistency across all services. This reduced code duplication and made the code easier to maintain. I also used efficient data structures, such as switching from an ArrayList to a HashMap, to improve performance in managing contacts and appointments. This design choice not only optimized the code but also made it scalable for larger datasets.
