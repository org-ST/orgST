import json
import sys
import os

print("orgST pre-alpha terminal 1.0")
print("Refer to the help manual for any questions")

a=input("orgdrive= ")

with open('maindata.json', 'r') as file:
    jsonfile = json.load(file)

def restart_program():
    """Restarts the current program.
    Note: this function does not return. Any cleanup action (like
    saving data) must be done before calling this function."""
    python = sys.executable
    os.execl(python, python, * sys.argv)


def main():
    if a=="287j48ah":
        print("licence,creativecommons,history,git,credits,sauce,sponsors,org
    if a=="licence" or "creativecommons":
        print("orgST © 2024 by Wdboyes13, progman.task is licensed under Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/"
    if a=="history":
        print("version ", jsonfile["version"])
    if a=="git":
        print(jsonfile["github"])
    if a=="credits":
        print(jsonfile["authors"])
    if a=="sauce":
        print("dump raw data?")
        d=input("Y/N")
        if d=="Y" or "Yes" or "yes":
            print("dumping...)
    if a=="sponsors":
        print("current sponsors")
        print(jsonfile["sponsornames"])
    if a=="org":
        print("would you like to start orgST setup?")
        print("Y/N")
        b=input("input command= ")
        if b=="Y" or "Yes" or "yes":
            print("searching for data.ini")
            print("data.ini not found")
            print("are you using MACOS?")
            print("Y/N")
            c=input("input command= ")
            if c=="Y" or "Yes" or "yes":
                print("MACOS is currently not supported lmao")
            if c=="N" or "No" or "no":
                print("sorry, there is nothing we can do")
    restart_program()
main()
