# Channel Viewer without UI
# Created by progman.task

import time
import os
import subprocess

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
        print("1. The OrgST Public Channel")
        print("2. The CalcTech Channel")
        print("3. toyathing's MMD Channel")
        print("4. The Archive Channel")
        b = input(">...")
        if b == "1":
            print("Greetings. Welcome to the OrgST Public Channel.")
            print("-progman.task")
            c = input(">...")
            if c == "check":
                print("This channel is empty. Please check this at a later date.")
            if c == "web":
                print("This channel is empty. Please check this at a later date.")
            if c == "purchase":
                print("This channel is empty. Please check this at a later date.")
            if c == "review":
                print("There is nothing to review.")
            if c == "people":
                print("Wdboyes13, @kaycutier (progman.task)")
            if c == "info":
                print("The public orgST channel.")
        if b == "2":
            print("Greetings. Welcome to the CalcTech Channel.")
            c = input(">...")
            if c == "check":
                print("Found 1 result")
                print("Opening calctrash.py")
                time.sleep(3)
                subprocess.run(["python3", "calctrash.py"])
            if c == "web":
                print("This channel is empty. Please check this at a later date.")
            if c == "purchase":
                print("This channel is empty. Please check this at a later date.")
            if c == "review":
                print("There is nothing to review.")
            if c == "people":
                print("@chureki (Table), @kaycutier (progman.task)")
            if c == "info":
                print("A channel for CalcTech!")
        if b == "3":
            print("Greetings. Welcome to the toyathing Channel.")
            c = input(">...")
            if c == "check":
                print("This channel is empty. Please check this at a later date.")
            if c == "web":
                print("This channel is empty. Please check this at a later date.")
            if c == "purchase":
                print("This channel is empty. Please check this at a later date.")
            if c == "review":
                print("There is nothing to review.")
            if c == "people":
                print("toyathing")
            if c == "info":
                print("A channel for MMD!")
        if b == "4":
            print("Greetings. Welcome to the Archive Channel.")
            c = input(">...")
            if c == "check":
                print("This channel is empty. Please check this at a later date.")
            if c == "web":
                print("This channel is empty. Please check this at a later date.")
            if c == "purchase":
                print("This channel is empty. Please check this at a later date.")
            if c == "review":
                print("There is nothing to review.")
            if c == "people":
                print("progman.task, Wdboyes13, @chureki, toyathing")
            if c == "info":
                print("A channel that archives ANYTHING orgST. If something's missing, contact us!")



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
