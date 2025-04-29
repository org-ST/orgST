import json
import os
import subprocess

with open('JSONS/apps.json', 'r') as file:
    infoapp = json.load(file)




print("apploader")
a = input(">>")
if a == "apptest":
    print(infoapp)
    os.system('cls')
    subprocess.run(["python3", "apps/app_test/apptest.py"])
if a == "salvade":
    os.system('cls')
    subprocess.run(["python3", "apps/salvade_demo/main_s.py"])