import json
import os
import random
import subprocess
import socket
import sys


HOSTNAME = socket.gethostname()
PREV_COMMIT_NUM = "36cf28bf"

print("orgST © 2024 by Wdboyes13, progman.task")
print("orgST terminal created in 2024")
print("---------------------------------------")
print("orgST Terminal 1.6")
print("Refer to the readme for more information.")

inp = input(">...")



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

    if inp == "super":
        print(randdata[randchoice])
        print(" Would you like to update the supertext")
        i3 = input(" Enter y to change the supertext: ")
        if i3 == "Y" or "y" or "Yes" or "yes":
            with open('JSONs/randdata.json', 'w') as file:
                intext = input(" insert your supertext: ")
                randdata.update({randchoice: intext})
                json.dump(randdata, file, indent=6)


    if inp == "help":
        print("CMDS: his, git, sauce, esc, run, super")


    if inp == "hist":
        print(" version= ", jsonfile["version"])
        print(" updates=", jsonfile["updates"])
        print(" eufi ver-", jsonfile["eufi"])
        print(" authors: ", jsonfile["authors"])


    if inp == "git":
        print(" github link: ", jsonfile["github"])


    if inp == "sauce":
        print(" Would you like to dump raw data?")
        d = input(" Y/N: ")
        if d == "Y":
            print(jsonfile)



    if inp == "esc":
        return None


    if inp == "run":
        print("Run which:?")
        print("A- orgST visual | C- Channels")
        pel = input(">>")
        if pel == "A":
            subprocess.run(["python3", "PYextras/app.py"])
        if pel == "C":
            subprocess.run(["python3", "PYextras/channelviewer.py"])

        return None





    restart_program()
main()
