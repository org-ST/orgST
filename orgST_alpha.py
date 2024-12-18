import json
import sys
import os
import random

print("orgST pre-alpha terminal 1.1")
print("refer to the help manual for more information")
supertexterr="poilo" # what is this?

a = input("orgST: ")

with open('maindata.json', 'r') as file:
   jsonfile = json.load(file)

def restart_program():
    python = sys.executable
    os.execl(python, python, * sys.argv)

# Get the supertext
with open('randdata.json', 'r') as randfile:
    randdata = json.load(randfile)
def main():
    if a=="getsuper":
        rand = [randfile["b"], randfile["c"], randfile["d"], randfile["e"], randfile["f"]]
        print(random.choice(rand))

   # Check licence
    if a=="lis" or "CC":
        print(jsonfile["license"])

   # Check upd. history
    if a=="his":
        print("version ", jsonfile["version"])

   # Check the github link
    if a=="git":
        print(jsonfile["github"])

   # Check credits
    if a=="cred":
        print(jsonfile["authors"])

   # Check the eufi version (aka the start command's version it's downloading
    if a=="eufi":
       print(jsonfile["eufi"])

   # Dumps the raw json data files
    if a=="sauce":
        print("dump raw data?")
        d=input("Y/N")
        if d=="Y" or "Yes" or "yes":
            print("dumping...")

   # Check sponsor listings
    if a=="spon":
        print("current sponsors")
        print(jsonfile["sponsornames"])

   # download the org files with UI
    if a=="orgGET":
       

   
    if a=="org":
       print("have you viewed the current supertext?")
       print("press * to continue, otherwise press /")
       i3 = input("...")
       if i3=="*":
          print("insert your supertext")
    
    restart_program()
main()
