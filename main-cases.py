import json
import os
import random
import subprocess
import socket
import sys

HOSTNAME = socket.gethostname()
PREV_COMMIT_NUM = "36cf28bf"

yes_ins = ['Yes','yes','Y','y']

print(f"orgST © 2024-2025 by Wdboyes13, progman.task is licensed under CC BY-NC-ND 4.0\n'orgST', 'organizationSTATION', and the orgST logo are trademarks of orgST.")
print("---------------------------------------")
print("orgST Terminal 1.8")
print("Refer to the readme for more information.")

inp = input(HOSTNAME+" >>")

with open('JSONs/maindata.json', 'r') as file:
    jsonfile = json.load(file)



def restart_program():
    python = sys.executable
    os.execl(python, python, * sys.argv)


with open('JSONs/orgid.json', 'r+') as json_file:
    randdata = json.load(json_file)


def main():
    keys = ["b", "c", "d", "e", "f"]
    randchoice = random.choice(keys)
    match inp:
        case "orgid":
            print(randdata[randchoice])
            print(" Would you like to update your orgID?")
            i3 = input(" Enter y to change the orgID: ")
            if yes_ins.count(i3):
                with open('JSONs/randdata.json', 'w') as file:
                    intext = input(" insert your new orgID: ")
                    randdata.update({randchoice: intext})
                    json.dump(randdata, file, indent=6)


        case "help":
            print("CMDS: hist, git, sauce, esc, run, super")


        case "hist":
            print(" version= ", jsonfile["version"])
            print(" updates=", jsonfile["updates"])
            print(" eufi ver-", jsonfile["eufi"])
            print(" authors: ", jsonfile["authors"])


        case "git":
            print(" github link: ", jsonfile["github"])


        case "sauce":
            print(" Would you like to dump raw data?")
            d = input(" Y/N: ")
            if yes_ins.count(d):
                print(jsonfile)



        case "esc":
            return None


        case "run":
            print("Run which:?")
            print("A- orgST visual | C- Channels")
            pel = input(">>")
            if pel == "A" or pel == 'a':
                subprocess.run(["python3", "PYextras/app.py"])
            if pel == "C" or pel == 'c':
                subprocess.run(["python3", "PYextras/channelviewer.py"])
            else:
                print("please input the assigned letter of a certain choice, and not the name")
                print('')
                restart_program()

            return None
        
        case 'pride':
            print("OHHHHHH CAAAANADAAAAAA")
            subprocess.run(["python3", "PYextras/TheFlag.py"])

    restart_program()
main()
