#!/bin/bash

# Print colorful messages
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color
BLUE='\033[0;34m'

echo -e "${BLUE}Food Delivery System Build Script${NC}"
echo "================================="

# Create bin directory if it doesn't exist
if [ ! -d "bin" ]; then
    echo -e "${BLUE}Creating bin directory...${NC}"
    mkdir bin
fi

# Clean previous compilation (optional)
if [ "$1" == "clean" ]; then
    echo -e "${BLUE}Cleaning previous compilation...${NC}"
    rm -rf bin/*
fi

# Compile the source files
echo -e "${BLUE}Compiling source files...${NC}"

# First compile the base classes
echo "Compiling base classes..."
SOURCE_FILE="src/com/tns/fooddeliverysystem/entities/User.java"
CLASS_FILE="bin/com/tns/fooddeliverysystem/entities/User.class"

if [ ! -f "$CLASS_FILE" ] || [ "$SOURCE_FILE" -nt "$CLASS_FILE" ]; then
    javac -d bin $SOURCE_FILE 2>/dev/null
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✓ User.java compiled successfully${NC}"
    else
        echo -e "${RED}✗ Failed to compile User.java${NC}"
        exit 1
    fi
else
    echo -e "${BLUE}→ User.java is up to date${NC}"
fi

# Compile all other entity classes
echo "Compiling entity classes..."
ENTITY_FILES=(
    "FoodItem.java"
    "Cart.java"
    "Customer.java"
    "DeliveryPerson.java"
    "Restaurant.java"
    "Order.java"
)

for file in "${ENTITY_FILES[@]}"; do
    SOURCE_FILE="src/com/tns/fooddeliverysystem/entities/$file"
    CLASS_FILE="bin/com/tns/fooddeliverysystem/entities/${file%.java}.class"
    
    if [ ! -f "$CLASS_FILE" ] || [ "$SOURCE_FILE" -nt "$CLASS_FILE" ]; then
        javac -d bin -cp bin $SOURCE_FILE 2>/dev/null
        if [ $? -eq 0 ]; then
            echo -e "${GREEN}✓ $file compiled successfully${NC}"
        else
            echo -e "${RED}✗ Failed to compile $file${NC}"
            exit 1
        fi
    else
        echo -e "${BLUE}→ $file is up to date${NC}"
    fi
done

# TODO: UNCOMMENT THIS TO COMPILE THE TEST CLASS also line 87-90
# Compile the test class
# echo "Compiling test class..."
# javac -d bin -cp bin src/com/tns/fooddeliverysystem/test/FoodDeliverySystemTest.java 2>/dev/null

# if [ $? -eq 0 ]; then
#     echo -e "${GREEN}✓ FoodDeliverySystemTest.java compiled successfully${NC}"
# else
#     echo -e "${RED}✗ Failed to compile FoodDeliverySystemTest.java${NC}"
#     exit 1
# fi

# Compile the main application
echo "Compiling main application..."
SOURCE_FILE="src/com/tns/fooddeliverysystem/application/FoodDeliverySystem.java"
CLASS_FILE="bin/com/tns/fooddeliverysystem/application/FoodDeliverySystem.class"

if [ ! -f "$CLASS_FILE" ] || [ "$SOURCE_FILE" -nt "$CLASS_FILE" ]; then
    javac -d bin -cp bin $SOURCE_FILE 2>/dev/null
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✓ FoodDeliverySystem.java compiled successfully${NC}"
    else
        echo -e "${RED}✗ Failed to compile FoodDeliverySystem.java${NC}"
        exit 1
    fi
else
    echo -e "${BLUE}→ FoodDeliverySystem.java is up to date${NC}"
fi

# TODO: UNCOMMENT THIS TO RUN THE TEST CLASS
# echo -e "\n${BLUE}Running tests...${NC}"
# echo "================="
# java -cp bin com.tns.fooddeliverysystem.test.FoodDeliverySystemTest

echo -e "\n${BLUE}Running main application...${NC}"
echo "======================="
# The following command runs the main application class of the Food Delivery System.
# Any errors are redirected to /dev/null.
# -cp bin: sets the classpath to 'bin'
# com.tns.fooddeliverysystem.application.FoodDeliverySystem: specifies the main class to run
java -cp bin com.tns.fooddeliverysystem.application.FoodDeliverySystem 2>/dev/null
