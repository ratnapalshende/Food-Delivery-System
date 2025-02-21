# Food Delivery System
### Work Distribution:
---

### 1. Sakshi Pingale
- **Task:** Implement the **FoodItem** class.
  - **Responsibilities:**
    - Define the private fields: `id` (int), `name` (String), `price` (double).
    - Create the constructor with parameters for `id`, `name`, and `price`.
    - Implement getters and setters for all fields.
    - Override the `toString()` method.

---

### 2. Riza Peter
- **Task:** Implement the **User** class and the **Customer** subclass.
  - **Responsibilities for User:**
    - Define private fields: `userId` (int), `username` (String), `contactNo` (long).
    - Create the constructor with parameters for these fields.
    - Implement getters and override the `toString()` method.
  - **Responsibilities for Customer:**
    - Extend the `User` class.
    - Add a private `Cart` field to represent the one-to-one relationship.
    - Implement a getter to retrieve the customer's cart.

---

### 3. Priyanka Pawar
- **Task:** Implement the **Cart** class.
  - **Responsibilities:**
    - Define a private field: `items` as a `Map<FoodItem, Integer>` (to track FoodItems and their quantities).
    - Provide a default constructor.
    - Implement the following methods:
      - `addItem(FoodItem foodItem, int quantity)`: To add/update the quantity of a FoodItem.
      - `removeItem(FoodItem foodItem)`: To remove a FoodItem from the cart.
      - `getItems()`: To return the entire map of FoodItems.
    - Override the `toString()` method.

---

### 4. Shubham Dahitule
- **Task:** Implement the **DeliveryPerson** class.
  - **Responsibilities:**
    - Define private fields: `deliveryPersonId` (int), `name` (String), `contactNo` (long).
    - Create the constructor with parameters for these fields.
    - Implement getters for each field.
    - Override the `toString()` method.

---

### 5. Ratnapal Shende
- **Task:** Implement the **Restaurant** class.
  - **Responsibilities:**
    - Define private fields: `id` (int), `name` (String), and `menu` as a `List<FoodItem>`.
    - Create the constructor with parameters for `id` and `name`.
    - Implement getters.
    - Implement the following methods:
      - `addFoodItem(FoodItem foodItem)`: To add a FoodItem to the menu.
      - `removeFoodItem(int foodItemId)`: To remove a FoodItem by its id.
    - Override the `toString()` method.

---

### 6. Ronak Parik
- **Task:** Implement the **Order** class.
  - **Responsibilities:**
    - Define private fields: `orderId` (int), `customer` (Customer), `items` as a `Map<FoodItem, Integer>`, `status` (String, default value "Pending"), `deliveryPerson` (DeliveryPerson), and `deliveryAddress` (String).
    - Create the constructor with parameters for `orderId` and `customer` (initialize other fields as needed).
    - Implement methods:
      - `addItem(FoodItem foodItem, int quantity)`: To add a FoodItem to the order.
      - Getters and setters for all relevant fields (especially for `status`, `deliveryPerson`, and `deliveryAddress`).
    - Override the `toString()` method.

---

### Integration & Collaboration
- **Integration and Testing:**  
  Once each class is implemented, we will collaboratively integrate our code into a main driver class. This will handle:
  - Instantiating objects.
  - Simulating operations such as adding items to the cart, placing orders, assigning delivery persons, etc.
  - Ensuring that the relationships between classes (like Customer-Cart and Order-DeliveryPerson) work seamlessly.

- **Documentation & Code Review:**  
  Each team member should document their code and prepare a brief summary of how their class interacts with others. We can schedule a team review session to discuss integration challenges and ensure overall coherence.

---
