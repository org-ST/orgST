import json
import os
import random
import subprocess
import socket
import sys
from colorama import *
hostname = socket.gethostname()
print("ORGST Terminal 1.5")
print("Refer to the readme for more information.")
supertexterr="SuperStar2937"
print(Fore.GREEN, hostname, "@ OrgST % ", end="")
a = input()
print(Style.RESET_ALL)
with open('JSONs/maindata.json', 'r') as file:
    jsonfile = json.load(file)

def restart_program():
    python = sys.executable
    os.execl(python, python, * sys.argv)


with open('JSONs/randdata.json', 'r+') as json_file:
    randdata = json.load(json_file)


def main():
    keys = ["b", "c", "d", "e", "f"]
    randchoice = random.choice(keys)

    if a == "super":
        print(randdata[randchoice])
        print(" Would you like to update the supertext")
        i3 = input(" Enter y to change the supertext: ")
        if i3 == "Y" or "y" or "Yes" or "yes":
            with open('JSONs/randdata.json', 'w') as file:
                intext = input(" insert your supertext: ")
                randdata.update({randchoice: intext})
                json.dump(randdata, file, indent=6)

    if a == "help":
        print("CMDS: his, git, cred, sauce, channel, start, esc")

    if a == "his":
        print(" version ", jsonfile["version"])

    if a == "git":
        print(" github link: ", jsonfile["github"])

    if a == "cred":
        print(" authors: ", jsonfile["authors"])


    if a == "sauce":
        print(" Would you like to dump raw data?")
        d = input(" Y/N: ")
        if d == "Y":
            print(jsonfile)

    if a == "channel":
        subprocess.run(["python3", "PYextras/channelviewer.py"])
        return None

    if a == "esc":
        return None

    if a == "start":
        subprocess.run(["python3", "app.py"])
        return None


    restart_program()


main()
