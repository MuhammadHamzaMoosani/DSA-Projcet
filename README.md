##One Click Away
<img src="src/GUI/Emergency.png" alt="One Click Away Logo" width="200">


## Motivation

### Addressing Time Delays in Emergencies
- Existing delays in emergency response can lead to casualties.
- Ambulance drivers often struggle with navigation and locating callers promptly.

### Inefficient Communication with Emergency Services
- Significant time wasted in explaining locations during emergency calls.
- Users may not be aware of the appropriate emergency service to contact.

### Traffic Challenges in Urban Areas
- High traffic volume in densely populated cities like Karachi and Lahore.
- Traffic congestion contributes to delayed emergency response times.

---

## Application Features

### Efficient Emergency Alert System
- Unified alert system that notifies all registered emergency services simultaneously.

### Optimized Response and Dispatch
- Minimizes response time by dispatching the nearest available service promptly.
- Streamlines communication for faster assistance with a single-click user request.

### Adaptability to Decentralized Systems
- Tailored for regions like Karachi, which lack a centralized emergency system.
- Addresses challenges in areas without a universal emergency number.

---

## Data Structures

- **Graph**: Used predominantly to represent ambulance locations as vertices, and connections between locations as edges.
- **ArrayList**: Maintains a list of all locations.
- **HashMap**: Tracks the availability of each registered emergency vehicle.

---

## Complexity Analysis

- **`shortestPath()`**: 
  - Finds the nearest emergency vehicle.
  - Time complexity: **O(V + E)**.

- **Assigning and checking availability**:
  - Individual vehicle check: **O(1)** using a HashMap.
  - For all vehicles: **O(V + E)**.

---

## Working of the Application

1. **User Interaction**:
   - Users can easily select the type of emergency service they need (e.g., ambulance, firetruck).
   - Enter their location (e.g., *Ayesha Manzil*).

2. **Registration for Service Providers**:
   - Companies can register their drivers and vehicles in the system.
   - Each vehicle has an availability status to avoid wasting time contacting unavailable drivers.

3. **Efficient Dispatch**:
   - The system automatically finds and assigns the nearest available vehicle to the user’s location.
   - Ensures minimal response time in critical situations.

---

## About the Project

This project was developed as part of a **Data Structures and Algorithms (DSA)** course. It showcases the practical application of graph theory and efficient data structures to solve real-world problems in emergency response systems.

---

## Technologies Used

- **Programming Language**: Java
- **Algorithms**: Shortest path algorithm BFS.
- **Data Structures**: Graphs, ArrayList, HashMap.

