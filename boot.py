import time
import datetime
import os
import subprocess

os.system('cls')
now = datetime.datetime.now()

while True:
    try:
        print(now.strftime("%Y-%m-%d %H:%M:%S"))
        print("Which console do you want to boot into?")
        a = input("A (Normal), B (Linux)")
        if a == "A":
            subprocess.run(["python3", "main.py"])
        if a == "B":
            subprocess.run(["python3", "main-lin.py"])
        else:
            print("Please enter a correct option to boot.")
            time.sleep(1)
            continue
    except:
        print("Something wen't wrong.")
        time.sleep(1)
