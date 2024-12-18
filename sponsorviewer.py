# Sponsor viewer rev 1 without UI
# Created by progman.task

rev = 1.0
sponsors = 2

print("Gathering resources...")

# Play loading sound...
# Wait for it to load

import time

print("Sponsor viewer")
print("Would you like to check the current sponsors?")
a = input(">...")
if a == "Y":
    print("Listings:")
    print("1. orgST")
    print("2. CalcTech")
    b = input(">...")
    if b == "1":
        print("Welcome to orgST's public room!")
        print("-progman.task")
        c = input(">...")
        if c == "check":
            print(
                "We currently have no deals to offer at the moment. Please try again at a later date"
            )
    if b == "2":
        print("How about YOU try ASM+!!!!")
        print("-Table")
        c = input(">...")
        if c == "check":
            print("We have no deals to offer at the moment")
