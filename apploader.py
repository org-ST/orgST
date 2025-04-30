import json
import os
import subprocess
from time import sleep

with open('apps/apps.json', 'r') as file:
    infoapp = json.load(file)




print("apploader")
a = input(">>")
if a == "apptest":
    print(infoapp["apptest"]["name"])
    print(infoapp["apptest"]["version"])
    print(infoapp["apptest"]["date"])
    sleep(1)
    os.system('cls')
    subprocess.run(["python3", "apps/app_test/apptest.py"])
if a == "salvade":
    print(infoapp["salvade"]["name"])
    print(infoapp["salvade"]["date"])
    sleep(1)
    os.system('cls')
    subprocess.run(["python3", "apps/salvade_demo/main_s.py"])