import json
import sys
import os
import random
import subprocess
import socket

HOSTNAME = socket.gethostname()
PREV_COMMIT_NUM = "36cf28bf"

print("ORGST Terminal 1.4-linux")
print("Refer to the readme for more information.")
print(HOSTNAME, "@ OrgST % ", end="")
inp = input()

with open('JSONs/maindata.json', 'r') as file:
    jsonfile = json.load(file)


def restart_program():
    python = sys.executable
    os.execl(python, python, *sys.argv)


with open('JSONs/randdata.json', 'r+') as json_file:
    randdata = json.load(json_file)


def main():
    keys = ["b", "c", "d", "e", "f"]
    randchoice = random.choice(keys)

    if inp == "super":
        print(randdata[randchoice])
        print(" Would you like to update the supertext")

        inp2 = input(" Enter y to change the supertext: ")

        if inp2 == "Y" or "y" or "Yes" or "yes":
            with open('JSONs/randdata.json', 'w') as file:
                intext = input(" insert your supertext: ")
                randdata.update({randchoice: intext})
                json.dump(randdata, file, indent=6)


    if inp == "his":
        print(" version ", jsonfile["version"])


    if inp == "git":
        print(" github link: ", jsonfile["github"])


    if inp == "cred":
        print(" authors: ", jsonfile["authors"])


    if inp == "eufi":
        print(jsonfile["eufi"])


    if inp == "sauce":
        print(" Would you like to dump raw data?")
        d = input(" Y/N: ")
        if d == "Y":
            print(jsonfile)


    if inp == "channel":
        subprocess.run(["python3", "PYextras/channelviewer.py"])
        return None


    if inp == "esc":
        return None


    if inp == "start":
        subprocess.run(["python3", "app.py"])
        return None


    if inp == "aero":
        print(" Aero is not supported for this TERMINAL release.")


    if inp == "pride":
        subprocess.run(["python3", "PYextras/TheFlag.py"])



    restart_program()
main()