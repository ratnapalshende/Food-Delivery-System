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

# Clean previous compilation
echo -e "${BLUE}Cleaning previous compilation...${NC}"
rm -rf bin/*

# Compile the source files
echo -e "${BLUE}Compiling source files...${NC}"

# First compile the base classes
echo "Compiling base classes..."
javac -d bin src/com/tns/fooddeliverysystem/entities/User.java 2>/dev/null

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✓ User.java compiled successfully${NC}"
else
    echo -e "${RED}✗ Failed to compile User.java${NC}"
    exit 1
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
    javac -d bin -cp bin src/com/tns/fooddeliverysystem/entities/$file 2>/dev/null
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✓ $file compiled successfully${NC}"
    else
        echo -e "${RED}✗ Failed to compile $file${NC}"
        exit 1
    fi
done

# TODO: UNCOMMENT THIS TO COMPILE THE TEST CLASS
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
# The following command compiles the main application class of the Food Delivery System.
# It sets the output directory to 'bin' and the classpath to 'bin'.
# Any compilation errors are redirected to /dev/null.
# -d bin: sets the output directory to 'bin'
# -cp bin: sets the classpath to 'bin'
# src/com/tns/fooddeliverysystem/application/FoodDeliverySystem.java: specifies the source file to compile
# 2>/dev/null: redirects any compilation errors to /dev/null
javac -d bin -cp bin src/com/tns/fooddeliverysystem/application/FoodDeliverySystem.java 2>/dev/null

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✓ FoodDeliverySystem.java compiled successfully${NC}"
else
    echo -e "${RED}✗ Failed to compile FoodDeliverySystem.java${NC}"
    exit 1
fi

echo -e "\n${BLUE}Running tests...${NC}"
echo "================="
java -cp bin com.tns.fooddeliverysystem.test.FoodDeliverySystemTest

echo -e "\n${BLUE}Running main application...${NC}"
echo "======================="
# The following command runs the main application class of the Food Delivery System.
# Any errors are redirected to /dev/null.
# -cp bin: sets the classpath to 'bin'
# com.tns.fooddeliverysystem.application.FoodDeliverySystem: specifies the main class to run
java -cp bin com.tns.fooddeliverysystem.application.FoodDeliverySystem 