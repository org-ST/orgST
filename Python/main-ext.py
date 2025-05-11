"""
      orgST - A fun java console with apps
      Copyright (C) 2025  Wdboyes13, MakiDevelops, Table37

      This program is free software: you can redistribute it and/or modify
      it under the terms of the GNU General Public License as published by
      the Free Software Foundation, either version 3 of the License, or any later version.

      This program is distributed in the hope that it will be useful,
      but WITHOUT ANY WARRANTY; without even the implied warranty of
      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
      GNU General Public License for more details.

      You should have received a copy of the GNU General Public License
      along with this program.  If not, see https://www.gnu.org/licenses/.
"""
import json
import os
import random
import subprocess
import socket
import sys


HOSTNAME = socket.gethostname()
PREV_COMMIT_NUM = "36cf28bf"

yes_ins = ['Yes','yes','Y','y']

print("orgST © 2024-2025 by Wdboyes13, progman.task is licensed under CC BY-NC-ND 4.0\nhttps://creativecommons.org/licenses/by-nc-nd/4.0/")
print("orgST terminal created in 2024")
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

    if inp == "orgid":
        print(randdata[randchoice])
        print(" Would you like to update your orgID?")
        i3 = input(" Enter y to change the orgID: ")
        if yes_ins.count(i3):
            with open('JSONs/randdata.json', 'w') as file:
                intext = input(" insert your new orgID: ")
                randdata.update({randchoice: intext})
                json.dump(randdata, file, indent=6)


    if inp == "help":
        print("CMDS: hist, git, sauce, esc, run, super")


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
        if yes_ins.count(d):
            print(jsonfile)



    if inp == "esc":
        return None


    if inp == "run":
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
    
    if inp == 'pride':
        print('[insert gay flag here]')

    restart_program()
main()
