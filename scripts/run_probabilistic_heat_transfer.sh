#!/bin/bash

# Compile Java files
javac-algs4 GenerateHeatTransferTestCase.java CollisionSystem.java

# Run GenerateHeatTransferTestCase and save output to simulation_demo_input.txt by overwriting
java-algs4 GenerateHeatTransferTestCase < data/argument.txt >| data/simulation_demo_input.txt

# Run CollisionSystem with the generated input
java-algs4 CollisionSystem < data/simulation_demo_input.txt
