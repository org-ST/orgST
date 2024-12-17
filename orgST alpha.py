import json
import sys
import os

print("orgST alpha build")
print("!DO NOT RUN THIS IN FOLDER TERMINAL!")
print("refer to help manual to get started")

a=input("input command= ")

with open('maindata.json', 'r') as file:
    jsonfile = json.load(file)

def restart_program():
    """Restarts the current program.
    Note: this function does not return. Any cleanup action (like
    saving data) must be done before calling this function."""
    python = sys.executable
    os.execl(python, python, * sys.argv)


def main():
    if a=="history":
        print("version ", jsonfile["version"])
    if a=="github":
        print(jsonfile["github"])
    if a=="credits":
        print(jsonfile["authors"])
    if a=="sauce":
        print("you found the sauce!")
    if a=="sponsors":
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
