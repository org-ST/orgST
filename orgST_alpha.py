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
    if a=="supertext":
        rand = [randfile["b"], randfile["c"], randfile["d"], randfile["e"], randfile["f"]]
        print(random.choice(rand))
        
    if a=="licence" or "creativecommons":
        print(jsonfile["license"])
   
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
            print("dumping...")
                  
    if a=="sponsors":
        print("current sponsors")
        print(jsonfile["sponsornames"])
        
    if a=="org":
        print("would you like to start orgST setup?")
        print("Y/N")
        b=input("input command= ")
        if b=="Y" or "Yes" or "yes":
           print("support=287j48ah")

    
    restart_program()
main()
