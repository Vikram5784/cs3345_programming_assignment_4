Assignment 4 - Implemented Hash Tables

Part 1:
Implemented open addressing using linear probing

Collision Handling:
search next available slot using (index + 1) % size

Part 2:
Implemented Chaining with LinkedList

Hash Function:
Sum of ASCII values of characters in last name % table size

Reason:
Simple, fast, easy to understand, distributes names reasonably.

Initial table size = 50

Features:
Read patient.txt
Detect collisions
Display table
Rehash
