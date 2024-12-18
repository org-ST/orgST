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

with open('randdata.json', 'r') as randfile:
    randdata = json.load(randfile)
def main():
    if a=="getsuper":
        rand = [randfile["b"], randfile["c"], randfile["d"], randfile["e"], randfile["f"]]
        print(random.choice(rand))
        
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
          print("insert your supertext")
      
    
    restart_program()
main()
