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
import functions as fn

yes_ins = ['Yes','yes','Y','y']

inp = fn.head()

with open('JSONs/maindata.json', 'r') as file:
    jsonfile = json.load(file)
# if you see ported that means its been succesfully ported to java
# port: x  is the priority for the command to be ported
def main():
    match inp:
        case "orgid": fn.orgid() #port: 5
        case "help": print("CMDS: hist, git, sauce, esc, run") # ported
        case "hist": fn.hist() # ported
        case "git": print(" github link: ", jsonfile["github"]) #port: 1
        case "sauce": fn.sauce(yes_ins, jsonfile) # ported
        case "esc": return None #port: 2
        case "run": fn.run() #ported
        case 'pride': fn.pride() #port: 4

    fn.restart_program()
main()

"""
To be Ported:
   orgid/client.py (part of orgid command)
   PYextras/channelviewer.py
   PYextras: TheFlag
   PYextras/channelapps/calctrash.py
   Remaining Commands : See ^
Doesnt need porting:
    JSONs/* : Will be replaced by Java files containing Variable definitions
    PYextras/channelapps/apptest.py : Testing automatically done by Gradle org.orgst.AppTast

ChannelViewer To Be Ported:
    Just need to finish porting channelapps/*
    Once thats done finish check command to open them 
    ONLY port products command IF products start actually being used

"""