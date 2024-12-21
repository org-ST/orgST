# Sponsor viewer rev 1 without UI
# Created by progman.task

rev = 1.0
sponsors = 3
is_looping = True

print("gathering sponsors")
print(sponsors)
print(rev)

# Play loading sound...
# Wait for it to load

import time

print("Sponsor viewer")
print("Would you like to check the current sponsors?")
a = input(">...")
while is_looping:
    if a == "Y":
        print("Listings:")
        print("1. orgST")
        print("2. CalcTech")
        print("3. toyathing")
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
                print("We currently have no deals to offer at the moment. Please try again at a later date")
            if c == "purchase":
                print("There is no domain for CalcTech")
            if c == "web":
                print("There is no domain for CalcTech")
        if b == "3":
            print("code thing")
            print("-toyathing")
            c=input(">...")
            if c == "check":
                print("We currently have no deals to offer at the moment. Please try again at a later date")
            if c == "purchase":
                print("There is no domain for toyathing")
            if c == "web":
                print("There is no domain for toyathing")


        elif is_looping:
            break

    if a == "N":
        print("Returning to the main terminal...")
    if a == "HELP":
        print("-check -purchase -review -people -web")
        break
