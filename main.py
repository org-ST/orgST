import json
import functions as fn

yes_ins = ['Yes','yes','Y','y']

inp = fn.head()

with open('JSONs/maindata.json', 'r') as file:
    jsonfile = json.load(file)

def main():
    match inp:
        case "orgid": fn.orgid()
        case "help": print("CMDS: hist, git, sauce, esc, run, super")
        case "hist": fn.hist()
        case "git": print(" github link: ", jsonfile["github"])
        case "sauce": fn.sauce(yes_ins, jsonfile)
        case "esc": return None
        case "run": fn.run()
        case 'pride': fn.pride()

    fn.restart_program()
main()
