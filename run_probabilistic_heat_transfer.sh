#!/bin/bash

# Detect OS and set classpath separator
if [[ "$OSTYPE" == "msys" || "$OSTYPE" == "cygwin" || "$OSTYPE" == "win32" ]]; then
    CP_SEP=";"
    MKDIR_CMD="mkdir bin 2> nul"
else
    CP_SEP=":"
    MKDIR_CMD="mkdir -p bin"
fi

# Ensure bin directory exists
eval $MKDIR_CMD

echo "Compiling Java files..."
javac -d bin/. -cp ".${CP_SEP}lib/*" src/MinPQ.java src/GenerateHeatTransferTestCase.java src/Particle.java src/CollisionSystem.java

if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

echo "Generating simulation input..."
java -cp "bin${CP_SEP}lib/*" src/GenerateHeatTransferTestCase < data/argument.txt > data/simulation_demo_input.txt

if [ $? -ne 0 ]; then
    echo "Failed to generate input!"
    exit 1
fi

echo "Running CollisionSystem..."
java -cp "bin${CP_SEP}lib/*" src/CollisionSystem < data/simulation_demo_input.txt

if [ $? -ne 0 ]; then
    echo "Simulation failed!"
    exit 1
fi

echo "Execution completed successfully!"
