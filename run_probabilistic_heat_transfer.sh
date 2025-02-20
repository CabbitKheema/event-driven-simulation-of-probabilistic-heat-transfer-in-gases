#!/bin/bash

# Compile Java files and save .class output to bin/com/simulation directory
javac -d bin -cp ".:lib/*" src/MinPQ.java src/GenerateHeatTransferTestCase.java src/Particle.java src/CollisionSystem.java

# Run GenerateHeatTransferTestCase with input from data directory and save output to simulation_demo_input.txt by overwriting
java -cp "bin:lib/*" GenerateHeatTransferTestCase < data/argument.txt >| data/simulation_demo_input.txt

# Run CollisionSystem with the generated input
java -cp "bin:lib/*" CollisionSystem < data/simulation_demo_input.txt
