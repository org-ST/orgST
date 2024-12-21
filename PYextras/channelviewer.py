# Channel Viewer without UI
# Created by progman.task

import time
import os

rev = 1.2
sponsors = 4
is_looping = True

print("Gathering Channels...")
time.sleep(2)
print("Gathering Sponsor Listings...")
time.sleep(3)
print("Sponsors:")
print(sponsors)
print("Revisions:")
print(rev)




print("Channel Viewer")
print("Would you like to check the current channels?")
a = input(">...")
while is_looping:
    if a == "Y":
        print("Listings:")
        print("1. OrgST Public")
        print("2. CalcTech")
        print("3. toyathing's MMD")
        print("4. Archive")
        b = input(">...")
        if b == "1":
            print("Greetings. Welcome to the OrgST Public room.")
            print("-progman.task")
            c = input(">...")
            if c == "check":
                print("This channel is empty. Please check this at a later date.")

        elif is_looping:
            break

    else:
        print(a)
        print("is not a command.")
        break

    if a == "N":
        print("Returning to terminal...")
    if a == "HELP":
        print("-check -purchase -review -people -web")
        break
