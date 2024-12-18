import json
import sys
import os
import random

print("orgST pre-alpha terminal 1.1")
print("refer to the help manual for more information")
supertexterr="poilo"

a = input("Enter your choice: ")

with open('maindata.json', 'r') as file:
   jsonfile = json.load(file)

def restart_program():
    python = sys.executable
    os.execl(python, python, * sys.argv)

with open('randdata.json', 'r+') as json_file:
    randdata = json.load(json_file)
def main():
    keys = ["b", "c", "d", "e", "f"]
    randchoice = random.choice(keys)

    if a=="getsuper":
        print(randdata[randchoice])
        
    if a=="lis" or "CC":
        print(jsonfile["license"])
   
    if a=="his":
        print("version ", jsonfile["version"])
        
    if a=="git":
        print(jsonfile["github"])
        
    if a=="cred":
        print(jsonfile["authors"])

    if a=="eufi":
       print(jsonfile["eufi"])

   
    if a=="sauce":
        print("dump raw data?")
        d=input("Y/N")
        if d=="Y" or "Yes" or "yes":
            print("dumping...")
                  
    if a=="spon":
        print("current sponsors")
        print(jsonfile["sponsornames"])
        
    if a=="org":
       print("have you viewed the current supertext?")
       print("press * to continue, otherwise press /")
       i3 = input("...")
       if i3=="*":
           with open('randdata.json', 'w') as file:
              intext = input("insert your supertext: ")
              randdata.update({randchoice: intext})
              json.dump(randdata, file, indent=6)

    if a=="esc":
        return None

    restart_program()
main()
