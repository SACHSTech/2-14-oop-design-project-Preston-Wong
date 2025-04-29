[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/LXtbW2-T)
# ICS4U OOP Design Project

See instructions [here](INSTRUCTIONS.md) for details.

![diagram](src/Assignment/2-14-oop-design.drawio.png) 

## Summary
A tool inventory system. It contains a toolbox that has a collectino of tools that have a current value, rental value, age, condtion, and specifics about the tool itself. It allows the user to rent out tools, see rental prices of a tool, and allows them to remove and add tools as needed. It includes an abstarct tool class that has 4 child classes that are used to further specify each tools rental price, current value, age, and specific details. Each child class has an enum for its specific details, like screwdriver heads or drill types, and the parent tool class has an enum class for conditions that the tool can have. 
