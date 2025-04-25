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
        case "help": print("CMDS: hist, git, sauce, esc, run, super") # ported
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