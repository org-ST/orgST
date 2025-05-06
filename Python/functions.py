def restart_program():
    import os
    import sys
    python = sys.executable
    os.execl(python, python, * sys.argv)


def run():
    import subprocess
    pel = input("w (Webserver), c (Channelviewer), a (Apps)\n>> ").lower()

    if pel == 'w':
        subprocess.run(['cd', 'cv', '|', 'python3', 'server.py'])
    if pel == 'c':
        subprocess.run(["python3", "PYextras/channelviewer.py"])
    if pel == 'a':
        subprocess.run(["python3", "apploader.py"])

def sauce(yes_ins, jsonfile):
        print(" Would you like to dump raw data?")
        d = input(" Y/N: ")
        if yes_ins.count(d):
            print(jsonfile)

def orgid():
    print("Creating an orgID")
    print("Please understand we are unable to recover your password")
    print("And we currently cannot change passwords")
    print("If you forget your password please make a new user")
    import orgid.client
    orgid.client.crusr()

def hist(jsonfile):
    print(" version= ", jsonfile["version"])
    print(" updates=", jsonfile["updates"])
    print(" eufi ver-", jsonfile["eufi"])
    print(" authors: ", jsonfile["authors"])

def pride():
    import subprocess
    print("OHHHHHH CAAAANADAAAAAA")
    subprocess.run(["python3", "PYextras/TheFlag.py"])

def head():
    import socket
    print(f"orgST by Wdboyes13, progman.task is marked with CC0 1.0. To view a copy of this license, visit https://creativecommons.org/publicdomain/zero/1.0/\n'orgST', 'organizationSTATION', and the orgST logo are trademarks of orgST.")
    print("---------------------------------------")
    print("orgST Terminal 1.8")
    print("! PYTHON RELEASE WILL STOP DEVELOPMENT ON 2025-05-12 !")
    print("! PLEASE SWITCH TO THE BETA JAVA VERSION !")
    print("Refer to the readme for more information.")
    inp = input(f"{socket.gethostname()} >>")
    return inp
